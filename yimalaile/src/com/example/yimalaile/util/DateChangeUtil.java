package com.example.yimalaile.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-21
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public class DateChangeUtil {
    /**
     * 获取指定格式时间
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateString(Date date, String pattern) {
        if(null == date) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取时间
     * @param dateString
     * @param pattern
     * @return
     */
    public static Date stringToDate(String dateString, String pattern) {
        if(null == dateString || "".equals(dateString)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            Log.e("DateChangeUtil", e.getMessage());
            return null;
        }
    }

    /**
     * 获取当前年
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        if(null == date)
            return 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取一年的第几个月
     * @param date
     * @return
     */
    public static int getMonthOfYear(Date date) {
        if(null == date)
            return 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 获取一月的第几天
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        if(null == date)
            return 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取时间的秒数形式
     * @param date
     * @return
     */
    public static int getSeconds(Date date) {
        if(null == date)
            return 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (int)(calendar.getTimeInMillis() / 1000);
    }

}