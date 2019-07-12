package net.fisher.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import net.fisher.project.system.wechat.domain.AccessToken;

/**
 * 微信配置
 * 
 * @author jungao
 * @date Dec 14, 2018 4:05:41 PM
 */
@Configuration
public class WechatConfig {
	@Value("${spring.wechat.appID}")
	private String appID;

	@Value("${spring.wechat.appsecret}")
	private String appsecret;

	@Value("${spring.wechat.base_url}")
	private String baseUrl;

	@Value("${spring.wechat.wechat_token}")
	private String token;

	private AccessToken accessToken;

	public AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
