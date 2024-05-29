package com.hzn.search.dto.response;

import com.hzn.search.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema (title = "공통 응답 객체", name = "CommonResponse")
public class Response<T> {
	@Schema (title = "응답 코드", example = "200")
	private int code;
	@Schema (title = "응답 메시지", example = "success.")
	private String message;
	@Schema (title = "응답 데이터")
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
