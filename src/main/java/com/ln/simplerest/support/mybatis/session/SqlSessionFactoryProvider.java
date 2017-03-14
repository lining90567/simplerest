package com.ln.simplerest.support.mybatis.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis SessionFactoryProvider类
 * 
 * @author ln
 *
 */
@Singleton
public class SqlSessionFactoryProvider implements Provider<SqlSessionFactory> {

	private SqlSessionFactory sqlSessionFactory;

	@Inject
	@Named("jdbc.url")
	private String jdbcUrl;

	@Inject
	@Named("jdbc.username")
	private String jdbcUserName;

	@Inject
	@Named("jdbc.password")
	private String jdbcPassword;

	@Inject
	@Named("jdbc.pool.initialSize")
	private String poolInitialSize;

	@Inject
	@Named("jdbc.pool.minIdle")
	private String poolMinIdle;

	@Inject
	@Named("jdbc.pool.maxActive")
	private String poolMaxActive;
	

	@Override
	public SqlSessionFactory get() {
		return sqlSessionFactory;
	}

	@Inject
	private void createNewSqlSessionFactory(@Named("mybatis.conf.file") String file) throws IOException {
		Properties properties = new Properties();
		properties.setProperty("jdbc.url", jdbcUrl);
		properties.setProperty("jdbc.username", jdbcUserName);
		properties.setProperty("jdbc.password", jdbcPassword);
		properties.setProperty("jdbc.pool.initialSize", poolInitialSize);
		properties.setProperty("jdbc.pool.minIdle", poolMinIdle);
		properties.setProperty("jdbc.pool.maxActive", poolMaxActive);

		InputStream inputStream = Resources.getResourceAsStream(file);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
	}

}
