package com.hzn.search.api.v2.controller;

import com.hzn.search.api.v2.service.SearchService;
import com.hzn.search.dto.response.Response;
import com.hzn.search.entity.TbcmCmtyNttActLogEntity;
import com.hzn.search.entity.TbcmCmtyNttAnswerDetailEntity;
import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import com.hzn.search.enums.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
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

	@GetMapping ("/performance")
	public ResponseEntity<Response<Map<String, Object>>> search_performance (@RequestParam (defaultValue = "") String keyword,
	                                                                         @PageableDefault (sort = {"cmtyNttSn"}, direction = Direction.DESC) Pageable pageable) {
		StopWatch stopWatch = new StopWatch ();
		stopWatch.start ();
		Page<TbcmCmtyNttInfoEntity> page = searchService.search (keyword, pageable);
		stopWatch.stop ();
		return ResponseEntity.ok (Response.of (Status.OK, Map.of ("elapsedTime", (double) stopWatch.getTotalTimeMillis () / 1000, "total", page.getTotalElements ())));
	}

	@Operation (summary = "답글 검색")
	@GetMapping ("/answer")
	public ResponseEntity<Response<Page<TbcmCmtyNttAnswerDetailEntity>>> searchAnswer (@RequestParam (defaultValue = "") String keyword, @PageableDefault (sort = {
			"cmtyNttAnswerSn"}, direction = Direction.DESC) @ParameterObject Pageable pageable) {
		return ResponseEntity.ok (Response.of (Status.OK, searchService.searchAnswer (keyword, pageable)));
	}

	@GetMapping ("/answer/performance")
	public ResponseEntity<Response<Map<String, Object>>> searchAnswerPerformance (@RequestParam (defaultValue = "") String keyword, @PageableDefault (sort = {
			"cmtyNttAnswerSn"}, direction = Direction.DESC) Pageable pageable) {
		StopWatch stopWatch = new StopWatch ();
		stopWatch.start ();
		Page<TbcmCmtyNttAnswerDetailEntity> page = searchService.searchAnswer (keyword, pageable);
		stopWatch.stop ();
		return ResponseEntity.ok (Response.of (Status.OK, Map.of ("elapsedTime", (double) stopWatch.getTotalTimeMillis () / 1000, "total", page.getTotalElements ())));
	}

	@Operation (summary = "사용자 활동 코드 검색")
	@GetMapping ("/act")
	public ResponseEntity<Response<Page<TbcmCmtyNttActLogEntity>>> searchActLog (@RequestParam (defaultValue = "") String keyword, @PageableDefault (sort = {
			"nttActLogSn"}, direction = Direction.DESC) @ParameterObject Pageable pageable) {
		return ResponseEntity.ok (Response.of (Status.OK, searchService.searchActLog (keyword, pageable)));
	}

	@GetMapping ("/act/performance")
	public ResponseEntity<Response<Map<String, Object>>> searchActLogPerformance (@RequestParam (defaultValue = "") String keyword, @PageableDefault (sort = {
			"nttActLogSn"}, direction = Direction.DESC) Pageable pageable) {
		StopWatch stopWatch = new StopWatch ();
		stopWatch.start ();
		Page<TbcmCmtyNttActLogEntity> page = searchService.searchActLog (keyword, pageable);
		stopWatch.stop ();
		return ResponseEntity.ok (Response.of (Status.OK, Map.of ("elapsedTime", (double) stopWatch.getTotalTimeMillis () / 1000, "total", page.getTotalElements ())));
	}

	@GetMapping ("/autocomplete")
	public ResponseEntity<Response<List<String>>> autocomplete (@RequestParam (defaultValue = "") String keyword) {
		StopWatch stopWatch = new StopWatch ();
		stopWatch.start ();
		List<String> autocompleteList = searchService.autocomplete (keyword);
		stopWatch.stop ();
		return ResponseEntity.ok (Response.of (Status.OK, autocompleteList));
	}
}
