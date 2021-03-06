package cn.hkxj.platform.pojo;

/**
 * @author junrong.chen
 * @date 2018/10/10
 */
public enum  ErrorCode {
	/**
	 * 客户端错误
	 */
	NO_DATA(400),
	USER_UNAUTHORIZED(401),
	ACCOUNT_OR_PASSWORD_INVALID(402),
	OPENID_EXIST(403),
	/**
	 *服务器端错误
	 */
	SYSTEM_ERROR(500),
	READ_TIMEOUT(504);

	private int errorCode;

	ErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
