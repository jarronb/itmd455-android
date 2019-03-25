package com.example.bailey.homework5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Integer.parseInt;

public class Slideshow extends AppCompatActivity {
    Timer timer;
    TextView tvmoviename;
    TextView tvmovieyear;
    ImageView picmovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);




         final String[] movienames = {"Superman and the Mole Men", "Stamp Day for Superman", "Batman",
                "Superman","Superman II","Swamp Thing","Superman III","Supergirl","Superman IV: The Quest for Peace",
                "The Return of Swamp Thing","Batman","Batman Returns", "Batman Forever","Batman & Robin",
                "Steel", "Catwoman", "Constantine", "Batman Begins", "V for Vendetta", "Superman Returns",
                "Superman II: The Richard Donner Cut", "The Dark Knight", "Watchmen", "The Losers",
                "Jonah Hex", "Green Lantern", "The Dark Knight Rises", "Man of Steel", "Batman v Superman: Dawn of Justice",
                "Suicide Squad", "Wonder Woman"
        };

        final Integer[] imgid= {R.drawable.supermanmolemen, R.drawable.stamp_day_for_superman, R.drawable.batman1966poster,
                R.drawable.superman_ver1, R.drawable.superman_ii, R.drawable.swampthing, R.drawable.superman_iii_poster,
                R.drawable.supergirlposter, R.drawable.superman_iv, R.drawable.returnofswampthing, R.drawable.batman_1989_theatrical_poster,
                R.drawable.batman_returns_poster2, R.drawable.batman_forever_ver7, R.drawable.batman_robin_poster,R.drawable.steelposter,
                R.drawable.catwoman_poster, R.drawable.constantine_poster, R.drawable.batman_begins_poster, R.drawable.vforvendettamov,
                R.drawable.superman_returns, R.drawable.supermaniiricharddonnercut, R.drawable.dark_knight,
                R.drawable.watchmen_film_poster, R.drawable.thelosers2010poster ,R.drawable.jonahhexposter,
                R.drawable.green_lantern_poster, R.drawable.dark_knight_rises_poster, R.drawable.manofsteelfinalposter,
                R.drawable.batman_v_superman_poster, R.drawable.suicide_squad_poster, R.drawable.wonder_woman_film
        };

        final String[] moviedescription = {"Year: 1951",
                "Year: 1954",
                "Year: 1966",
                "Year: 1978",
                "Year: 1980",
                "Year: 1982",
                "Year: 1983",
                "Year: 1987",
                "Year: 1954",
                "Year: 1989",
                "Year: 1989",
                "Year: 1992",
                "Year: 1995",
                "Year: 1997",
                "Year: 1997",
                "Year: 2004",
                "Year: 2005",
                "Year: 2005",
                "Year: 2006",
                "Year: 2006",
                "Year: 2008",
                "Year: 2009",
                "Year: 2010",
                "Year: 2010",
                "Year: 2011",
                "Year: 2012",
                "Year: 2013",
                "Year: 2016",
                "Year: 2016",
                "Year: 2017"

        };
      MyTimer(movienames,imgid,moviedescription);
    }

   public void MyTimer(final String[] movienme, Integer[]img, String[] moviedesc) {

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String secs = extras.getString("secs");
        tvmoviename = (TextView) findViewById(R.id.tvMoviename);
        tvmoviename.setText(secs);
        tvmovieyear = (TextView) findViewById(R.id.tvMovieyear);
        picmovie = (ImageView) findViewById(R.id.ivMovie);
        final String[] movienames = movienme;
        final Integer[] imgid = img;
        final String[] moviedescription = moviedesc;
        final int vsecs = Integer.parseInt(secs);


    final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int idx = vsecs;
            @Override
            public void run() {
                if( vsecs> 0){
                    tvmoviename.setText(movienames[idx]);
                    tvmovieyear.setText(moviedescription[idx]);
                    picmovie.setImageResource(imgid[idx]);
                    Toast.makeText(Slideshow.this, "Index:-> " + idx, Toast.LENGTH_SHORT).show();
                    idx++;
                    if (idx == movienames.length || idx== moviedescription.length || idx== imgid.length){
                        idx = 0;
                    }
                }
                handler.postDelayed(this, (vsecs*1000));
            }
        };
       handler.postDelayed(runnable,2000);
    }


}
