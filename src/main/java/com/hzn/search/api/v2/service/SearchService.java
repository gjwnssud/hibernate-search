package com.hzn.search.api.v2.service;

import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.dsl.CompositeSortComponentsStep;
import org.hibernate.search.engine.search.sort.dsl.FieldSortOptionsStep;
import org.hibernate.search.engine.search.sort.dsl.SortFinalStep;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
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
		                                                                .where (f -> f.wildcard ().fields ("nttSj", "nttCn")
		                                                                              .matching ("*" + keyword + "*")).sort (f -> {
					// 여러 정렬 조건을 위한 복합 정렬 시작
					CompositeSortComponentsStep<?> sortStep = f.composite ();
					for (Order order : pageable.getSort ().toList ()) {
						sortStep = sortStep.add (
								order.isAscending () ? f.field (order.getProperty ()).asc () : f.field (order.getProperty ()).desc ());
					}
					return sortStep;
				}).fetch ((int) pageable.getOffset (), pageable.getPageSize ());
		return new PageImpl<> (searchResult.hits (), pageable, searchResult.total ().hitCount ());
	}
}
