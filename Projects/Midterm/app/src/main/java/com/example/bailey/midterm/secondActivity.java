package com.example.bailey.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by baile on 10/17/2017.
 */

public class secondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_view);

        final String[] class_name = {"Android Development", "Data Networks", "Databases", "Internet Secutrity",
                "Java Programming", "Software Engineering"

        };

        final String[] class_number = {"555", "485", "411", "510", "312", "511"

        };

        secondActivityx(class_name,class_number);
    }

    public void secondActivityx(final String[] class_name, final String[] class_number)

    {
        TextView stu_name;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("username");
        stu_name = (TextView)findViewById(R.id.tv_name);
        custom_adapter adapter;
        ListView listView;

        stu_name.setText(name);
        adapter = new custom_adapter(secondActivity.this, class_name,
                class_number);
        listView = (ListView) findViewById (R.id.list_view);
        listView.setAdapter(adapter);

    }
}
