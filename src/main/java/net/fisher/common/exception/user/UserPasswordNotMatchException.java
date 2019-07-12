package net.fisher.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 * 
 * @author jungao
 * @date Dec 13, 2018 4:36:36 PM
 */
public class UserPasswordNotMatchException extends UserException {
	private static final long serialVersionUID = 1L;

	public UserPasswordNotMatchException() {
		super("user.password.not.match", null);
	}
}
