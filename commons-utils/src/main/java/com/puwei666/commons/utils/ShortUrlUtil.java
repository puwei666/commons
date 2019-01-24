package com.puwei666.commons.utils;

import java.security.MessageDigest;

public class ShortUrlUtil {

    public static String[] getShortUrl (String longUrl) {
        // 可以自定义生成MD5，加密字符串前的混合Key
        String key = "framework";
        // 要使用生成Url的字符
        String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };
        // 对传入网址进行MD5加密
        String hex = md5ByHex(key + longUrl);
        String[] resUrl = new String[4];
        for (int i=0; i<4; i++) {
            // 把加密字符按照8位一组16进制与0x3FFFFFFF进行位与运算
            String sTemp = hex.substring(i*8, i*8+8);
            // 这里需要使用long型来转换，因为Inteper.parseInt()只能处理31位，首位为符号位，如果不用long，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTemp, 16);
            String outChars = "";
            for (int j=0; j<6; j++) {
                // 把得到的值与0x0000003D进行位与运算，取得字符数组chars索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[(int)index];
                // 每次循环按位右移5位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    public static String md5ByHex (String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = src.getBytes();
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            String hs = "";
            String stmp = "";
            for (int i=0; i < hash.length; i++) {
                stmp = Integer.toHexString(hash[i]&0xFF);
                if (stmp.length() == 1) {
                    hs = hs +"0"+ stmp;
                } else {
                    hs = hs + stmp;
                }
            }
            return hs.toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }

}