package com.hzn.search.service;

import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import com.hzn.search.repository.TbcmCmtyNttInfoRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.hibernate.CacheMode;
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

/**
 * <p></p>
 *
 * @author hzn
 * @date 2024. 5. 22.
 */
@Service
@RequiredArgsConstructor
public class TbcmCmtyNttInfoService {
	private final TbcmCmtyNttInfoRepository tbcmCmtyNttInfoRepository;
	private final EntityManager entityManager;

	@Transactional
	public void indexTbcmCmtyNttInfo () throws InterruptedException {
		SearchSession searchSession = Search.session (entityManager);
		searchSession.massIndexer (TbcmCmtyNttInfoEntity.class).threadsToLoadObjects (Runtime.getRuntime ().availableProcessors ()).batchSizeToLoadObjects (25)
		             .typesToIndexInParallel (2).purgeAllOnStart (true).dropAndCreateSchemaOnStart (true).cacheMode (CacheMode.IGNORE).idFetchSize (1000)
		             .transactionTimeout (1800).startAndWait ();
	}

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
	public List<String> suggestKeywords (String keyword) {
		SearchSession searchSession = Search.session (entityManager);
		List<TbcmCmtyNttInfoEntity> tbcmCmtyNttInfoEntities = searchSession.search (TbcmCmtyNttInfoEntity.class)
		                                                                   .where (f -> f.wildcard ().fields ("nttSj", "nttCn").matching (keyword + "*")).fetchHits (20);
		return Stream.concat (tbcmCmtyNttInfoEntities.stream ().map (TbcmCmtyNttInfoEntity::getNttSj),
		                      tbcmCmtyNttInfoEntities.stream ().map (TbcmCmtyNttInfoEntity::getNttCn)).sorted ().toList ();
	}

	public TbcmCmtyNttInfoEntity findById (Long id) {
		return tbcmCmtyNttInfoRepository.findById (id).orElse (null);
	}

	@Transactional
	public void addTbcmCmtyNttInfo (TbcmCmtyNttInfoEntity tbcmCmtyNttInfoEntity) {
		tbcmCmtyNttInfoRepository.save (tbcmCmtyNttInfoEntity);
	}

	@Transactional
	public void updateTbcmCmtyNttInfo (TbcmCmtyNttInfoEntity tbcmCmtyNttInfoEntity) {
		tbcmCmtyNttInfoRepository.save (tbcmCmtyNttInfoEntity);
	}

	@Transactional
	public void deleteTbcmCmtyNttInfo (TbcmCmtyNttInfoEntity tbcmCmtyNttInfoEntity) {
		tbcmCmtyNttInfoRepository.delete (tbcmCmtyNttInfoEntity);
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
