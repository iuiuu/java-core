package com.iuiuu.utils;

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

    public static int getYear(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();

        if(len == 18){
            return Integer.parseInt(idCardNo.substring(6, 10));
        }


        return Integer.parseInt("19" + idCardNo.substring(6, 8));
    }

    public static int getMonth(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();

        if(len == 18){
            return Integer.parseInt(idCardNo.substring(10, 12));
        }


        return Integer.parseInt( idCardNo.substring(8, 10));
    }

    public static int getDate(String idCardNo) {
        if (!verify(idCardNo)) {
            throw new IllegalArgumentException("parameter idCardNo is not a valid id card number");
        }

        int len = idCardNo.length();

        if(len == 18){
            return Integer.parseInt(idCardNo.substring(12, 14));
        }


        return Integer.parseInt( idCardNo.substring(10, 12));
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
