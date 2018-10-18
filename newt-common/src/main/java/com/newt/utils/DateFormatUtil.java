package com.newt.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description date格式化
 * @Author zcc
 * @Date 18/10/18
 */
public class DateFormatUtil {

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYY = "yyyy";

    public static final String HHMMSS = "HHmmss";

    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String MM = "MM";

    public static final String dd = "dd";



    /**
     * 时间格式化
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static String dateForString(Date currentTime, String format) {
        String dateString = DateFormatUtils.format(currentTime, format);
        return dateString;
    }

    /**
     * 时间格式化
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date dateForDate(Date currentTime, String format) throws ParseException{
        Date currentTime_2 = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String dateString = formatter.format(currentTime);
            currentTime_2 = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentTime_2;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strForDate(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date strTodate = null;
        try {
            strTodate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strTodate;
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

    /**
     * 将日期转换成制定格式的字符串
     */
    public static String nowDateString(final String pattern) {
        return format(DateTimeUtil.nowTimeStamp(), pattern);
    }


    public static String format(final Date date, final String pattern) {
        return DateFormatUtils.format(date, pattern);
    }


}

