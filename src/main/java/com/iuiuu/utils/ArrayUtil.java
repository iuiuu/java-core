package com.iuiuu.utils;

public class ArrayUtil {
    private ArrayUtil() {

    }

    public static boolean contains(char[] chars, char ch) {
        for (char c : chars) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

}
