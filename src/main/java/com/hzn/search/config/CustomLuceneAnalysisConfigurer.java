package com.hzn.search.config;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.pattern.PatternReplaceFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2024. 7. 12.
 */
public class CustomLuceneAnalysisConfigurer implements LuceneAnalysisConfigurer {
	@Override
	public void configure (LuceneAnalysisConfigurationContext context) {
		context.analyzer ("ngram_analyzer").custom ().tokenizer (StandardTokenizerFactory.class).tokenFilter (PatternReplaceFilterFactory.class)
		       .param ("pattern", "[^a-zA-Z가-힣]") // 필터링: 알파벳과 한글만 포함
		       .param ("replacement", " ").tokenFilter (LowerCaseFilterFactory.class).tokenFilter (NGramFilterFactory.class).param ("minGramSize", "2")
		       .param ("maxGramSize", "5");
	}
}
