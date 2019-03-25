package com.example.phuang.servicesapp;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;
/**
 * Created by phuang on 10/20/2017.
 */
public class MyService extends Service {
    int counter=0;
    Timer timer = new Timer();
    TimerTask timerTask;
    final Handler handler = new Handler();

    @Override
    public void onCreate() {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        final Handler handler = new Handler();
        final Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        ++counter;
                        Toast.makeText(getApplicationContext(), "Counter=:"+counter, Toast.LENGTH_SHORT).show();
                        Log.d("test", "run: ------> "+counter);
                        intent.putExtra("time", counter);
                    }
                });
            };
        };
        //
        timer.schedule(timerTask, 1000, 3000);
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}