package com.hzn.search;

import com.hzn.search.entity.TbcmCmtyNttActLogEntity;
import com.hzn.search.entity.TbcmCmtyNttAnswerDetailEntity;
import com.hzn.search.entity.TbcmCmtyNttInfoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/19/23
 */
@Component
public class IndexOnStartup implements CommandLineRunner {
	@PersistenceContext
	private EntityManager entityManager;
	@Value ("${spring.jpa.properties.hibernate.search.index.initialize}")
	private boolean hibernateSearchIndexInitialize;

	@Transactional (readOnly = true)
	@Override
	public void run (String... args) throws Exception {
		if (hibernateSearchIndexInitialize) {
			SearchSession searchSession = Search.session (entityManager);
			List<Class<?>> classList = List.of (TbcmCmtyNttInfoEntity.class, TbcmCmtyNttAnswerDetailEntity.class, TbcmCmtyNttActLogEntity.class);
			MassIndexer massIndexer = searchSession.massIndexer (classList).threadsToLoadObjects (Runtime.getRuntime ().availableProcessors ()).batchSizeToLoadObjects (25).typesToIndexInParallel (2)
			                                       .purgeAllOnStart (true).dropAndCreateSchemaOnStart (true).cacheMode (CacheMode.IGNORE).idFetchSize (150).transactionTimeout (1800);
			massIndexer.startAndWait ();
		}
	}
}
