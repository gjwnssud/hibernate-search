package com.hzn.search.api.v2.service;

import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.SearchSort;
import org.hibernate.search.engine.search.sort.dsl.SearchSortFactory;
import org.hibernate.search.engine.search.sort.spi.SearchSortBuilder;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		                                                                .where (searchPredicateFactory -> searchPredicateFactory.wildcard ()
		                                                                                                                        .fields ("nttSj",
		                                                                                                                                 "nttCn")
		                                                                                                                        .matching (
				                                                                                                                        "*" + keyword
						                                                                                                                        + "*"))
		                                                                .sort (searchSortFactory -> searchSortFactory.field ("cmtyNttSn").desc ())
		                                                                .fetch ((int) pageable.getOffset (), pageable.getPageSize ());
		return new PageImpl<> (searchResult.hits (), pageable, searchResult.total ().hitCount ());
	}
}
