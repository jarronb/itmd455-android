package com.example.bailey.homework6;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import android.widget.Toast;


public class MyService extends Service {
    private Context mContext;
    private Chronometer mChronometer;
    private Thread mThreadChrono;

    public MyService(Context mContext) {
        this.mContext = ((MainActivity)mContext);
    }

    private IBinder myBinder = new MyLocalBinder();

    public void start() {
        if(mChronometer == null) {
            mChronometer = new Chronometer(mContext);
            mThreadChrono = new Thread(mChronometer);
            mThreadChrono.start();
            mChronometer.start();
        }
    }
    public void stop() {
        if(mChronometer != null) {
            mChronometer.stop();
            mThreadChrono.interrupt();
            mThreadChrono = null;
            mChronometer = null;
        }
    }
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
    public class MyLocalBinder extends Binder {
        MyService getSerivce() {
            return MyService.this;
        }
    }
}
