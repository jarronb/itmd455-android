package com.example.bailey.journeyhome.activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.bailey.journeyhome.sql.ToDo_SqliteHelper;


public class ToDo_SplashActivity extends AppCompatActivity {
    ToDo_SqliteHelper mySqliteHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create Sqlite DB
        mySqliteHelper = new ToDo_SqliteHelper(this);
        // Go to Main Activity
        Intent intent = new Intent(this, ToDo_ViewTasks.class);
        startActivity(intent);
        finish();
    }
}
