package net.fisher.common.exception.user;

import net.fisher.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author jungao
 * @date Dec 13, 2018 4:35:19 PM
 */
public class UserException extends BaseException {
	private static final long serialVersionUID = 1L;

	public UserException(String code, Object[] args) {
		super("user", code, args, null);
	}

}
