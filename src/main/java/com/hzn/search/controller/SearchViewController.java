package com.hzn.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p></p>
 *
 * @author hzn
 * @date 4/2/24
 */
@Controller
public class SearchViewController {

	@GetMapping ({"/v1"})
	public String search_v1 () {
		return "search-v1";
	}

	@GetMapping ({"/", "/v2"})
	public String search_v2 () {
		return "search-v2";
	}
}
