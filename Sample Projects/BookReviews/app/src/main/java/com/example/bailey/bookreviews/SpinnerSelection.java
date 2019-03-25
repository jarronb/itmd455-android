package com.example.bailey.bookreviews;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by baile on 11/23/2017.
 */

public class SpinnerSelection extends AppCompatActivity {
    TextView tv_title;
    TextView tv_author;
    RatingBar ratingBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_selection_info);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String title = extras.getString("title");
        final String author = extras.getString("author");
        final int rating = extras.getInt("rating");

        tv_title = (TextView)findViewById(R.id.tv_Seltitle);
        tv_author = (TextView)findViewById(R.id.tv_Selauthor);
        ratingBar = (RatingBar) findViewById(R.id.SelratingBar);
        tv_author.setText(title);
        tv_title.setText(author);
        ratingBar.setNumStars(5);
        ratingBar.setRating(rating);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
        Toast.makeText(this,"Author: " + author + "\nRating: " + rating, Toast.LENGTH_LONG).show();
    }
}
