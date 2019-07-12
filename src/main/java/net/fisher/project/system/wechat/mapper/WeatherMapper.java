package net.fisher.project.system.wechat.mapper;

import java.util.List;

import net.fisher.project.system.wechat.domain.Hyt;
import org.apache.ibatis.annotations.Param;

public interface WeatherMapper {
	
	List<Hyt> queryHytList();

	Hyt showHytLast(@Param("imei") String imei);

	List<Hyt> showHyt24(@Param("imei") String imei);

}
