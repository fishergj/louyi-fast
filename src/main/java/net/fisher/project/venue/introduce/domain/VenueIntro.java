package net.fisher.project.venue.introduce.domain;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 场馆介绍 sys_notice
 * 
 * @author jungao
 * @date Dec 14, 2018 2:02:59 PM
 */
public class VenueIntro {
	private int id;
	// 标题
	private String title;
	// 场馆图片url
	private String img_url;
	// 场馆介绍
	private String content;
	// 介绍类型
	private int introduceType;
	// 场馆Id
	private int venueId;
	// 场馆名称
	private String venueName;
	// 排序
	private int sort;
	
	private Date create_time;

	private Date update_time;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	public int getIntroduceType() {
		return introduceType;
	}

	public void setIntroduceType(int introduceType) {
		this.introduceType = introduceType;
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

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
