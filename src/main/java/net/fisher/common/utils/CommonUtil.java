package net.fisher.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 普通工具类
 * @author jinxl
 *
 */
public class CommonUtil {

	/**
	 * 列表按升序排序
	 * 
	 * @param map
	 * @return
	 */
	public static <K extends Comparable<? super K>, V> Map<K, V> sortAscByKey(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}
}
