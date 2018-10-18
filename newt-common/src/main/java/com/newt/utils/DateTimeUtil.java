package com.newt.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 日期格式Util
 * @Author: zcc
 * @Date: 18/09/13
 */
public class DateTimeUtil {

    /**
     * @Description: 当前时
     * @param: * @param
     * @return: java.lang.String
     */
    public static String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(nowTimeStamp());
        String hour;
        hour = dateString.substring(11, 13);
        return hour;
    }


    /**
     * @Description: 当前分钟
     * @param: * @param
     * @return: java.lang.String
     */
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(nowTimeStamp());
        String min;
        min = dateString.substring(14, 16);
        return min;
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            java.util.Date date = myFormatter.parse(sj1);
            java.util.Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            return "";

        }
        return day + "";

    }

    /**
     * 提取一个月中的最后一天
     *
     * @param day
     * @return
     */
    public static Date getLastDate(long day) {
        long date_3_hm = nowTimeStamp().getTime() - 3600000 * 34 * day;
        Date date_3_hm_date = new Date(date_3_hm);
        return date_3_hm_date;
    }

    public static Date nowTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
