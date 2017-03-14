package com.ln.simplerest.support.mybatis.session;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

import static org.apache.ibatis.session.SqlSessionManager.newInstance;

@Singleton
public class SqlSessionManagerProvider implements Provider<SqlSessionManager> {
	
	private SqlSessionManager sqlSessionManager;

	@Override
	public SqlSessionManager get() {
		return this.sqlSessionManager;
	}
	
	
	@Inject
	private void createNewSqlSessionManager(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionManager = newInstance(sqlSessionFactory);
	}

}
