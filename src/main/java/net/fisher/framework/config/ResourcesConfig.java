package net.fisher.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通用配置
 * 
 * @author jungao
 * @date Dec 13, 2018 5:34:21 PM
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
	/**
	 * 首页地址
	 */
	@Value("${shiro.user.indexUrl}")
	private String indexUrl;

	/**
	 * 默认首页的设置，当输入域名是可以自动跳转到默认指定的网页
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:" + indexUrl);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/** 文件上传路径 */
		registry.addResourceHandler("/profile/**").addResourceLocations("file:" + LouYiConfig.getProfile());

		/** swagger配置 */
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}