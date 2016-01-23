package com.raras.testing.utils;

public class Log {
    public static final boolean DEBUG = true;

    public static int d(String tag, String message) {
        if(DEBUG) {
            return android.util.Log.d(tag,message);
        } else {
            return 0;
        }
    }

    public static int e(String tag, String message) {
        if(DEBUG) {
            return android.util.Log.e(tag, message);
        } else {
            return 0;
        }
    }

    public static int d(String tag, String message, Exception e) {
        if(DEBUG) {
            return android.util.Log.e(tag, message, e);
        } else {
            return 0;
        }
    }
}
