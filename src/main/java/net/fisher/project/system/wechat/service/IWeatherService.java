package net.fisher.project.system.wechat.service;

import net.fisher.project.system.wechat.domain.Hyt;

import java.util.List;

public interface IWeatherService {
    List<Hyt> queryHytList();

    Hyt showHytLast(String imei);

    List<Hyt> showHyt24(String imei);

}
