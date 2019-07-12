package net.fisher.project.monitor.job.task;

import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 
 * @author jungao
 * @date Dec 14, 2018 2:09:12 PM
 */
@Component("louYiTask")
public class LouYiTask {
	public void louYiParams(String params) {
		System.out.println("执行有参方法：" + params);
	}

	public void louYiNoParams() {
		System.out.println("执行无参方法");
	}
}
