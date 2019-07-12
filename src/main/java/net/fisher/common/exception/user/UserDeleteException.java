package net.fisher.common.exception.user;

/**
 * 用户账号已被删除
 * 
 * @author jungao
 * @date Dec 13, 2018 4:36:04 PM
 */
public class UserDeleteException extends UserException {
	private static final long serialVersionUID = 1L;

	public UserDeleteException() {
		super("user.password.delete", null);
	}
}
