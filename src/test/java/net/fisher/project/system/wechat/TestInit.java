package net.fisher.project.system.wechat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fisher.project.system.wechat.domain.AccessToken;
import net.fisher.project.system.wechat.domain.WechatMenu;
import net.fisher.project.system.wechat.dto.WechatMenuDto;
import net.fisher.project.system.wechat.util.WechatFinalValue;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestInit {
	private static final String PREFIX_URL = "http://louyi.imwork.net";
/*	@Test
	public void testSha1() {
		// SecurityKit.sha1("hello");
		// byte a = 3;
		// System.out.println(String.format("%02x", a));
		String sha1 = SecurityKit.sha1("hello");
		System.out.println(sha1);
	}*/



	private String accessToken = "23_fz1vq9RuI6Z7u6_4TPn-K6ONQvzpsGOqlmo5hoiXKQATtE9sKewjVNxgYF6bX0XxLhs4CllfBOJUy5uPeEHjmkADDCvik5lYIvQMi3IcUf2xkp-N6wWoumyoK3XAhH9fviWo7_wwgaw6aKgpDHUeAEAHLY";
	
	/**
	 * 获取AccessToken
	 */
	@Test
	public void testHttpClient() {
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			String url = WechatFinalValue.ACCESS_TOKEN_URL;
//			url = url.replaceAll("APPID", WechatFinalValue.appId);
//			url = url.replaceAll("APPSECRET", WechatFinalValue.appsecret);
			url = url.replaceAll("APPID", "wxf3d8985e96e0af37");
			url = url.replaceAll("APPSECRET", "2690e82fe3c07f63d2ae1baf0c085b89");
			System.out.println(url);
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse resp = client.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				HttpEntity entity = resp.getEntity();
				String content = EntityUtils.toString(entity);
				AccessToken at = (AccessToken)JSON.parseObject(content, AccessToken.class);
				System.out.println(at.getAccess_token()+","+at.getExpires_in());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMenu() {
		try {
			List<WechatMenuDto> wms = new ArrayList<WechatMenuDto>();

			/**
			 * 场馆介绍
			 */
			WechatMenuDto wmVenue = new WechatMenuDto();
			wmVenue.setName("场馆介绍");

			List<WechatMenuDto> wmVenueSub = new ArrayList<WechatMenuDto>();

			WechatMenuDto wmVenueIntro = new WechatMenuDto();
			wmVenueIntro.setId(1);
			wmVenueIntro.setName("场馆概述");
			wmVenueIntro.setType("view");
			wmVenueIntro.setUrl(PREFIX_URL + "/wechat/meseum/intro");
			wmVenueSub.add(wmVenueIntro);

			WechatMenuDto wmVenueGuide = new WechatMenuDto();
			wmVenueGuide.setId(2);
			wmVenueGuide.setName("场馆导览");
			wmVenueGuide.setType("view");
			wmVenueGuide.setUrl(PREFIX_URL + "/wechat/meseum/guide");
			wmVenueSub.add(wmVenueGuide);

			WechatMenuDto wmVenueExhibit = new WechatMenuDto();
			wmVenueExhibit.setId(3);
			wmVenueExhibit.setName("展品介绍");
			wmVenueExhibit.setType("view");
			wmVenueExhibit.setUrl(PREFIX_URL + "/wechat/meseum/exhibit");
			wmVenueSub.add(wmVenueExhibit);

			WechatMenuDto wmVenueMoment = new WechatMenuDto();
			wmVenueMoment.setId(4);
			wmVenueMoment.setName("展品介绍");
			wmVenueMoment.setType("view");
			wmVenueMoment.setUrl(PREFIX_URL + "/wechat/meseum/moment");
			wmVenueSub.add(wmVenueMoment);

			wmVenue.setSub_button(wmVenueSub);

			/**
			 * 嘉定天气
			 */
			WechatMenuDto wmWeather = new WechatMenuDto();
			wmWeather.setName("嘉定天气");

			List<WechatMenuDto> wmWeatherSub = new ArrayList<WechatMenuDto>();

			WechatMenuDto wmZdz = new WechatMenuDto();
			wmZdz.setId(1);
			wmZdz.setName("天气实况");
			wmZdz.setType("view");
			wmZdz.setUrl(PREFIX_URL + "/wechat/weather/zdz");
			wmWeatherSub.add(wmZdz);

			WechatMenuDto wmFarm = new WechatMenuDto();
			wmFarm.setId(2);
			wmFarm.setName("农业气象");
			wmFarm.setType("view");
			wmFarm.setUrl(PREFIX_URL + "/wechat/weather/farm");
			wmWeatherSub.add(wmFarm);

			wmWeather.setSub_button(wmWeatherSub);

			/**
			 * 预约服务
			 */
			WechatMenuDto wmReserve = new WechatMenuDto();
			wmReserve.setName("预约服务");

			List<WechatMenuDto> wmReserveSub = new ArrayList<WechatMenuDto>();

			WechatMenuDto wmReserveDo = new WechatMenuDto();
			wmReserveDo.setId(1);
			wmReserveDo.setName("参观预约");
			wmReserveDo.setType("view");
			wmReserveDo.setUrl(PREFIX_URL + "/wechat/reserve");
			wmReserveSub.add(wmReserveDo);

			WechatMenuDto wmReserveQuery = new WechatMenuDto();
			wmReserveQuery.setId(2);
			wmReserveQuery.setName("预约查询");
			wmReserveQuery.setType("view");
			wmReserveQuery.setUrl(PREFIX_URL + "/wechat/reserve/query");
			wmReserveSub.add(wmReserveQuery);

			WechatMenuDto wmReserveNavigate = new WechatMenuDto();
			wmReserveNavigate.setId(3);
			wmReserveNavigate.setName("一键导航");
			wmReserveNavigate.setType("view");
			wmReserveNavigate.setUrl(PREFIX_URL + "/wechat/reserve/navigate");
			wmReserveSub.add(wmReserveNavigate);

			WechatMenuDto wmReserveRecommend = new WechatMenuDto();
			wmReserveRecommend.setId(4);
			wmReserveRecommend.setName("留言建议");
			wmReserveRecommend.setType("view");
			wmReserveRecommend.setUrl(PREFIX_URL + "/wechat/reserve/recommend");
			wmReserveSub.add(wmReserveRecommend);

			wmReserve.setSub_button(wmReserveSub);

			wms.add(wmVenue);
			wms.add(wmWeather);
			wms.add(wmReserve);

			Map<String,List<WechatMenuDto>> maps = new HashMap<String,List<WechatMenuDto>>();
			maps.put("button",wms);
			String json = JSON.toJSONString(maps);


			/********************************/
			CloseableHttpClient client = HttpClients.createDefault();
			String url = WechatFinalValue.MENU_ADD;
			url = url.replace("ACCESS_TOKEN", accessToken);
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type","application/json");
			StringEntity entity = new StringEntity(json, 
					ContentType.create("application/json", "utf-8"));
			post.setEntity(entity);
			CloseableHttpResponse resp = client.execute(post);
			int sc = resp.getStatusLine().getStatusCode();
			if(sc>=200&&sc<300) {
				System.out.println(EntityUtils.toString(resp.getEntity()));
			}
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void testMsg() {
//		try {
			Map<String,String> maps = new HashMap<String, String>();
			maps.put("123", "abc");
			maps.put("bcd", "222");
			maps.put("bcd", "<abc>ddd</abc>");
//			System.out.println(MessageKit.map2xml(maps));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void testPostMedia() {
//		String mid = MediaKit.postMedia("d:/02.jpg", "image");
//		System.out.println(mid);
	}
	
	@Test
	public void testGetMedia() {
		try {
			//MediaKit.getMedia("_I53ClKoGvcQC4z1mWLf-O_nDJ_rw2p-LtfJOslSONSzUEtv8eKEvlDbn8m71d9m",new File("f:/aaaa.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
