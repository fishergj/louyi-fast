package net.fisher.project.venue.introduce.domain;

import java.util.Date;

import com.alibaba.fastjson.JSON;

public class Venue {
	
	private int id;
	// 场馆名称 
    private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
