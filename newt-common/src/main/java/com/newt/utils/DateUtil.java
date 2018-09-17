package com.newt.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: zcc
 * @Date: 18/09/13
 */
public class DateUtil extends DateUtils {

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYY = "yyyy";

    public static final String HHMMSS = "HHmmss";

    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 将一个字符串格式的日期，转换为Date类型的日期对象.
     */
    public static Date parseDate(final String str, final String... parsePatterns) {
        try {
            return DateUtils.parseDate(str, parsePatterns);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将日期转换成制定格式的字符串
     *
     * parsePatterns:
     * yyyyMMddHHmmss : 20150609134055
     * yyMMdd : 150609
     * 其中HH表示24小时制 ,hh则表示12小时制，月份为大写M,分钟为小写m
     * yyyy-MM-dd HH:mm:ss : 2015-06-09 13:40:55
     * yyyy-MM-dd : 2015-06-09
     * yy-MM-dd : 15-06-09
     * yyyy/MM/dd : 2015/06/09
     * yyyy/MM/dd : 2015/06/09
     */
    public static String format(final Date date, final String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 将日期转换成制定格式的字符串
     */
    public static String getDateString(final String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 获得今天的开始时间 yyyy-MM-dd 00:00:00
     */
    public static Date getDayStartTime() {
        return getDayStartTime(new Date());
    }

    /**
     * 获得给定日期的的开始时间 yyyy-MM-dd 00:00:00
     */
    public static Date getDayStartTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        return getDateNoTime(date);
    }

    /**
     * 获得给定日期的的开始时间字符串 yyyyMMdd000000
     */
    public static String getDayStartTimeStr(String date) {
        if (StringUtils.isNoneBlank(date)) {
            date = date.replace("-", "");
        } else {
            date = getDateString(DateUtil.YYYYMMDD);
        }
        return date + "000000";
    }

    /**
     * 获取活动时间到时分秒
     */
    public static String getActivityDayStr(String date) {
        if (StringUtils.isNoneBlank(date)) {
            date = date.replace("-", "");
            date = date.replace(" ", "");
            date = date.replace(":", "");
        } else {
            date = getDateString(DateUtil.YYYYMMDDHHMMSS);
        }
        return date;
    }

    /**
     * 获得今天的结束时间
     */
    public static Date getDayEndTime() {
        return getDayEndTime(new Date());
    }

    /**
     * 获得一天的结束时间
     */
    public static Date getDayEndTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar = getDateNoTime(calendar);
        calendar.add(Calendar.DAY_OF_WEEK, +1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    /**
     * 获得给定日期的的结束时间字符串 yyyyMMdd000000
     */
    public static String getDayEndTimeStr(String date) {
        if (StringUtils.isNoneBlank(date)) {
            date = date.replace("-", "");
        } else {
            date = getDateString(DateUtil.YYYYMMDD);
        }
        return date + "235959";
    }

    /**
     * 获得一个周的开始时间
     */
    public static Date getWeekStartTime() {
        return getWeekStartTime(new Date());
    }

    /**
     * 获得一个周的开始时间
     */
    public static Date getWeekStartTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar = getDateNoTime(calendar);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        return calendar.getTime();
    }

    /**
     * 获得一个周的结束时间
     */
    public static Date getWeekEndTime() {
        return getWeekEndTime(new Date());
    }

    /**
     * 获得一个周的结束时间
     */
    public static Date getWeekEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getWeekStartTime(date));
        calendar.add(Calendar.WEEK_OF_MONTH, +1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    /**
     * 获得一个月的开始时间
     */
    public static Date getMonthStartTime() {
        return getMonthStartTime(new Date());
    }

    /**
     * 获得一个月的开始时间
     */
    public static Date getMonthStartTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar = getDateNoTime(calendar);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获得一个月的结束时间
     */
    public static Date getMonthEndTime() {
        return getMonthEndTime(new Date());
    }

    /**
     * 获得一个月的结束时间
     */
    public static Date getMonthEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getMonthStartTime(date));
        calendar.add(Calendar.MONTH, +1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    /**
     * 获得一个没有时间的日期
     */
    public static Calendar getDateNoTime(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
    }

    /**
     * 获得一个没有时间的日期
     */
    public static Date getDateNoTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar = getDateNoTime(calendar);
        return calendar.getTime();
    }

    /**
     * 获取一个没有日期的时间
     */
    public static Time getTimeNoDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if (date == null) {
            date = new Date();
        }
        return Time.valueOf(sdf.format(date));
    }

    /**
     * 获得邻近的几年
     */
    public static List<Date> getAroundYears(Date year, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(year);
        List<Date> years = new ArrayList<Date>(count);
        calendar.add(Calendar.YEAR, -(count / 2));
        int i = 0;
        do {
            years.add(calendar.getTime());
            calendar.add(Calendar.YEAR, 1);
        } while (++i < count);
        return years;
    }

    /**
     * 描述: 获取之前或者之后几天,带星期
     */
    public static List<String> getAroundDays(Date date, int count) {
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<String> days = new ArrayList<String>(Math.abs(count));
        if (count > 0) {
            calendar.add(Calendar.DATE, 1);
        } else {
            calendar.add(Calendar.DATE, -1);
        }
        int i = 0;
        do {
            days.add(DateUtil.format(calendar.getTime(), YYYY_MM_DD) + " [" + format.format(calendar.getTime()) + "]");
            if (count > 0) {
                calendar.add(Calendar.DATE, 1);
            } else if (count < 0) {
                calendar.add(Calendar.DATE, -1);
            }
        } while (++i < Math.abs(count));
        return days;
    }

    /**
     * 自然周次
     */
    public static List<Date> getWeeks(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int maxWeek = calendar.getMaximum(Calendar.WEEK_OF_YEAR);
        List<Date> weeks = new ArrayList<Date>(maxWeek);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        for (int i = 0; i < maxWeek; i++) {
            weeks.add(calendar.getTime());
            calendar.add(Calendar.WEEK_OF_YEAR, +1);
            if (i == 0) {
                calendar.set(Calendar.DAY_OF_WEEK, 1);
            }
        }
        return weeks;
    }

    /**
     * 根据开始和结束日期查询周次日期集合
     */
    public static List<Date> getWeeks(Date startDate, Date endDate) {
        if (endDate == null || startDate == null) {
            return getWeeks(new Date());
        }
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(startDate);
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setTime(endDate);
        int maxWeek = computeWeek(startDate, endDate);
        List<Date> weeks = new ArrayList<Date>();
        int i = 1;
        while (sCalendar.before(eCalendar)) {
            if (sCalendar.get(Calendar.YEAR) == eCalendar.get(Calendar.YEAR)
                    && sCalendar.get(Calendar.MONTH) == eCalendar.get(Calendar.MONTH)
                    && sCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) == eCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)) {
                break;
            } else {
                sCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                if (i != maxWeek - 1) {
                    if (i == maxWeek) {
                        sCalendar.add(Calendar.DAY_OF_YEAR, 7);
                        weeks.add(sCalendar.getTime());
                    } else {
                        weeks.add(sCalendar.getTime());
                        sCalendar.add(Calendar.DAY_OF_YEAR, 7);
                    }
                } else {
                    weeks.add(sCalendar.getTime());
                }
            }
            i++;
        }
        return weeks;
    }

    /**
     * 根据开始和结束时间计算周次
     */
    public static int computeWeek(Date sdate, Date edate) {
        int wks = 0;
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(sdate);
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setTime(edate);
        while (sCalendar.before(eCalendar)) {
            if (sCalendar.get(Calendar.YEAR) == eCalendar.get(Calendar.YEAR)
                    && sCalendar.get(Calendar.MONTH) == eCalendar.get(Calendar.MONTH)
                    && sCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) == eCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)) {
                break;
            } else {
                sCalendar.add(Calendar.DAY_OF_YEAR, 7);
                wks += 1;
            }
        }
        return wks + 1;
    }

    /**
     * 获得前一天
     */
    public static Date getPreDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获得前n天的日期
     */
    public static Date getPreNDay(Date date, int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -number);
        return calendar.getTime();
    }

    /**
     * 获得前一天
     */
    public static Date getPreDay() {
        return getPreDay(new Date());
    }

    /**
     * 获取后一天
     */
    public static Date getAfterDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 获取后n天
     */
    public static Date getAfterNDay(Date date, Integer n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);
        return calendar.getTime();
    }

    /**
     * 获取后一天
     */
    public static Date getAfterDay() {
        return getAfterDay(new Date());
    }

    /**
     * 传入20170410105508 返回 2017-04-10 10:55:08
     */
    public static String getDateByString(String dateString) {
        if (StringUtils.isNotBlank(dateString) && dateString.length() >= 14 && !StringUtils.equals("无", dateString)) {
            String year = dateString.substring(0, 4);
            String month = dateString.substring(4, 6);
            String day = dateString.substring(6, 8);
            String hour = dateString.substring(8, 10);
            String minute = dateString.substring(10, 12);
            String second = dateString.substring(12, 14);
            String newDate = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
            return newDate;
        }
        return "";
    }

    /**
     * 天数加减
     */
    public static Date dayAddOrSub(int currentDay, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(currentDay, day);
        Date startDate = calendar.getTime();
        return startDate;
    }

    /**
     * 格式化有效期
     */
    public static String formatEffectiveDate(String effectiveDate) {
        if (StringUtils.isNotBlank(effectiveDate) && !StringUtils.equals("无", effectiveDate)
                && !effectiveDate.contains("0000") && effectiveDate.length() >= 6) {
            effectiveDate = effectiveDate.replaceAll("-", "");
            effectiveDate = effectiveDate.replaceAll("/", "");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat rightFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (effectiveDate.length() == 6) {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
                try {
                    Date time = getMonthEndTime(format.parse(effectiveDate));
                    return rightFormat.format(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if (effectiveDate.length() == 8) {
                try {
                    Date parse = format2.parse(effectiveDate);
                    return rightFormat.format(parse);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return "";
        }
        return "";
    }

    /**
     * 获取当年的第一天
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 获取当前月份的第一天
     */
    public static Date getCurrFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        return calendar.getTime();
    }

    /**
     * 获取当前月份的最后一天
     */
    public static Date getCurrLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获得该月第一天
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 获得该月最后一天
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 获取本周的第一天
     */
    public static Date getFirstWeekDay() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取本周的最后一天
     */
    public static Date getLastWeekDay() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 获取当天开始时间
     */
    public static Timestamp getNowTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 判断一个字符串的日期是否是今天
     */
    public static boolean isToday(String str, String formatStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = null;
        date = format.parse(str);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        if (year1 == year2 && month1 == month2 && day1 == day2) {
            return true;
        }
        return false;
    }

}
