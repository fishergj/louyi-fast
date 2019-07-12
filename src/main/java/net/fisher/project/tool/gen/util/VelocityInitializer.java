package net.fisher.project.tool.gen.util;

import java.util.Properties;

import org.apache.velocity.app.Velocity;

import net.fisher.common.constant.Constants;

/**
 * VelocityEngine工厂
 * 
 * @author jungao
 * @date Dec 8, 2018 1:28:43 PM
 */
public class VelocityInitializer {
	/**
	 * 初始化vm方法
	 */
	public static void initVelocity() {
		Properties p = new Properties();
		try {
			// 加载classpath目录下的vm文件
			p.setProperty("file.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			// 定义字符集
			p.setProperty(Velocity.ENCODING_DEFAULT, Constants.UTF8);
			p.setProperty(Velocity.OUTPUT_ENCODING, Constants.UTF8);
			// 初始化Velocity引擎，指定配置Properties
			Velocity.init(p);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
