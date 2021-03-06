package net.fisher.project.system.wechat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WechatMenuDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String key;
	private String type;
	private String url;
	private List<WechatMenuDto> sub_button = new ArrayList<WechatMenuDto>();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WechatMenuDto> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WechatMenuDto> sub_button) {
		this.sub_button = sub_button;
	}
}
