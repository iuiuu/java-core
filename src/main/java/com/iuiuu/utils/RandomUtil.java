package com.iuiuu.utils;

import java.security.SecureRandom;

public class RandomUtil {
    private static final ThreadLocal<SecureRandom> localRandom = new ThreadLocal<SecureRandom>() {
        @Override
        protected SecureRandom initialValue() {
            return newDefaultSecureRandom();
        }
    };

    private static SecureRandom newDefaultSecureRandom() {
        SecureRandom retval = new SecureRandom();
        retval.nextLong(); // force seeding
        return retval;
    }

    /** @return a random byte array of size {@code size}. */
    public static byte[] randBytes(int size) {
        byte[] rand = new byte[size];
        localRandom.get().nextBytes(rand);
        return rand;
    }

    public static int randInt(int max) {
        return localRandom.get().nextInt(max);
    }
}
