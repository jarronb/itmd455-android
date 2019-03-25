package com.example.bailey.homework6;

import android.content.Context;


/**
 * Created by baile on 10/30/2017.
 */

public class Chronometer implements Runnable {
    public static final long MILLIS_TO_MINUTES = 60000;
    public static final long MILLIS_TO_HOURS = 3600000;
    private Context mMainContext;
    private long mStartTime;
    private long mSince;
    private boolean mIsRunning;

    public Chronometer(Context mMainContext) {
        this.mMainContext = mMainContext;
    }

    public void start() {
        mStartTime = System.currentTimeMillis();
        mIsRunning = true;
    }

    public void stop() {

        mIsRunning = false;
    }
    @Override
    public void run() {
        while (mIsRunning == true) {
            long since = System.currentTimeMillis() - mStartTime;

                int seconds = (int) ((since / 1000) %60);
                int minutes = (int) ((since / MILLIS_TO_MINUTES) %60);
                int hours = (int) ((since / MILLIS_TO_HOURS) %24);
                int millis = (int) (since %1000);

            ((MainActivity)mMainContext).updateTimerTv(String.format(
                    "%02d:%02d:%02d:%03d", hours, minutes, seconds, millis
            ));
        }
    }
}
