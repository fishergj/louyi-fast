package net.fisher.project.venue.order.domain;

import java.util.Date;

public class SubscribeDetail {
	// ID 
	private int id;
	// 周几 
	private int weekDay;
	// 日期 
	private Date subscribeDate;
	// 预约时间开始 
	private Date subscribeFromDt;
	// 预约时间结束 
	private Date subscribeToDt;
	// 1-可用；2-不可用 
	private String enabled;
	// 团队预约时间类型（0-是；1-否）
	private String typeTeam;
	// 个人预约时间类型（0-是；1-否） 
	private String typePerson;
	// 场馆Id 
	private int venueId;
	// 创建时间
	private Date create_time;
	// 更新时间 
	private Date update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSubscribeDate() {
		return subscribeDate;
	}
	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
	public Date getSubscribeFromDt() {
		return subscribeFromDt;
	}
	public void setSubscribeFromDt(Date subscribeFromDt) {
		this.subscribeFromDt = subscribeFromDt;
	}
	public Date getSubscribeToDt() {
		return subscribeToDt;
	}
	public void setSubscribeToDt(Date subscribeToDt) {
		this.subscribeToDt = subscribeToDt;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getTypeTeam() {
		return typeTeam;
	}
	public void setTypeTeam(String typeTeam) {
		this.typeTeam = typeTeam;
	}
	public String getTypePerson() {
		return typePerson;
	}
	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}
}
