package net.fisher.project.system.wechat.task;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class WechatQuartzConfiguration {
	/**
	 * 配置定时任务-刷新AccessToken
	 * 
	 * @author jungao
	 * @date Dec 19, 2018 4:06:48 PM
	 */
	@Bean(name = "refreshAccessTokenJobDetail")
	public MethodInvokingJobDetailFactoryBean refreshAccessTokenJobDetail(RefreshAccessTokenJob refreshAccessTokenJob) {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		// 是否并发执行
		jobDetail.setConcurrent(true);
		// 为需要执行的实体类对应的对象
		jobDetail.setTargetObject(refreshAccessTokenJob);
		// 需要执行的方法
		jobDetail.setTargetMethod("refreshToken");
		return jobDetail;
	}

	/**
	 * 配置触发器-刷新AccessToken
	 * 
	 * @author jungao
	 * @date Dec 19, 2018 4:06:55 PM
	 */
	@Bean(name = "refreshAccessTokenSimpleTrigger")
	public SimpleTriggerFactoryBean refreshAccessTokenTriggerOnce(JobDetail refreshAccessTokenJob) {
		SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
		trigger.setJobDetail(refreshAccessTokenJob);
		// 设置任务启动延迟
		trigger.setStartDelay(1);
		trigger.setPriority(1);
		trigger.setRepeatInterval(5000);
		trigger.setRepeatCount(0);
		return trigger;
	}
	
	@Bean(name = "refreshAccessTokenCronTrigger")
	public CronTriggerFactoryBean refreshAccessTokenTrigger(JobDetail refreshAccessTokenJobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(refreshAccessTokenJobDetail);
		trigger.setPriority(1);
		// cron表达式，每过1小时执行一次
		trigger.setCronExpression("0 0 */1 * * ?");
		return trigger;
	}

	/**
	 * 配置Scheduler
	 * 
	 * @author jungao
	 * @date Dec 19, 2018 4:07:01 PM
	 */
	@Bean(name = "wechatScheduler")
	public SchedulerFactoryBean schedulerFactory(Trigger refreshAccessTokenSimpleTrigger, Trigger refreshAccessTokenCronTrigger) {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		// 延时启动，应用启动5秒后
		bean.setStartupDelay(5);
		// 注册触发器
		bean.setTriggers(refreshAccessTokenSimpleTrigger, refreshAccessTokenCronTrigger);
		return bean;
	}
}
