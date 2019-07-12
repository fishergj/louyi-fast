package net.fisher.project.system.wechat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.fisher.project.system.wechat.util.WeatherFinalValue;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import net.fisher.common.utils.http.HttpClientUtils;

public class TestWeatherAPI {
	SimpleDateFormat _sdf_nq_orgin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void testZdz() throws Exception {
		String json = HttpClientUtils.getMethodGetResponse(WeatherFinalValue.ZDZ_URL);
		JSONArray jarray = JSONArray.parseArray(json);
		System.out.println(jarray.size());
		for (int i = 0; i < jarray.size(); i++) {
			JSONObject jobj = jarray.getJSONObject(i);
			if (jobj.get("station").toString().equals("58365")) {//"station": "58365",
				System.out.println(jobj.toString());
			}
		}
		
	}
	
	/*@Test
	public void testZdz24() {
		try {
			String json = HttpClientUtils.getMethodGetResponse(WeatherFinalValue.ZDZ_24_URL);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void testTime() throws ParseException {
		String time = "2018-07-17 12:34:00.000";
		System.out.println(_sdf_nq_orgin.format(_sdf_nq_orgin.parse(time)));
		
		double d=12.3456;
		double res=((int)(d*100))/100.0;
		System.out.println(res);
		 
		//第4种方法. 
		double d2=0;
		double res2=Math.round(d2*10)/10.0;
		System.out.println(res2);
		
	}
}
