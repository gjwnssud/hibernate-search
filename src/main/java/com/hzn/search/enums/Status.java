package com.hzn.search.enums;

import lombok.Getter;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/13/23
 */
@Getter
public enum Status {
	OK (200, "success."), BAD_REQUEST (400, "bad request."), NOT_FOUND (404, "not found."), INTERNAL_SERVER_ERROR (500, "internal server error."), FAIL (9999, "fail.");

	private final int code;
	private final String message;

	Status (int code, String message) {
		this.code = code;
		this.message = message;
	}
}
