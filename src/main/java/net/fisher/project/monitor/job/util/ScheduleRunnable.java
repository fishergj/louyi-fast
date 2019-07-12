package net.fisher.project.monitor.job.util;

import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;

import net.fisher.common.utils.StringUtils;
import net.fisher.common.utils.spring.SpringUtils;

/**
 * 执行定时任务
 * 
 * @author jungao
 * @date Dec 13, 2018 5:05:53 PM
 */
public class ScheduleRunnable implements Runnable {
	private Object target;
	private Method method;
	private String params;

	public ScheduleRunnable(String beanName, String methodName, String params)
			throws NoSuchMethodException, SecurityException {
		this.target = SpringUtils.getBean(beanName);
		this.params = params;

		if (StringUtils.isNotEmpty(params)) {
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		} else {
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}

	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if (StringUtils.isNotEmpty(params)) {
				method.invoke(target, params);
			} else {
				method.invoke(target);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
