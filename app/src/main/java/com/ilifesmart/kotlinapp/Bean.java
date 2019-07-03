package com.ilifesmart.kotlinapp;

import android.os.Handler;
import android.os.Looper;

public class Bean implements IBean {

    private static Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void postponeComputation(long delay, Runnable computation) {
        handler.postDelayed(computation, delay);
    }
}
