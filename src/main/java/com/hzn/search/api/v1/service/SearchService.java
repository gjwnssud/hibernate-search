package com.hzn.search.api.v1.service;

import com.hzn.search.api.v1.repository.SearchRepository;
import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@Service ("SearchService-v1")
@RequiredArgsConstructor
public class SearchService {
	private final SearchRepository searchRepository;

	public Page<TbcmCmtyNttInfoEntity> search (String keyword, Pageable pageable) {
		List<TbcmCmtyNttInfoEntity> cmtyNttInfoEntityList = searchRepository.findTbcmCmtyNttInfoEntitiesByNttCnContainingIgnoreCaseOrNttSjContainingIgnoreCaseOrderByCmtyNttSnDesc (
				keyword, keyword, pageable);
		return new PageImpl<> (cmtyNttInfoEntityList, pageable, cmtyNttInfoEntityList.size ());
	}
}
