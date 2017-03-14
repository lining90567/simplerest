package com.ln.simplerest.support.guice;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.ln.simplerest.support.mybatis.session.SqlSessionFactoryProvider;
import com.ln.simplerest.support.mybatis.session.SqlSessionManagerProvider;
import com.ln.simplerest.support.mybatis.transactional.TransactionInterceptor;
import com.ln.simplerest.support.mybatis.transactional.Transactional;

public abstract class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		initialize();

		bind(SqlSessionFactory.class).toProvider(SqlSessionFactoryProvider.class).in(Scopes.SINGLETON);
		bind(SqlSessionManager.class).toProvider(SqlSessionManagerProvider.class).in(Scopes.SINGLETON);
		// 事务拦截器
		TransactionInterceptor interceptor = new TransactionInterceptor();
		requestInjection(interceptor);
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), interceptor);
	}

	/**
	 * 初始化guice环境
	 */
	protected abstract void initialize();
}
