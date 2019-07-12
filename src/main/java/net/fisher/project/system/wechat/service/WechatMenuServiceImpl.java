package net.fisher.project.system.wechat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import net.fisher.common.utils.http.HttpClientUtils;
import net.fisher.project.system.wechat.domain.WechatMenu;
import net.fisher.project.system.wechat.dto.WechatMenuDto;
import net.fisher.project.system.wechat.mapper.WechatMenuMapper;
import net.fisher.project.system.wechat.util.WechatBasicKit;
import net.fisher.project.system.wechat.util.WechatFinalValue;

@Service("wechatMenuService")
public class WechatMenuServiceImpl implements IWechatMenuService {
	@Autowired
	private WechatMenuMapper wechatMapper;

	@Override
	public int add(WechatMenu wm) {
		if (wm.getType().equals("click"))
			wm.setMenuKey("KEY_" + System.currentTimeMillis());
		return wechatMapper.add(wm);
	}

	@Override
	public void delete(int id) {
		wechatMapper.delete(id);
	}

	@Override
	public void update(WechatMenu wm) {
		wechatMapper.update(wm);

	}

	@Override
	public WechatMenu load(int id) {
		return wechatMapper.load(id);
	}

	@Override
	public WechatMenu loadByKey(String key) {
		return wechatMapper.loadByKey(key);
	}

	@Override
	public List<WechatMenu> selectMenuList() {
		return wechatMapper.selectMenuList();
	}

	/**
	 * 自定义菜单发布
	 * 
	 * @throws Exception
	 */
	@Override
	public void publishMenu() throws Exception {
		String url = WechatBasicKit.replaceAccessTokenUrl(WechatFinalValue.MENU_ADD);
		System.out.println(url);
		List<WechatMenuDto> wmds = this.generateWechatMenuDto();
		Map<String, List<WechatMenuDto>> maps = new HashMap<String, List<WechatMenuDto>>();
		maps.put("button", wmds);
		String json = JSONObject.toJSONString(maps);
		// String json = JsonUtil.getInstance().obj2json(maps);
		// System.out.println(json);
		String rel = HttpClientUtils.https(url, json);
		if (!WechatBasicKit.checkRequestSucc(rel)) {
			throw new RuntimeException("发布菜单失败：" + WechatBasicKit.getRequestMsg(rel));
		}
	}

	/**
	 * 自定义菜单查询
	 * 
	 * @throws Exception
	 */
	@Override
	public String queryMenu() throws Exception {
		String url = WechatBasicKit.replaceAccessTokenUrl(WechatFinalValue.MENU_QUERY);
		return HttpClientUtils.https(url, "");
	}

	public List<WechatMenuDto> generateWechatMenuDto() {
		List<WechatMenu> menus = this.selectMenuList();
		List<WechatMenuDto> menuDtos = new ArrayList<WechatMenuDto>();
		WechatMenuDto wmd = null;
		for (WechatMenu wm : menus) {
			wmd = new WechatMenuDto();
			wmd.setKey(wm.getMenuKey());
			wmd.setName(wm.getName());
			wmd.setType(wm.getType());
			wmd.setId(wm.getId());
			wmd.setUrl(wm.getUrl());
			if (wm.getPid() == null || wm.getPid() == 0) {
				if (wmd.getSub_button() == null) {
					wmd.setSub_button(new ArrayList<WechatMenuDto>());
				}
				menuDtos.add(wmd);
			} else {
				WechatMenuDto twmd = findById(wm.getPid(), menuDtos);
				if (twmd == null)
					throw new RuntimeException("菜单的父类对象有问题，请检查");
				twmd.getSub_button().add(wmd);
			}
		}
		return menuDtos;
	}

	private WechatMenuDto findById(int id, List<WechatMenuDto> wmds) {
		for (WechatMenuDto wmd : wmds) {
			if (wmd.getId() == id) {
				return wmd;
			}
		}
		return null;
	}

}
