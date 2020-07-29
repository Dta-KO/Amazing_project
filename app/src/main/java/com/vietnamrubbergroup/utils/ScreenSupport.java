package com.vietnamrubbergroup.utils;

import android.app.Activity;

/**
 * Created by Nguyen Kim Khanh on 7/29/2020.
 */
public class ScreenSupport {

    public static int getStatusBarHeight(Activity activity) {
        int statusBarHeight = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
