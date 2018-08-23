package com.iuiuu.utils;

public class StringUtil {

    /**
     * 判断指定的字符串是否为 null 或 空
     *
     * @param value
     * @return
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }

    /**
     * 判断指定的字符串是否为 null、空或者仅由空白字符组成
     *
     * @param value
     * @return
     */
    public static boolean isNullOrWhiteSpace(String value) {
        return isNullOrEmpty(value) || value.trim().length() == 0;
    }
}
