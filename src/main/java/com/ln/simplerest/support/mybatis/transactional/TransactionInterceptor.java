package com.ln.simplerest.support.mybatis.transactional;

import static java.lang.Thread.currentThread;

import java.lang.reflect.Method;

import javax.inject.Inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.session.SqlSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事务拦截器
 * 
 * @author ln
 *
 */
public class TransactionInterceptor implements MethodInterceptor {

	@Inject
	private SqlSessionManager sqlSessionManager;

	private final static Logger logger = LoggerFactory.getLogger(TransactionInterceptor.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method interceptedMethod = invocation.getMethod();
		Transactional transactional = interceptedMethod.getAnnotation(Transactional.class);
		if (transactional == null) {
			transactional = interceptedMethod.getDeclaringClass().getAnnotation(Transactional.class);
		}

		boolean isSessionInherited = sqlSessionManager.isManagedSessionStarted();
		if (isSessionInherited) {
			logger.debug("SqlSession already set for thread: {}.", currentThread().getId());
		} else {
			logger.debug("SqlSession not set for thread: {}, creating a new one.", currentThread().getId());
			sqlSessionManager.startManagedSession(transactional.executorType(), transactional.isolationLevel());
		}

		Object obj = null;
		boolean needRollback = false;
		try {
			obj = invocation.proceed();
		} catch (Throwable t) {
			needRollback = true;
			throw t;
		} finally {
			if (!isSessionInherited) {
				// 本次事务创建的连接，需要处理事务并关闭连接。
				try {
					if (needRollback) {
						logger.debug("SqlSession of thread: {} rolling back", currentThread().getId());
						sqlSessionManager.rollback();
					} else {
						logger.debug("SqlSession of thread: {} committing", currentThread().getId());
						sqlSessionManager.commit(transactional.force());
					}
				} finally {
					logger.debug("SqlSession of thread: {} terminated its life-cycle, closing it.",
							currentThread().getId());
					sqlSessionManager.close();
				}
			} else {
				//非本次事务创建的连接，跳过事务处理和关闭连接。
				logger.debug("SqlSession of thread: {} is inherited, skipped close operation.",
						currentThread().getId());
			}
		}
		return obj;
	}
}
