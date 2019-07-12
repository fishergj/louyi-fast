package net.fisher.project.system.wechat.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.fisher.common.utils.http.HttpClientUtils;
import net.fisher.framework.web.controller.BaseController;
import net.fisher.project.system.wechat.domain.Hyt;
import net.fisher.project.system.wechat.domain.Zdz;
import net.fisher.project.system.wechat.service.IWeatherService;
import net.fisher.project.system.wechat.util.WeatherFinalValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 嘉定天气
 */
@Controller
@RequestMapping("/wechat/weather")
public class WechatWeatherController extends BaseController {
    private String prefix = "system/weather";

    @Autowired
    private IWeatherService weatherService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d H:m:s");
    //SimpleDateFormat _sdf = new SimpleDateFormat("MM/dd HH:mm:ss");
    SimpleDateFormat _sdf = new SimpleDateFormat("HH:mm");
    SimpleDateFormat _sdf_nq = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value="/zdz", method= RequestMethod.GET)
    public String zdz() {
        return prefix + "/zdz";
    }

    @GetMapping("/showZdz")
    @ResponseBody
    public Zdz showZdz() throws Exception {
        String json = HttpClientUtils.getMethodGetResponse(WeatherFinalValue.ZDZ_URL);
        JSONArray jarray = JSONArray.parseArray(json);
        for (int i = 0; i < jarray.size(); i++) {
            JSONObject jobj = jarray.getJSONObject(i);
            if (jobj.get("station").toString().equals("58365")) {//"station": "58365",
                return jobj.toJavaObject(Zdz.class);
                //return jobj.toJSONString();
            }
        }
        return null;
    }

    @GetMapping("/showZdzAll24")
    @ResponseBody
    public List<Zdz> showZdzAll24() throws Exception {
        List<Zdz> zdzList = new ArrayList<Zdz>();
        String json = HttpClientUtils.getMethodGetResponse(WeatherFinalValue.ZDZ_24_URL);
        JSONArray jarray = JSONArray.parseArray(json);
        for (int i = 0; i < jarray.size(); i++) {
            JSONObject jobj = jarray.getJSONObject(i);
            if (jobj.get("station").toString().equals("58365")) {//"station": "58365",
                Zdz zdz = jobj.toJavaObject(Zdz.class);
                zdzList.add(zdz);
            }
        }
        for (int i = 0; i < zdzList.size(); i++) {
            Zdz zdz = zdzList.get(i);
            zdz.setDate(_sdf.format(sdf.parse(zdz.getDate())));
        }
        return zdzList;
    }

    /**
     * 大田气象
     * @author jungao
     * @date Jan 2, 2019 10:09:51 AM
     */
    @GetMapping("/dt")
    public String dt() {
        return prefix + "/hyt_dt";
    }

    @GetMapping("/showHytDtLast")
    @ResponseBody
    public Hyt showHytDtLast() throws ParseException {
        Hyt hytDt = weatherService.showHytLast(WeatherFinalValue.DT_IMEI);
        hytDt.setUploadTime(_sdf_nq.format(_sdf_nq.parse(hytDt.getUploadTime())));
        return hytDt;
    }

    @GetMapping("/showHytDt24")
    @ResponseBody
    public List<Hyt> showHytDt24() throws ParseException {
        List<Hyt> hytDtList = weatherService.showHyt24(WeatherFinalValue.DT_IMEI);
        for (int i = 0; i < hytDtList.size(); i++) {
            Hyt hyt = hytDtList.get(i);
            hyt.setUploadTime(_sdf.format(_sdf_nq.parse(hyt.getUploadTime())));
        }
        return hytDtList;
    }

    /**
     * 小棚气象
     * @author jungao
     * @date Jan 2, 2019 10:10:06 AM
     */
    @GetMapping("/xp")
    public String xp() {
        return prefix + "/hyt_xp";
    }

    @GetMapping("/showHytXpLast")
    @ResponseBody
    public Hyt showHytXpLast() throws ParseException {
        Hyt hytXp = weatherService.showHytLast(WeatherFinalValue.XP_IMEI);
        hytXp.setUploadTime(_sdf_nq.format(_sdf_nq.parse(hytXp.getUploadTime())));
        return hytXp;
    }

    @GetMapping("/showHytXp24")
    @ResponseBody
    public List<Hyt> showHytXp24() throws ParseException {
        List<Hyt> hytXpList = weatherService.showHyt24(WeatherFinalValue.XP_IMEI);
        for (int i = 0; i < hytXpList.size(); i++) {
            Hyt hyt = hytXpList.get(i);
            hyt.setUploadTime(_sdf.format(_sdf_nq.parse(hyt.getUploadTime())));
        }
        return hytXpList;
    }

    /**
     * 大棚气象
     * @author jungao
     * @date Jan 2, 2019 10:10:19 AM
     */
    @GetMapping("/dp")
    public String dp() {
        return prefix + "/hyt_dp";
    }

    @GetMapping("/showHytDpLast")
    @ResponseBody
    public Hyt showHytDpLast() throws ParseException {
        Hyt hytDp = weatherService.showHytLast(WeatherFinalValue.DP_IMEI);
        hytDp.setUploadTime(_sdf_nq.format(_sdf_nq.parse(hytDp.getUploadTime())));
        return hytDp;
    }

    @GetMapping("/showHytDp24")
    @ResponseBody
    public List<Hyt> showHytDp24() throws ParseException {
        List<Hyt> hytDpList = weatherService.showHyt24(WeatherFinalValue.DP_IMEI);
        for (int i = 0; i < hytDpList.size(); i++) {
            Hyt hyt = hytDpList.get(i);
            hyt.setUploadTime(_sdf.format(_sdf_nq.parse(hyt.getUploadTime())));
        }
        return hytDpList;
    }

    /**
     * 蔬菜园气象
     * @author jungao
     * @date Jan 2, 2019 10:10:28 AM
     */
    @GetMapping("/scy")
    public String scy() {
        return prefix + "/hyt_scy";
    }

    @GetMapping("/showHytScyLast")
    @ResponseBody
    public Hyt showHytScyLast() throws ParseException {
        Hyt hytScy = weatherService.showHytLast(WeatherFinalValue.SCY_IMEI);
        hytScy.setUploadTime(_sdf_nq.format(_sdf_nq.parse(hytScy.getUploadTime())));
        return hytScy;
    }

    @GetMapping("/showHytScy24")
    @ResponseBody
    public List<Hyt> showHytScy24() throws ParseException {
        List<Hyt> hytScyList = weatherService.showHyt24(WeatherFinalValue.SCY_IMEI);
        for (int i = 0; i < hytScyList.size(); i++) {
            Hyt hyt = hytScyList.get(i);
            hyt.setUploadTime(_sdf.format(_sdf_nq.parse(hyt.getUploadTime())));
        }
        return hytScyList;
    }
}
