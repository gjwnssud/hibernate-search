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
	OK (200, "Success")
	, BAD_REQUEST (400, "Bad request")
	, NOT_FOUND (404, "Page not found")
	, INTERNAL_SERVER_ERROR (404, "Internal server error")
	, FAIL (9999, "Fail")
	;

	private final int code;
	private final String message;

	Status (int code, String message) {
		this.code = code;
		this.message = message;
	}
}
