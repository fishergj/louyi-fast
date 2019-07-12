package net.fisher.project.system.wechat.service;

import net.fisher.framework.aspectj.lang.annotation.DataSource;
import net.fisher.framework.aspectj.lang.enums.DataSourceType;
import net.fisher.project.system.wechat.domain.Hyt;

import java.util.List;

public interface IWeatherService {

	@DataSource(DataSourceType.SLAVE)
	List<Hyt> queryHytList();

	@DataSource(DataSourceType.SLAVE)
	Hyt showHytLast(String imei);

	@DataSource(DataSourceType.SLAVE)
	List<Hyt> showHyt24(String imei);

}
