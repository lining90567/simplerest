package com.ln.simplerest.support.mybatis.data;

import java.util.Map;

/**
 * 分页请求类
 * 
 * @author ln
 *
 */
public final class PageRequest {

	private int page;
	
	private int size;
	
	private String order;
	
	private Map<String, Object> parameters;
	
	public PageRequest(int page, int size) {
		this(page, size, null);
	}
	
	public PageRequest(int page, int size, Map<String, Object> parameters) {
		this(page, size, parameters, null);
	}
	
	public PageRequest(int page, int size, Map<String, Object> parameters, String order) {
		if (page < 0) {
			throw new IllegalArgumentException("Page index must not be less than zero!");
		}

		if (size < 1) {
			throw new IllegalArgumentException("Page size must not be less than one!");
		}

		this.page = page;
		this.size = size;
		this.parameters = parameters;
		this.order = order;
	}
	
	
	public int getPage() {
		return this.page;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String getOrder() {
		return this.order;
	}
	
	public Map<String, Object> getParameters() {
		return this.parameters;
	}
	
	public int getOffset() {
		return (this.page - 1) * size;
	}
	
}
