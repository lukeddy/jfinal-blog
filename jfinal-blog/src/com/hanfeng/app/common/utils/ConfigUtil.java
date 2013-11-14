package com.hanfeng.app.common.utils;

import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

/**
 * @author hanfeng E-mail:zhdevelop@gmail.com
 * @version 2013年11月14日 下午1:39:00
 * 
 */

public class ConfigUtil {
	private static final HashMap<String, String> config = new HashMap<String, String>();

	/**
	 *  加载配置文件
	 * @param properties
	 */
	public static void loadConfig(Properties properties) {
		for (Entry<Object, Object> entry : properties.entrySet()) {
			config.put(entry.getKey().toString(), entry.getValue().toString());
		}
	}

	public static final String get(String key) {
		return config.get(key);
	}

	public static Boolean getToBoolean(String key) {
		return Boolean.parseBoolean(config.get(key));
	}

	public static Long getToLong(String key) {
		return Long.parseLong(config.get(key));
	}
}
