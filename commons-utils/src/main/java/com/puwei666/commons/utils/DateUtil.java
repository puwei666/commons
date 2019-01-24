package com.puwei666.commons.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类，by puwei666 on 12/16/2018
 */
public class DateUtil {

    /**
     * 获取当前时间，String形式
     * @param pattern
     * @return String
     */
    public static String getCurrentTimeString (String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String res = sdf.format(new Date());
        return res;
    }

    // ==================== 转换类 start ====================

    /**
     * Date转换为Timestamp
     * @param date
     * @return Timestamp
     */
    public static Timestamp DateToTimestamp (Date date) {
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }

    /**
     * Date转换为String
     * @param date
     * @param pattern
     * @return String
     */
    public static String DateToString (Date date, String pattern) {
        String result = "";
        if (date != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                result = sdf.format(date);
            } catch (Exception e) {
                throw e;
            }
        }
        return result;
    }

    /**
     * Timestamp转换为Date
     * @param ts
     * @return Date
     */
    public static Date TimestampToDate (Timestamp ts) {
        return new Date();
    }

    /**
     * Timestamp转换为String
     * @param ts
     * @return String
     */
    public static String TimestampToString (Timestamp ts) {
        return "";
    }

    // ==================== 转换类 end ====================

    /**
     * 根据生日获取年龄
     *
     * @param birthDay
     * @return 年龄
     * @throws Exception
     */
    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

}
