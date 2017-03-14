package com.ln.simplerest.resource;

import java.util.HashMap;
import java.util.Map;

/**
 * RESTEasy Resource基类
 * @author Lining
 *
 */
public abstract class AbstractResource {

	protected Map<String, String> getResponseEntity(String key, String value) {
		return getResponseEntity(new String[] { key }, new String[] { value });
	}

	protected Map<String, String> getResponseEntity(String[] keys, String[] values) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		return map;
	}

}
