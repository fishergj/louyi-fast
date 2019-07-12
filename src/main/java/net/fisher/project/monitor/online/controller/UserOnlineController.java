package net.fisher.project.monitor.online.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fisher.common.utils.security.ShiroUtils;
import net.fisher.framework.aspectj.lang.annotation.Log;
import net.fisher.framework.aspectj.lang.enums.BusinessType;
import net.fisher.framework.shiro.session.OnlineSessionDAO;
import net.fisher.framework.web.controller.BaseController;
import net.fisher.framework.web.domain.AjaxResult;
import net.fisher.framework.web.page.TableDataInfo;
import net.fisher.project.monitor.online.domain.OnlineSession;
import net.fisher.project.monitor.online.domain.UserOnline;
import net.fisher.project.monitor.online.service.IUserOnlineService;

/**
 * 在线用户监控
 * 
 * @author jungao
 * @date Dec 13, 2018 5:13:22 PM
 */
@Controller
@RequestMapping("/monitor/online")
public class UserOnlineController extends BaseController {
	private String prefix = "monitor/online";

	@Autowired
	private IUserOnlineService userOnlineService;

	@Autowired
	private OnlineSessionDAO onlineSessionDAO;

	@RequiresPermissions("monitor:online:view")
	@GetMapping()
	public String online() {
		return prefix + "/online";
	}

	@RequiresPermissions("monitor:online:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserOnline userOnline) {
		startPage();
		List<UserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
		return getDataTable(list);
	}

	@RequiresPermissions("monitor:online:batchForceLogout")
	@Log(title = "在线用户", businessType = BusinessType.FORCE)
	@PostMapping("/batchForceLogout")
	@ResponseBody
	public AjaxResult batchForceLogout(@RequestParam("ids[]") String[] ids) {
		for (String sessionId : ids) {
			UserOnline online = userOnlineService.selectOnlineById(sessionId);
			if (online == null) {
				return error("用户已下线");
			}
			OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
			if (onlineSession == null) {
				return error("用户已下线");
			}
			if (sessionId.equals(ShiroUtils.getSessionId())) {
				return error("当前登陆用户无法强退");
			}
			onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
			online.setStatus(OnlineSession.OnlineStatus.off_line);
			userOnlineService.saveOnline(online);
		}
		return success();
	}

	@RequiresPermissions("monitor:online:forceLogout")
	@Log(title = "在线用户", businessType = BusinessType.FORCE)
	@PostMapping("/forceLogout")
	@ResponseBody
	public AjaxResult forceLogout(String sessionId) {
		UserOnline online = userOnlineService.selectOnlineById(sessionId);
		if (sessionId.equals(ShiroUtils.getSessionId())) {
			return error("当前登陆用户无法强退");
		}
		if (online == null) {
			return error("用户已下线");
		}
		OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
		if (onlineSession == null) {
			return error("用户已下线");
		}
		onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
		online.setStatus(OnlineSession.OnlineStatus.off_line);
		userOnlineService.saveOnline(online);
		return success();
	}
}
