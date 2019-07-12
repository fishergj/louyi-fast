package net.fisher.framework.aspectj.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.fisher.framework.aspectj.lang.enums.DataSourceType;

/**
 * 自定义多数据源切换注解
 * 
 * @author jungao
 * @date Dec 8, 2018 1:18:21 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
	/**
	 * 切换数据源名称
	 */
	public DataSourceType value() default DataSourceType.MASTER;
}
