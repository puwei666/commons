package com.puwei666.commons.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StringUtil {

    // ==================== 转换类 start ====================

    /**
     * 字符串转Date
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date StringToDate (String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date res = sdf.parse(dateStr);
        return res;
    }

    /**
     * 字符串转Timestamp
     * @param str
     * @return
     */
    public static Timestamp StringToTimestamp (String str) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(str);
        } catch (Exception e) {
            throw e;
        }
        return ts;
    }

    // ==================== 转换类 end ====================

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID () {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}