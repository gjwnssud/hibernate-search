package com.hzn.search.dto.response;

import com.hzn.search.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@Getter
@AllArgsConstructor
public class Response<T> {
	private int code;
	private String message;
	private T data;

	public static <T> Response<T> of (int code, String message) {
		return of (code, message, null);
	}

	public static <T> Response<T> of (Status status) {
		return of (status.getCode (), status.getMessage (), null);
	}

	public static <T> Response<T> of (Status status, T data) {
		return of (status.getCode (), status.getMessage (), data);
	}

	public static <T> Response<T> of (int code, String message, T data) {
		return new Response<> (code, message, data);
	}
}
