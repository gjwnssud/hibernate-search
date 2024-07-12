package com.hzn.search.controller;

import com.hzn.search.dto.response.Response;
import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import com.hzn.search.enums.Status;
import com.hzn.search.service.TbcmCmtyNttInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2024. 5. 22.
 */
@Tag (name = "Hibernate-Search-v7 검색")
@RestController
@RequestMapping ("/api/ntts")
@RequiredArgsConstructor
public class TbcmCmtyNttInfoController {
	private final TbcmCmtyNttInfoService tbcmCmtyNttInfoService;

	@Operation (summary = "게시글 인덱싱")
	@PostMapping ("/index")
	public ResponseEntity<Response<Void>> index () throws InterruptedException {
		tbcmCmtyNttInfoService.indexTbcmCmtyNttInfo ();
		return ResponseEntity.ok (Response.of (Status.OK));
	}

	@Operation (summary = "게시글 검색")
	@GetMapping ("/search")
	public ResponseEntity<Response<Page<TbcmCmtyNttInfoEntity>>> search (@RequestParam (defaultValue = "") String keyword, @PageableDefault (sort = {
			"cmtyNttSn"}, direction = Direction.DESC) @ParameterObject Pageable pageable) {
		return ResponseEntity.ok (Response.of (tbcmCmtyNttInfoService.search (keyword, pageable)));
	}

	@Operation (summary = "제안 키워드")
	@GetMapping ("/suggest-keyword")
	public ResponseEntity<Response<List<String>>> suggestKeyword (@RequestParam String keyword) throws IOException {
		return ResponseEntity.ok (Response.of (tbcmCmtyNttInfoService.suggestKeywords (keyword)));
	}
}
