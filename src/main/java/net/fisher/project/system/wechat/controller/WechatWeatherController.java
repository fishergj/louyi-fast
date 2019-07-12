package net.fisher.project.system.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.fisher.framework.web.controller.BaseController;

@Controller
@RequestMapping("/system/wechat/weather")
public class WechatWeatherController extends BaseController {
	private String prefix = "system/wechat";

}
