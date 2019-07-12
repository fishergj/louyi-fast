package net.fisher.project.system.wechat.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Zdz implements Serializable {

	private static final long serialVersionUID = 1L;

	// 数据时次
	private String date;

	// 站号
	private String station;

	// 站名
	private String stationname;

	// 能见度
	private double instant_vis;

	// 两分钟平均风向
	private double two_aver_wd;

	// 两分钟平均风速
	private double two_aver_ws;

	// 瞬时风向
	private double instant_wd;

	// 瞬时风速
	private double instant_ws;

	// 最大阵风风向
	private double max_flu_wd;

	// 最大阵风风速
	private double max_flu_ws;

	// 降雨量（分钟累计）
	private double one_rain;

	// 温度
	private double temper;

	// 最高气温
	private double max_temper;

	// 最高气温时间
	private String max_temp_time;

	// 最低气温
	private double min_temper;

	// 最低气温时间
	private String min_temp_time;

	// 相对湿度
	private double rel_humi;

	// 最小相对湿度
	private double min_relhumi;

	// 最小相对湿度时间
	private String min_relhumi_time;

	// 气压
	private double air_press;

	// 最小能见度
	private double min_instant_vis;
}
