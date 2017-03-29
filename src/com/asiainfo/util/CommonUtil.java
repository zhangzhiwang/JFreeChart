package com.asiainfo.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;

/**
 * 通用工具类
 * 
 * @author zhangzhiwang
 * @date 2017年2月27日 下午4:40:50
 */
public class CommonUtil {
	private CommonUtil() {
	}

	public static <T extends RegularTimePeriod> TimeSeries getTimeSeries(Comparable<String> name, Map<Date, Double> map, Class<T> t) throws Exception {
		// TODO 参数校验
		TimeSeries timeSeries = new TimeSeries(name, t);
		for (Date date : map.keySet()) {
			timeSeries.add(t.getConstructor(Date.class).newInstance(date), (Double)map.get(date));
		}
		return timeSeries;
	}
}
