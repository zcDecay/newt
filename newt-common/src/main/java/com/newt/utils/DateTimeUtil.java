package com.newt.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 日期格式Util
 * @Author: zcc
 * @Date: 18/09/13
 */
public class DateTimeUtil {

    /**
     * 转换格式 年月日时分秒
     */
    public static String getStringDate(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = formatter.format(d);
        return date;
    }

    /**
     * 转换格式 年月日
     */
    public static String getSimpleStringDate(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String date = formatter.format(d);
        return date;
    }

    /**
     * 获得当前年份的年和月
     */
    public static String getYearAndMonth(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        String date = formatter.format(d);
        return date;
    }

    /**
     * 年
     */
    public static String getYear(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String date = formatter.format(d);
        return date;
    }

    /**
     * 月
     */
    public static String getMonth(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String date = formatter.format(d);
        return date;
    }

    /**
     * 日
     */
    public static String getDay(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String date = formatter.format(d);
        return date;
    }

    public static String parseDate(String dateStr, String format) {
        dateStr = dateStr.replace("Z", " UTC");
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            date = (Date) dateFormat.parse(dateStr);
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            dateStr = formatter.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }
}
