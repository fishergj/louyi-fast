package net.fisher.project.system.wechat.service;

import java.util.List;

import net.fisher.project.system.wechat.domain.Hyt;
import net.fisher.project.system.wechat.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("weatherService")
public class WeatherServiceImpl implements IWeatherService {
	@Autowired 
	private WeatherMapper weatherMapper;
	
	@Override
	public List<Hyt> queryHytList() {
		return weatherMapper.queryHytList();
	}

	@Override
	public Hyt showHytLast(String imei) {
		return weatherMapper.showHytLast(imei);
	}

	@Override
	public List<Hyt> showHyt24(String imei) {
		return weatherMapper.showHyt24(imei);
	}

}
