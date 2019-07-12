package net.fisher.project.system.wechat.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import net.fisher.common.utils.http.HttpClientUtils;
import net.fisher.common.utils.spring.SpringUtils;
import net.fisher.framework.config.WechatConfig;
import net.fisher.project.system.wechat.domain.AccessToken;
import net.fisher.project.system.wechat.util.WechatBasicKit;
import net.fisher.project.system.wechat.util.WechatFinalValue;

@Component
@Configuration
@EnableScheduling
public class RefreshAccessTokenJob {
	
	public void refreshToken() throws Exception {
		String url = WechatFinalValue.ACCESS_TOKEN_URL;
		WechatConfig wechatConfig = (WechatConfig) SpringUtils.getBean("wechatConfig");
		
		url = url.replaceAll("APPID", wechatConfig.getAppID());
		url = url.replaceAll("APPSECRET", wechatConfig.getAppsecret());
		String content = HttpClientUtils.https(url, "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()) + "-> " + content);
		if(WechatBasicKit.checkRequestSucc(content)) {
			AccessToken accessToken = (AccessToken) JSONObject.parseObject(content, AccessToken.class);
			wechatConfig.setAccessToken(accessToken);
			System.out.println(sdf.format(new Date()) + "-> " + wechatConfig.getAccessToken());
		} else {
			refreshToken();
		}
	}
	
	public void refreshTokenOnce() throws Exception {
		String url = WechatFinalValue.ACCESS_TOKEN_URL;
		WechatConfig wechatConfig = (WechatConfig) SpringUtils.getBean("wechatConfig");
		
		url = url.replaceAll("APPID", wechatConfig.getAppID());
		url = url.replaceAll("APPSECRET", wechatConfig.getAppsecret());
		String content = HttpClientUtils.https(url, "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()) + "-> " + content);
		if(WechatBasicKit.checkRequestSucc(content)) {
			AccessToken accessToken = (AccessToken) JSONObject.parseObject(content, AccessToken.class);
			wechatConfig.setAccessToken(accessToken);
			System.out.println("refreshAccessTokenTriggerOnce run...");
			System.out.println(sdf.format(new Date()) + "-> " + wechatConfig.getAccessToken());
		} else {
			refreshToken();
		}
	}
}
