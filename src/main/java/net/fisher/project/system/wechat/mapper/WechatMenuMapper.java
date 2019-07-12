package net.fisher.project.system.wechat.mapper;

import java.util.List;

import net.fisher.project.system.wechat.domain.WechatMenu;

public interface WechatMenuMapper {
	public WechatMenu loadByKey(String key);

	public List<WechatMenu> selectMenuList();

	public int add(WechatMenu wm);

	public void delete(int id);

	public void update(WechatMenu wm);

	public WechatMenu load(int id);
}
