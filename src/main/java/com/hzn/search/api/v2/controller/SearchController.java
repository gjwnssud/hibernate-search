package com.hzn.search.api.v2.controller;

import com.hzn.search.api.v2.service.SearchService;
import com.hzn.search.dto.response.Response;
import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import com.hzn.search.enums.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@Tag (name = "Hibernate-Search-v6 검색")
@RestController ("SearchController-v2")
@RequestMapping ("/api/v2/search")
@RequiredArgsConstructor
public class SearchController {
	private final SearchService searchService;

	@Operation (summary = "게시글 검색")
	@GetMapping
	public ResponseEntity<Response<Page<TbcmCmtyNttInfoEntity>>> search (@RequestParam (defaultValue = "") String keyword, @PageableDefault (sort = {
			"cmtyNttSn"}, direction = Direction.DESC) @ParameterObject Pageable pageable) {
		return ResponseEntity.ok (Response.of (Status.OK, searchService.search (keyword, pageable)));
	}
}
