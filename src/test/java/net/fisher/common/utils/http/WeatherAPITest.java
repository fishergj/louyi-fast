package net.fisher.common.utils.http;

import org.junit.Test;

import net.fisher.project.system.wechat.util.WeatherFinalValue;
import net.fisher.project.system.wechat.util.WechatFinalValue;

public class WeatherAPITest {
	@Test
	public void testWeatherAPI() throws Exception {
		String get = HttpClientUtils.getMethodGetResponse(WeatherFinalValue.ZDZ_URL);
		System.out.println(get);
	}
	
	@Test
	public void testAccessToken() throws Exception {
		String url = WechatFinalValue.ACCESS_TOKEN_URL;
		//WechatConfig wechatConfig = (WechatConfig) SpringUtils.getBean("wechatConfig");
		
		url = url.replaceAll("APPID", "wx87d8b9913403cdaa");
		url = url.replaceAll("APPSECRET", "e947a8f7f363ada841a54be2d2cf7210");
		String content = HttpClientUtils.https(url, "");
		System.out.println(content);
	}
}
