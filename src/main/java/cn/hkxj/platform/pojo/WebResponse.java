package cn.hkxj.platform.pojo;

import java.util.Objects;

/**
 * @author junrong.chen
 * @date 2018/10/13
 */
public class WebResponse<T> {
	private Integer status;
	private String message;
	private T data;
	private static int SUCCESS_CODE = 200;

	public WebResponse() {
	}

	public static WebResponse<Void> success() {
		return new WebResponse<Void>().setStatus(SUCCESS_CODE).setMessage("");
	}

	public static <T> WebResponse<T> success(T data) {
		Objects.requireNonNull(data);
		return new WebResponse<T>().setStatus(SUCCESS_CODE).setMessage("").setData(data);
	}

	public static WebResponse<Void> fail(Integer status, String message) {
		Objects.requireNonNull(status);
		Objects.requireNonNull(message);
		return new WebResponse<Void>().setStatus(status).setMessage(message);
	}

	public Integer getStatus() {
		return status;
	}

	public WebResponse<T> setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public WebResponse<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public WebResponse<T> setData(T data) {
		this.data = data;
		return this;
	}
}
