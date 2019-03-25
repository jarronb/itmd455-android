package com.example.bailey.todo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bailey.todo.sqlite.ToDo_SqliteHelper;

/**
 * Created by deepmetha on 8/28/16.
 */
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
