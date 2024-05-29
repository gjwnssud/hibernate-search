package com.hzn.search.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2024. 5. 22.
 */
public class UpperCasePhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

	@Override
	protected Identifier getIdentifier (String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
		return new Identifier (name.toUpperCase (), quoted);
	}
}
