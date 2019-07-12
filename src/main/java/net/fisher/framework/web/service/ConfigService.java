package net.fisher.framework.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fisher.project.system.config.service.IConfigService;

/**
 * html调用 thymeleaf 实现参数管理
 * 
 * @author jungao
 * @date Dec 13, 2018 4:28:39 PM
 */
@Service("config")
public class ConfigService {
	@Autowired
	private IConfigService configService;

	/**
	 * 根据键名查询参数配置信息
	 * 
	 * @param configName
	 *            参数名称
	 * @return 参数键值
	 */
	public String getKey(String configKey) {
		return configService.selectConfigByKey(configKey);
	}

}
