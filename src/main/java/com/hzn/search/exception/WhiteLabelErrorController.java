package com.hzn.search.exception;

import com.hzn.search.dto.response.Response;
import com.hzn.search.enums.Status;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/13/23
 */
@RestController
public class WhiteLabelErrorController implements ErrorController {

	@GetMapping ("/error")
	public ResponseEntity<Response<Void>> error () {
		return ResponseEntity.ok (Response.of (Status.BAD_REQUEST));
	}
}
