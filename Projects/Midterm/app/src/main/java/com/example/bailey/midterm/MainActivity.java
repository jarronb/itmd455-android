package com.example.bailey.midterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText login;
    EditText password;
    Button btn_login;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               login();
            }

        });


    }
    public void login(){
        login = (EditText)findViewById(R.id.et_login);
        password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        int inx = 0;

        while ((login.getText().toString() == "Jay") && (password.getText().toString() == "123")) {
            if ((login.getText().toString() == "Jay") && (password.getText().toString() == "123")) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("username", login.getText().toString());
                intent.putExtra("password", password.getText().toString());
                Toast.makeText(this, "Login Sucuessful", Toast.LENGTH_LONG).show();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Login Failed" + " this many times " +inx, Toast.LENGTH_LONG).show();
                inx++;
            }
        }
    }
}
