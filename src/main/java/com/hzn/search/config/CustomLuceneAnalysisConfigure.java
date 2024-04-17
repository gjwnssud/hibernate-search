package com.hzn.search.config;

import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
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
		context.analyzer ("htmlStrippingAutocompleteAnalyzer").custom ().tokenizer (StandardTokenizerFactory.class).charFilter (HTMLStripCharFilterFactory.class)
		       .tokenFilter (LowerCaseFilterFactory.class).tokenFilter (NGramFilterFactory.class).param ("minGramSize", "2").param ("maxGramSize", "10");
	}
}
