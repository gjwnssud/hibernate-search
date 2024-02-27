package com.hzn.search.config;

import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2/26/24
 */
public class CustomLuceneAnalysisConfigure implements LuceneAnalysisConfigurer {
	@Override
	public void configure (LuceneAnalysisConfigurationContext context) {
		context.analyzer ("htmlStrippingAnalyzer").custom ().tokenizer ("standard").tokenFilter ("lowercase").charFilter ("htmlStrip");
	}
}
