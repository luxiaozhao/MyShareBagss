package com.share.bag.utils;

import android.os.Handler;
import android.os.Looper;


/**
 * Created by 54hk on 2017/12/3.
 *  线程
 */
public class ThreadUtils {
    private static Handler handler = new Handler(Looper.getMainLooper());
//  主线程
    public static void runMainThread(Runnable runnable) {
        handler.post(runnable);
    }
//  子线程
    public static void runSubThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
