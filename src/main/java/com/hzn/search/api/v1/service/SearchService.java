package com.hzn.search.api.v1.service;

import com.hzn.search.api.v1.repository.SearchActLogRepository;
import com.hzn.search.api.v1.repository.SearchAnswerRepository;
import com.hzn.search.api.v1.repository.SearchRepository;
import com.hzn.search.entity.TbcmCmtyNttActLogEntity;
import com.hzn.search.entity.TbcmCmtyNttAnswerDetailEntity;
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
	private final SearchAnswerRepository searchAnswerRepository;
	private final SearchActLogRepository searchActLogRepository;

	public Page<TbcmCmtyNttInfoEntity> search (String keyword, Pageable pageable) {
		List<TbcmCmtyNttInfoEntity> cmtyNttInfoEntityList = searchRepository.findAllByNttCnContainingIgnoreCaseOrNttSjContainingIgnoreCase (keyword, keyword, pageable);
		return new PageImpl<> (cmtyNttInfoEntityList, pageable, searchRepository.countByNttCnContainingIgnoreCaseOrNttSjContainingIgnoreCase (keyword, keyword));
	}

	public Page<TbcmCmtyNttAnswerDetailEntity> searchAnswer (String keyword, Pageable pageable) {
		List<TbcmCmtyNttAnswerDetailEntity> tbcmCmtyNttAnswerDetailEntityList = searchAnswerRepository.findAllByNttAnswerCnContainingIgnoreCase (keyword, pageable);
		return new PageImpl<> (tbcmCmtyNttAnswerDetailEntityList, pageable, searchAnswerRepository.countByNttAnswerCnContainingIgnoreCase (keyword));
	}

	public Page<TbcmCmtyNttActLogEntity> searchActLog (String keyword, Pageable pageable) {
		List<TbcmCmtyNttActLogEntity> tbcmCmtyNttActLogEntityList = searchActLogRepository.findAllBySvcActCodeContainingIgnoreCase (keyword, pageable);
		return new PageImpl<> (tbcmCmtyNttActLogEntityList, pageable, searchActLogRepository.countBySvcActCodeContainingIgnoreCase (keyword));
	}
}
