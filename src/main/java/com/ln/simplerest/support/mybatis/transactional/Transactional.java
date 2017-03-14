package com.ln.simplerest.support.mybatis.transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.TransactionIsolationLevel;

import java.lang.annotation.ElementType;

/**
 * 事务注解
 * 
 * @author ln
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Transactional {

	/**
	 * MyBatis executor typ
	 * @return myBatis executor typ
	 */
	ExecutorType executorType() default ExecutorType.SIMPLE;
	
	/**
	 * MyBatis TransactionLevel
	 * @return MyBatis TransactionLevel
	 */
	TransactionIsolationLevel isolationLevel() default TransactionIsolationLevel.REPEATABLE_READ;
	
	/**
	 * Force the transaction
	 * @return force the transaction
	 */
	boolean force() default false;

}
