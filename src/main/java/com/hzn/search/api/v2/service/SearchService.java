package com.hzn.search.api.v2.service;

import com.hzn.search.entity.TbcmCmtyNttActLogEntity;
import com.hzn.search.entity.TbcmCmtyNttAnswerDetailEntity;
import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import com.hzn.search.util.CommonUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.dsl.CompositeSortComponentsStep;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactory;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/12/23
 */
@Service ("SearchService-v2")
public class SearchService {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional (readOnly = true)
	public Page<TbcmCmtyNttInfoEntity> search (String keyword, Pageable pageable) {
		SearchSession searchSession = Search.session (entityManager);
		SearchResult<TbcmCmtyNttInfoEntity> searchResult = searchSession.search (TbcmCmtyNttInfoEntity.class)
		                                                                .where (f -> f.match ().fields ("nttSj", "nttCn").matching (keyword))
		                                                                .sort (f -> getSortStep (f, pageable))
		                                                                .fetch ((int) pageable.getOffset (), pageable.getPageSize ());
		return new PageImpl<> (searchResult.hits (), pageable, searchResult.total ().hitCount ());
	}

	@Transactional (readOnly = true)
	public Page<TbcmCmtyNttAnswerDetailEntity> searchAnswer (String keyword, Pageable pageable) {
		SearchSession searchSession = Search.session (entityManager);
		SearchResult<TbcmCmtyNttAnswerDetailEntity> searchResult = searchSession.search (TbcmCmtyNttAnswerDetailEntity.class)
		                                                                        .where (f -> f.match ().fields ("nttAnswerCn").matching (keyword))
		                                                                        .sort (f -> getSortStep (f, pageable))
		                                                                        .fetch ((int) pageable.getOffset (), pageable.getPageSize ());
		return new PageImpl<> (searchResult.hits (), pageable, searchResult.total ().hitCount ());
	}

	@Transactional (readOnly = true)
	public Page<TbcmCmtyNttActLogEntity> searchActLog (String keyword, Pageable pageable) {
		SearchSession searchSession = Search.session (entityManager);
		SearchResult<TbcmCmtyNttActLogEntity> searchResult = searchSession.search (TbcmCmtyNttActLogEntity.class)
		                                                                  .where (f -> f.match ().fields ("svcActCode").matching (keyword))
		                                                                  .sort (f -> getSortStep (f, pageable))
		                                                                  .fetch ((int) pageable.getOffset (), pageable.getPageSize ());
		return new PageImpl<> (searchResult.hits (), pageable, searchResult.total ().hitCount ());
	}

	@Transactional (readOnly = true)
	public List<String> autocomplete (String keyword) {
		if (!ObjectUtils.isEmpty (keyword)) {
			SearchSession searchSession = Search.session (entityManager);
			return searchSession.search (TbcmCmtyNttInfoEntity.class).select (f -> f.composite (f.field ("nttSj", String.class), f.field ("nttCn", String.class)))
			                    .where (f -> f.match ().fields ("nttSj", "nttCn").matching (keyword)).fetchHits (10).stream ().flatMap (l -> Arrays.stream (l.toArray ()))
			                    .map (o -> {
				                    String s = CommonUtil.stripHtml (((String) o));
				                    String temp = s.toLowerCase ();
				                    int pos = temp.indexOf (keyword.toLowerCase ());
				                    if (pos == -1) {
					                    return "";
				                    }
				                    String result = s.substring (pos, pos + 10); // maxGramSize
				                    int spacePos = result.indexOf (" ");
				                    if (spacePos != -1) {
					                    result = result.substring (0, spacePos);
				                    }
				                    return result;
			                    }).distinct ().sorted ().toList ();
		} else {
			return null;
		}
	}

	private CompositeSortComponentsStep<?> getSortStep (SearchSortFactory searchSortFactory, Pageable pageable) {
		// 여러 정렬 조건을 위한 복합 정렬 시작
		CompositeSortComponentsStep<?> sortStep = searchSortFactory.composite ();
		for (Order order : pageable.getSort ().toList ()) {
			sortStep = sortStep.add (
					order.isAscending () ? searchSortFactory.field (order.getProperty ()).asc () : searchSortFactory.field (order.getProperty ()).desc ());
		}
		return sortStep;
	}
}
