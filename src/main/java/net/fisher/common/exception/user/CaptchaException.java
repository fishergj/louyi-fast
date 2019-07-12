package net.fisher.common.exception.user;

/**
 * 验证码错误异常类
 * 
 * @author jungao
 * @date Dec 13, 2018 4:35:05 PM
 */
public class CaptchaException extends UserException {
	private static final long serialVersionUID = 1L;

	public CaptchaException() {
		super("user.jcaptcha.error", null);
	}
}
