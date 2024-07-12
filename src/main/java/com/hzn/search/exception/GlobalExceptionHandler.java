package com.hzn.search.exception;

import com.hzn.search.dto.response.Response;
import com.hzn.search.util.RCH;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2024. 7. 12.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler (value = Exception.class)
	public ResponseEntity<Response<?>> exception (Exception e) {
		return ResponseEntity.ok (Response.of (RCH.getResponse ().getStatus (), ExceptionLog.getMessage (e)));
	}
}
