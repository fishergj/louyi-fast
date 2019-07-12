package net.fisher.project.monitor.job.util;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import net.fisher.common.constant.Constants;
import net.fisher.common.constant.ScheduleConstants;
import net.fisher.common.utils.StringUtils;
import net.fisher.common.utils.bean.BeanUtils;
import net.fisher.common.utils.spring.SpringUtils;
import net.fisher.project.monitor.job.domain.Job;
import net.fisher.project.monitor.job.domain.JobLog;
import net.fisher.project.monitor.job.service.IJobLogService;

/**
 * 定时任务
 * 
 * @author jungao
 * @date Dec 13, 2018 5:05:37 PM
 */
@DisallowConcurrentExecution
public class ScheduleJob extends QuartzJobBean {
	private static final Logger log = LoggerFactory.getLogger(ScheduleJob.class);

	private ExecutorService service = Executors.newSingleThreadExecutor();

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Job job = new Job();
		BeanUtils.copyBeanProp(job, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES));

		IJobLogService jobLogService = (IJobLogService) SpringUtils.getBean(IJobLogService.class);

		JobLog jobLog = new JobLog();
		jobLog.setJobName(job.getJobName());
		jobLog.setJobGroup(job.getJobGroup());
		jobLog.setMethodName(job.getMethodName());
		jobLog.setMethodParams(job.getMethodParams());
		jobLog.setCreateTime(new Date());

		long startTime = System.currentTimeMillis();

		try {
			// 执行任务
			log.info("任务开始执行 - 名称：{} 方法：{}", job.getJobName(), job.getMethodName());
			ScheduleRunnable task = new ScheduleRunnable(job.getJobName(), job.getMethodName(), job.getMethodParams());
			Future<?> future = service.submit(task);
			future.get();
			long times = System.currentTimeMillis() - startTime;
			// 任务状态 0：成功 1：失败
			jobLog.setStatus(Constants.SUCCESS);
			jobLog.setJobMessage(job.getJobName() + " 总共耗时：" + times + "毫秒");

			log.info("任务执行结束 - 名称：{} 耗时：{} 毫秒", job.getJobName(), times);
		} catch (Exception e) {
			log.info("任务执行失败 - 名称：{} 方法：{}", job.getJobName(), job.getMethodName());
			log.error("任务执行异常  - ：", e);
			long times = System.currentTimeMillis() - startTime;
			jobLog.setJobMessage(job.getJobName() + " 总共耗时：" + times + "毫秒");
			// 任务状态 0：成功 1：失败
			jobLog.setStatus(Constants.FAIL);
			jobLog.setExceptionInfo(StringUtils.substring(e.getMessage(), 0, 2000));
		} finally {
			jobLogService.addJobLog(jobLog);
		}
	}
}
