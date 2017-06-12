package com.app.propertylist.util;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

import java.util.List;

public class Utility {

    private static final String TAG = Utility.class.getSimpleName();

    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(Object[] list) {
        return !isEmpty(list);
    }

    public static boolean isEmpty(Object[] list) {
        return list == null || list.length == 0;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static boolean isEmpty(Object object) {
        return object == null;
    }

    public static void showSnackBar(CoordinatorLayout coordinatorLayout, String message) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
