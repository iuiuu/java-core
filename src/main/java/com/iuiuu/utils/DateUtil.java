package com.iuiuu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
    private DateUtil() {
    }

    /**
     * String转Date
     *
     * @param strDate
     * @return
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (null == strDate) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }

    public static Date stringToDate(String strDate) {
        return stringToDate(strDate, "yyyy-MM-dd HH:mm:ss");
    }

}
