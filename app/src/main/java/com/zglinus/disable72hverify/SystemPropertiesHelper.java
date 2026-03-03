package com.zglinus.disable72hverify;

import android.util.Log;
import java.lang.reflect.Method;

public class SystemPropertiesHelper {
    private static final String TAG = "Disable72h";

    public static String get(String key, String defaultValue) {
        try {
            Class<?> clazz = Class.forName("android.os.SystemProperties");
            Method method = clazz.getMethod("get", String.class, String.class);
            return (String) method.invoke(null, key, defaultValue);
        } catch (Exception e) {
            Log.e(TAG, "Failed to read system property", e);
            return defaultValue;
        }
    }

    public static void set(String key, String value) {
        try {
            Class<?> clazz = Class.forName("android.os.SystemProperties");
            Method method = clazz.getMethod("set", String.class, String.class);
            method.invoke(null, key, value);
        } catch (Exception e) {
            Log.e(TAG, "Failed to set system property", e);
        }
    }
}
