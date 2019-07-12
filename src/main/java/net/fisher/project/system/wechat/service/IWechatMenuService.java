package net.fisher.project.system.wechat.service;

import java.util.List;

import net.fisher.project.system.wechat.domain.WechatMenu;
import net.fisher.project.system.wechat.dto.WechatMenuDto;

public interface IWechatMenuService {
	public WechatMenu loadByKey(String key);

	public List<WechatMenu> selectMenuList();

	public int add(WechatMenu wm);

	public void delete(int id);

	public void update(WechatMenu wm);

	public WechatMenu load(int id);

	public List<WechatMenuDto> generateWechatMenuDto();

	/**
	 * 发布自定义菜单
	 * 
	 * @author jungao
	 * @throws Exception 
	 * @date Dec 18, 2018 4:08:44 PM
	 */
	public void publishMenu() throws Exception;

	/**
	 * 查询自定义菜单
	 * 
	 * @author jungao
	 * @throws Exception 
	 * @date Dec 18, 2018 4:08:55 PM
	 */
	public String queryMenu() throws Exception;
}
