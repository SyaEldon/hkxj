package cn.hkxj.platform.controller;

import cn.hkxj.platform.exceptions.PasswordUncorrectException;
import cn.hkxj.platform.exceptions.ReadTimeoutException;
import cn.hkxj.platform.pojo.ErrorCode;
import cn.hkxj.platform.pojo.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author junrong.chen
 * @date 2018/10/10
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public WebResponse<Void> handleException(Exception e) {
		if (e instanceof PasswordUncorrectException) {
			return WebResponse.fail(ErrorCode.ACCOUNT_OR_PASSWORD_INVALID.getErrorCode(), e.getMessage());
		}
		else if (e instanceof ReadTimeoutException) {
			return WebResponse.fail(ErrorCode.READ_TIMEOUT.getErrorCode(), e.getMessage());
		}
		log.warn("error ---- {}",e.getMessage(), e);

		return WebResponse.fail(ErrorCode.SYSTEM_ERROR.getErrorCode(), "服务器出了点小问题");
	}
}
