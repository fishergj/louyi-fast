package net.fisher.framework.aspectj.lang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据权限过滤注解
 * 
 * @author jungao
 * @date Dec 8, 2018 1:18:11 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
	/**
	 * 表的别名
	 */
	public String tableAlias() default "";
}
