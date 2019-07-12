package net.fisher.common.exception.user;

/**
 * 用户锁定异常类
 * 
 * @author jungao
 * @date Dec 13, 2018 4:35:52 PM
 */
public class UserBlockedException extends UserException {
	private static final long serialVersionUID = 1L;

	public UserBlockedException(String reason) {
		super("user.blocked", new Object[] { reason });
	}
}
