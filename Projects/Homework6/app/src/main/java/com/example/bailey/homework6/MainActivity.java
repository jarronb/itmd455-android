package com.example.bailey.homework6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bailey.homework6.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {
    private TextView mTv_Time;
    private Button mBtn_stop;
    private Button mBtn_start;
    private Button mBtn_reset;
    private Button mBtn_startService;
    private Button mBtn_stopService;

    private Context mMainContext;
    private Chronometer mChronometer;
    private Thread mThreadChrono;

    MyService myService;
    Boolean isBound = false;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        mMainContext = this;

        mTv_Time = (TextView)findViewById(R.id.tv_time);
        mBtn_start = (Button)findViewById(R.id.btn_start);
        mBtn_reset = (Button)findViewById(R.id.btn_reset);
        mBtn_startService = (Button)findViewById(R.id.btn_startServices);
        mBtn_stopService = (Button)findViewById(R.id.btn_stopServices);
        mBtn_stop = (Button)findViewById(R.id.btn_stop);
        Intent intent = new Intent(this, MyService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        mBtn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Counter Started", Toast.LENGTH_LONG).show();
                if(mChronometer == null) {
                    mChronometer = new Chronometer(mMainContext);
                    mThreadChrono = new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });
        mBtn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Counter Stopped", Toast.LENGTH_LONG).show();
                if(mChronometer != null) {
                    mChronometer.stop();
                }
            }
        });
        mBtn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Counter Reset", Toast.LENGTH_LONG).show();
                if(mChronometer != null) {
                    mChronometer.stop();
                    mThreadChrono.interrupt();
                    mThreadChrono = null;
                    mChronometer = null;
                }
            }
        });
        mBtn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyService obj = new MyService(mMainContext);
                obj.start();
                Toast.makeText(MainActivity.this, "Service Started", Toast.LENGTH_LONG).show();
            }
        });
        mBtn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyService obj = new MyService(mMainContext);
                stopService();
                obj.stop();
                Toast.makeText(MainActivity.this, "Service Destroyed", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void updateTimerTv(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTv_Time.setText(time);
            }
        });
    }
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            myService = binder.getSerivce();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };
    public void stopService() {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}