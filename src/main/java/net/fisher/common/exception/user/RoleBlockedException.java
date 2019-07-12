package net.fisher.common.exception.user;

/**
 * 角色锁定异常类
 * 
 * @author jungao
 * @date Dec 13, 2018 4:35:34 PM
 */
public class RoleBlockedException extends UserException {
	private static final long serialVersionUID = 1L;

	public RoleBlockedException(String reason) {
		super("role.blocked", new Object[] { reason });
	}

}
