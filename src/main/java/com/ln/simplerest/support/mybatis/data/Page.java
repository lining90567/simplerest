package com.ln.simplerest.support.mybatis.data;

import java.util.List;

/**
 * 分页查询结果类
 * 
 * @author ln
 *
 * @param <T>
 */
public final class Page<T> {
	
	private int total = 0;
	
	private List<T> content;
	
	
	public Page(int total, List<T> content) {
		this.total = total;
		this.content = content;
	}
	
	
	public int getTotal() {
		return this.total;
	}
	
	public List<T> getContent() {
		return this.content;
	}

}
