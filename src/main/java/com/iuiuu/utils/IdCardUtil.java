package com.iuiuu.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class IdCardUtil {

    // 身份证前17位数字本体码对应的加权因子
    private static final int[] WEIGHT_LIST = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    // 身份证第18位数字本体码（校验码）
    private static final char[] CHECK_CODE_LIST = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    // 男性数字位
    private static final int[] MALE_DIGIT = new int[]{1, 3, 5, 7, 9};

    // 女性数字位
    private static final int[] FEMALE_DIGIT = new int[]{0, 2, 4, 6, 8};

    private static final String ID_CARD_NO_PATTERN = "^([1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx])$";

    /**
     * 计算校验码
     * return 18th id card number
     *
     * @param idCardNo
     * @return
     */
    public static char calculateCheckCode(String idCardNo) {
        int sum = 0;

        for (int i = 0, len = idCardNo.length(); i < len; i++) {
            char c = idCardNo.charAt(i);
            int digit = Integer.parseInt(String.valueOf(c));
            ;
            sum += digit * WEIGHT_LIST[i];
        }

        int mod = sum % 11;

        return CHECK_CODE_LIST[mod];
    }

    /**
     * 校验是否为合法的身份证号码
     *
     * @param idCardNo
     * @return
     */
    public static boolean verify(String idCardNo) {
        if (StringUtil.isNullOrWhiteSpace(idCardNo)) {
            return false;
        }

        int len = idCardNo.length();

        if (len != 15 && len != 18) {
            return false;
        }

        if (!isIdCardNoFormat(idCardNo)) {
            return false;
        }

        if (len == 18) {
            String checkCode = String.valueOf(calculateCheckCode(idCardNo.substring(0, len - 1)));
            String c = String.valueOf(idCardNo.charAt(len - 1));

            if (!checkCode.toUpperCase().equals(c.toUpperCase())) {
                return false;
            }
        }

        return true;
    }

    /**
     * 根据身份证出生日期计算当前周岁
     * <p>
     * 《最高人民法院关于审理未成年人刑事案件具体应用法律若干问题的解释》第二条明确规定，
     * “周岁”，按照公历的年月日计算，从周岁生日的第二天起算。
     * 例如：
     * 2000-10-01出生，当前日期是2000-11-01，未满1周岁，算0周岁！
     * 2000-10-01出生，当前日期是2005-10-01，未满5周岁，算4周岁（生日当天未过完）！
     * 2000-10-01出生，当前日期是2005-10-02，已满5周岁了！
     * <p>
     * 先看“年”，用当前年份减去生日年份得出年龄age
     * 再看“月”，如果当前月份小于生日月份，说明未满周岁age，年龄age需减1；如果当前月份大于等于生日月份，则说明满了周岁age，计算over！
     * 最后"日"，如果月份相等并且当前日小于等于出生日，说明仍未满周岁，年龄age需减1；反之满周岁age，over！
     *
     * @param idCardNo 身份证号码
     * @return
     */
    public static int getCurrentAge(String idCardNo) {
        Date date = getBirthday(idCardNo);

        if (date == null) {
            return -1;
        }

        Calendar birthday = Calendar.getInstance();
        birthday.setTime(date);
        int year = birthday.get(Calendar.YEAR);
        int month = birthday.get(Calendar.MONTH);
        int day = birthday.get(Calendar.DAY_OF_MONTH);

        Calendar current = Calendar.getInstance();
        int currentYear = current.get(Calendar.YEAR);
        int currentMonth = current.get(Calendar.MONTH);
        int currentDay = current.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - year;

        if (age <= 0) {
            return 0;
        }

        if (currentMonth < month || (currentMonth == month && currentDay <= day)) {
            age--;
        }

        return age < 0 ? 0 : age;
    }

    /**
     * 根据身份证号码读取性别
     *
     * @param idCardNo
     * @return
     */
    public static String getSex(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();
        char ch = idCardNo.charAt(len - 2);
        int digit = Integer.parseInt(String.valueOf(ch));

        return digit % 2 == 0 ? "女" : "男";
    }

    /**
     * 从身份证号获取出生日期
     *
     * @param idCardNo
     * @return
     */
    public static Date getBirthday(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();
        String birthday;

        if (len == 18) {
            birthday = idCardNo.substring(6, 14);
        } else {
            birthday = "19" + idCardNo.substring(6, 12);
        }

        return DateUtil.stringToDate(birthday, "yyyyMMdd");
    }

    /**
     * 从身份证获取年份
     *
     * @param idCardNo
     * @return
     */
    public static int getYear(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();

        if (len == 18) {
            return Integer.parseInt(idCardNo.substring(6, 10));
        }

        return Integer.parseInt("19" + idCardNo.substring(6, 8));
    }

    /**
     * 从身份证获取月份
     *
     * @param idCardNo
     * @return
     */
    public static int getMonth(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();

        if (len == 18) {
            return Integer.parseInt(idCardNo.substring(10, 12));
        }

        return Integer.parseInt(idCardNo.substring(8, 10));
    }

    /**
     * 从身份证获取日期
     *
     * @param idCardNo
     * @return
     */
    public static int getDate(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();

        if (len == 18) {
            return Integer.parseInt(idCardNo.substring(12, 14));
        }

        return Integer.parseInt(idCardNo.substring(10, 12));
    }

    /**
     * 是否为身份证格式
     *
     * @param idCardNo
     * @return
     */
    private static boolean isIdCardNoFormat(String idCardNo) {
        return Pattern.matches(ID_CARD_NO_PATTERN, idCardNo);
    }
}
