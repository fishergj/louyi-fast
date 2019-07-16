package net.fisher.project.venue.order.domain;

import java.util.Date;

public class Subscribe {
	// ID 
	private int id;
	// 周几 
	private int weekDay;
	// 开始时间
	private Date fromDt;	
	// 结束时间
	private Date toDt;	
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
	public int getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}
	public Date getFromDt() {
		return fromDt;
	}
	public void setFromDt(Date fromDt) {
		this.fromDt = fromDt;
	}
	public Date getToDt() {
		return toDt;
	}
	public void setToDt(Date toDt) {
		this.toDt = toDt;
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
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
}
