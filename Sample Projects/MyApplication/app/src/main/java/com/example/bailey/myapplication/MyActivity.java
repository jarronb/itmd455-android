package com.example.bailey.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    Button myButton;
    EditText myEditText;
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myButton=(Button)findViewById(R.id.buttonClickME);
        myEditText=(EditText)findViewById(r.id.textViewOutput);
        myTextView = (TextView)findViewById(r.id.editTextInput);
    }
}
