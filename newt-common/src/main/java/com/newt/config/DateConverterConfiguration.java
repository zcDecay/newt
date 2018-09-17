package com.newt.config;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日期格式处理
 */
public class DateConverterConfiguration implements Converter<String, Date> {

	private static final List<String> FORMARTS = new ArrayList<>(5);

	static {
		FORMARTS.add("yyyy-MM");
		FORMARTS.add("yyyy-MM-dd");
		FORMARTS.add("yyyy-MM-dd hh:mm");
		FORMARTS.add("yyyy-MM-dd hh:mm:ss");
		FORMARTS.add("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
	}

	@Override
	public Date convert(String source) {
		String value = source.trim();
		if ("".equals(value)) {
			return null;
		}
		if (value.matches("^\\d{4}-\\d{1,2}$")) {
			return parseDate(value, FORMARTS.get(0));
		} else if (value.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
			return parseDate(value, FORMARTS.get(1));
		} else if (value.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
			return parseDate(value, FORMARTS.get(2));
		} else if (value.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
			return parseDate(value, FORMARTS.get(3));
		} else if (value.matches("^\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d{3}Z$")) {
			value = value.replace("Z", " UTC");
			return parseDate(value, FORMARTS.get(4));
		} else {
			throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
		}
	}


	/**
	 * 功能描述：格式化日期
	 */
	private Date parseDate(String dateStr, String format) {
		Date date = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			;
		}
		return date;
	}

}
