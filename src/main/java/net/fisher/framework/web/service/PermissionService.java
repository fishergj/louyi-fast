package net.fisher.framework.web.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * js调用 thymeleaf 实现按钮权限可见性
 * 
 * @author jungao
 * @date Dec 13, 2018 4:29:26 PM
 */
@Service("permission")
public class PermissionService {
	public String hasPermi(String permission) {
		return isPermittedOperator(permission) ? "" : "hidden";
	}

	private boolean isPermittedOperator(String permission) {
		return SecurityUtils.getSubject().isPermitted(permission);
	}

}
