package com.example.bailey.homework5;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
   ImageView imageView;
   static SeekBar seekbar;
    TextView tvSecs;
    Button btnSlidehow;
    TextView tvseekbar_title;
    int secs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageview);
        imageView.setImageResource(R.drawable.iit_logo);
        tvseekbar_title = (TextView)findViewById(R.id.tvseekbar_title);
        tvseekbar_title.setText("Photo Album Slider");
        seekbar = (SeekBar)findViewById(R.id.sb);
       seekbar.setProgress(0);
         seekbar.setMax(10);
        startSlideshow();
        btnSlidehow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(MainActivity.this,Slideshow.class);
                String dataSecs = tvSecs.getText().toString();
                secondActivity.putExtra("secs", dataSecs);
                startActivity(secondActivity);

            }
        });

    }

    public void startSlideshow(){
        tvSecs = (TextView)findViewById(R.id.tvsecs);
        btnSlidehow = (Button)findViewById(R.id.btnstartslideshow);
        seekbar = (SeekBar)findViewById(R.id.sb);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int secs = progress;
                tvSecs.setText(Integer.toString(secs) + " Secs?");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
