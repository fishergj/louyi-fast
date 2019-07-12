package net.fisher.project.system.wechat.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

import net.fisher.common.utils.http.HttpClientUtils;
import net.fisher.common.utils.spring.SpringUtils;
import net.fisher.framework.config.WechatConfig;
import net.fisher.project.system.wechat.domain.AccessToken;
import net.fisher.project.system.wechat.util.WechatBasicKit;
import net.fisher.project.system.wechat.util.WechatFinalValue;

//@Component("wechatTask")
public class WechatTask {
	public void refreshToken() throws Exception {
		String url = WechatFinalValue.ACCESS_TOKEN_URL;
		WechatConfig wechatConfig = (WechatConfig) SpringUtils.getBean("wechatConfig");
		
		url = url.replaceAll("APPID", wechatConfig.getAppID());
		url = url.replaceAll("APPSECRET", wechatConfig.getAppsecret());
		String content = HttpClientUtils.https(url, "");
		if(WechatBasicKit.checkRequestSucc(content)) {
			AccessToken accessToken = (AccessToken) JSONObject.parseObject(content, AccessToken.class);
			wechatConfig.setAccessToken(accessToken);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(new Date()) + "-> " + wechatConfig.getAccessToken());
		} else {
			refreshToken();
		}
	}
}