package net.fisher.project.system.wechat.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.fisher.common.utils.spring.SpringUtils;
import net.fisher.framework.config.WechatConfig;
import net.fisher.framework.web.controller.BaseController;
import net.fisher.project.system.wechat.util.BasicKit;
import net.fisher.project.system.wechat.util.SecurityKit;
import net.fisher.project.system.wechat.util.WechatMessageKit;

/**
 * 消息处理中心
 * 
 * @author jungao
 * @date Dec 14, 2018 3:52:50 PM
 */
@Controller
public class WechatController extends BaseController {

	@GetMapping("/wechat")
	public void handlerGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		//System.out.println("appId: " + WechatConfig.getInstance().getAppID());
		WechatConfig wechatConfig = (WechatConfig) SpringUtils.getBean("wechatConfig");
		System.out.println(wechatConfig.getAppID());
		String[] arrs = { wechatConfig.getToken(), nonce, timestamp };
		Arrays.sort(arrs);
		StringBuffer sb = new StringBuffer();
		for (String a : arrs) {
			sb.append(a);
		}
		String sha1 = SecurityKit.sha1(sb.toString());
		if (sha1.equals(signature)) {
			resp.getWriter().println(echostr);
		}
	}
	
	@PostMapping("/wechat")
	public void handlerPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String rel = WechatMessageKit.handlerReceiveMsg(req);
		System.out.println("--------rel:"+rel);
		if (!BasicKit.isEmpty(rel)) {
			resp.getWriter().write(rel);
		}
	}
}
