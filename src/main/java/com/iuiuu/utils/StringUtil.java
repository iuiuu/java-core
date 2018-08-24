package com.iuiuu.utils;

public final class StringUtil {
    private StringUtil() {
    }

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

    /**
     * 返回一个新字符串，该字符串通过在此实例中的字符左侧填充空格来达到指定的总长度，从而实现右对齐。
     *
     * @param str
     * @param totalWidth
     * @return
     */
    public static String padLeft(String str, int totalWidth) {
        return padLeft(str, totalWidth, ' ');
    }

    /**
     * 返回一个新字符串，该字符串通过在此实例中的字符左侧填充指定的 Unicode 字符来达到指定的总长度，从而实现右对齐。
     *
     * @param str
     * @param totalWidth
     * @param paddingChar
     * @return
     */
    public static String padLeft(String str, int totalWidth, char paddingChar) {
        if (str == null || str.length() >= totalWidth) {
            return str;
        }

        StringBuilder sb = new StringBuilder(totalWidth);
        for (int i = str.length(); i < totalWidth; i++) {
            sb.append(paddingChar);
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 返回一个新字符串，该字符串通过在此实例中的字符左侧填充空格来达到指定的总长度，从而实现右对齐。
     *
     * @param str
     * @param totalWidth
     * @return
     */
    public static String padRight(String str, int totalWidth) {
        return padRight(str, totalWidth, ' ');
    }

    /**
     * 返回一个新字符串，该字符串通过在此字符串中的字符右侧填充指定的 Unicode 字符来达到指定的总长度，从而使这些字符左对齐。
     *
     * @param str
     * @param totalWidth
     * @param paddingChar
     * @return
     */
    public static String padRight(String str, int totalWidth, char paddingChar) {
        if (str == null || str.length() >= totalWidth) {
            return str.trim();
        }
        StringBuilder sb = new StringBuilder(totalWidth).append(str);
        for (int i = str.length(); i < totalWidth; i++) {
            sb.append(paddingChar);
        }
        return sb.toString();
    }

    /**
     * Returns the longest string {@code prefix} such that {@code a.toString().startsWith(prefix) &&
     * b.toString().startsWith(prefix)}, taking care not to split surrogate pairs. If {@code a} and
     * {@code b} have no common prefix, returns the empty string.
     * <p>
     * https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Strings.java
     *
     * @since 11.0
     */
    public static String commonPrefix(CharSequence a, CharSequence b) {
        if (a == null || b == null) {
            return "";
        }

        int maxPrefixLength = Math.min(a.length(), b.length());
        int p = 0;
        while (p < maxPrefixLength && a.charAt(p) == b.charAt(p)) {
            p++;
        }
        if (validSurrogatePairAt(a, p - 1) || validSurrogatePairAt(b, p - 1)) {
            p--;
        }
        return a.subSequence(0, p).toString();
    }

    /**
     * Returns the longest string {@code suffix} such that {@code a.toString().endsWith(suffix) &&
     * b.toString().endsWith(suffix)}, taking care not to split surrogate pairs. If {@code a} and
     * {@code b} have no common suffix, returns the empty string.
     * <p>
     * https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Strings.java
     *
     * @since 11.0
     */
    public static String commonSuffix(CharSequence a, CharSequence b) {
        if (a == null || b == null) {
            return "";
        }

        int maxSuffixLength = Math.min(a.length(), b.length());
        int s = 0;
        while (s < maxSuffixLength && a.charAt(a.length() - s - 1) == b.charAt(b.length() - s - 1)) {
            s++;
        }
        if (validSurrogatePairAt(a, a.length() - s - 1)
                || validSurrogatePairAt(b, b.length() - s - 1)) {
            s--;
        }
        return a.subSequence(a.length() - s, a.length()).toString();
    }

    /**
     * True when a valid surrogate pair starts at the given {@code index} in the given {@code string}.
     * Out-of-range indexes return false.
     * https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Strings.java
     */
    static boolean validSurrogatePairAt(CharSequence string, int index) {
        return index >= 0
                && index <= (string.length() - 2)
                && Character.isHighSurrogate(string.charAt(index))
                && Character.isLowSurrogate(string.charAt(index + 1));
    }
}
