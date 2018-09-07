package com.iuiuu.utils;

import com.google.gson.Gson;

public final class JsonUtil {
    private JsonUtil() {
    }

    private static Gson gson = new Gson();

    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    public static  <T> T fromJson(String json, Class<T> clazz){
        return gson.fromJson(json, clazz);
    }
}
