package net.fisher.common.exception.user;

/**
 * 用户不存在异常类
 * 
 * @author jungao
 * @date Dec 13, 2018 4:36:19 PM
 */
public class UserNotExistsException extends UserException {
	private static final long serialVersionUID = 1L;

	public UserNotExistsException() {
		super("user.not.exists", null);
	}
}
