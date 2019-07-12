package net.fisher.project.system.wechat.domain;

import java.io.Serializable;

public class Hyt implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String uploadTime;

	private String imei;

	private double airTemperature;

	private double airHumidity;

	private double leafTemp;

	private double photoEff;

	private double co2;

	private double vsic10;

	private double vsic20;

	private double vsic30;

	private double vsic40;

	private double swc10;

	private double swc20;

	private double swc30;

	private double swc40;

	private double st10;

	private double st20;

	private double st30;

	private double st40;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public double getAirTemperature() {
		return Math.round(airTemperature * 10) / 10.0;
	}

	public void setAirTemperature(double airTemperature) {
		this.airTemperature = airTemperature;
	}

	public double getAirHumidity() {
		return Math.round(airHumidity * 10) / 10.0;
	}

	public void setAirHumidity(double airHumidity) {
		this.airHumidity = airHumidity;
	}

	public double getLeafTemp() {
		return Math.round(leafTemp * 10) / 10.0;
	}

	public void setLeafTemp(double leafTemp) {
		this.leafTemp = leafTemp;
	}

	public double getPhotoEff() {
		return Math.round(photoEff * 10) / 10.0;
	}

	public void setPhotoEff(double photoEff) {
		this.photoEff = photoEff;
	}

	public double getCo2() {
		return Math.round(co2 * 10) / 10.0;
	}

	public void setCo2(double co2) {
		this.co2 = co2;
	}

	public int getVsic10() {
		int vsic10_1 = (int)this.vsic10;
		return vsic10_1;
	}

	public void setVsic10(double vsic10) {
		this.vsic10 = vsic10;
	}

	public int getVsic20() {
		int vsic20_1 = (int)this.vsic20;
		return vsic20_1;
	}

	public void setVsic20(double vsic20) {
		this.vsic20 = vsic20;
	}

	public int getVsic30() {
		int vsic30_1 = (int)this.vsic30;
		return vsic30_1;
	}

	public void setVsic30(double vsic30) {
		this.vsic30 = vsic30;
	}

	public int getVsic40() {
		int vsic40_1 = (int)this.vsic40;
		return vsic40_1;
	}

	public void setVsic40(double vsic40) {
		this.vsic40 = vsic40;
	}

	public double getSwc10() {
		return Math.round(swc10 * 10) / 10.0;
	}

	public void setSwc10(double swc10) {
		this.swc10 = swc10;
	}

	public double getSwc20() {
		return Math.round(swc20 * 10) / 10.0;
	}

	public void setSwc20(double swc20) {
		this.swc20 = swc20;
	}

	public double getSwc30() {
		return Math.round(swc30 * 10) / 10.0;
	}

	public void setSwc30(double swc30) {
		this.swc30 = swc30;
	}

	public double getSwc40() {
		return Math.round(swc40 * 10) / 10.0;
	}

	public void setSwc40(double swc40) {
		this.swc40 = swc40;
	}

	public double getSt10() {
		return Math.round(st10 * 10) / 10.0;
	}

	public void setSt10(double st10) {
		this.st10 = st10;
	}

	public double getSt20() {
		return Math.round(st20 * 10) / 10.0;
	}

	public void setSt20(double st20) {
		this.st20 = st20;
	}

	public double getSt30() {
		return Math.round(st30 * 10) / 10.0;
	}

	public void setSt30(double st30) {
		this.st30 = st30;
	}

	public double getSt40() {
		return Math.round(st40 * 10) / 10.0;
	}

	public void setSt40(double st40) {
		this.st40 = st40;
	}

}
