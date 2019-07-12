package net.fisher.project.system.user.domain;

/**
 * 用户状态
 * 
 * @author jungao
 * @date Dec 13, 2018 3:46:54 PM
 */
public enum UserStatus {
	OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

	private final String code;
	private final String info;

	UserStatus(String code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}
}
