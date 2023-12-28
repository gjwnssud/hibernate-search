package com.hzn.search.exception;

import com.hzn.search.dto.response.Response;
import com.hzn.search.enums.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler ({Exception.class, BindException.class})
	public ResponseEntity<Response<Void>> exception (Exception e) {
		if (!ObjectUtils.isEmpty (e.getMessage ())) {
			return ResponseEntity.ok (Response.of (Status.INTERNAL_SERVER_ERROR.getCode (), e.getMessage ()));
		} else {
			return ResponseEntity.ok (Response.of (Status.INTERNAL_SERVER_ERROR));
		}
	}
}
