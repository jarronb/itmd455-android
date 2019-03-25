package com.example.bailey.journeyhome.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.bailey.journeyhome.R;
import com.example.bailey.journeyhome.adapters.UsersRecyclerAdapter;
import com.example.bailey.journeyhome.model.Home;
import com.example.bailey.journeyhome.sql.HomeDatabaseHelper;
import java.util.ArrayList;
import java.util.List;


public class UsersListActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatActivity activity = UsersListActivity.this;
    private AppCompatTextView textViewRole;
    private AppCompatButton appCompatButtonAddProperty;
    private RecyclerView recyclerViewUsers;
    private List<Home> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private HomeDatabaseHelper databaseHelper;
    String emailFromIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().hide();
        initViews();
        initListeners();
        initObjects();
        appCompatButtonAddProperty = (AppCompatButton) findViewById(R.id.appCompatButtonAddProperty);
    }

    //Method to initialize views
    private void initViews() {
        textViewRole = findViewById(R.id.textViewAddress);
        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        appCompatButtonAddProperty = findViewById(R.id.appCompatButtonAddProperty);
    }

    private void initListeners() {
        appCompatButtonAddProperty.setOnClickListener(this);
        //textViewLinkRegister.setOnClickListener(this);
    }

    //Method to initialize objects
    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers,UsersListActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);

        databaseHelper = new HomeDatabaseHelper(activity);
        Intent extras = getIntent();
        emailFromIntent = extras.getStringExtra("EMAIL");
        textViewRole = this.findViewById(R.id.textViewName);
        textViewRole.setText(emailFromIntent);
        getDataFromSQLite();
    }

    //Method to fetch all user records from SQLite
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllHomes(emailFromIntent));
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonAddProperty:

                Intent intentadd = new Intent(getApplicationContext(), Add_activity.class);
                intentadd.putExtra("EMAIL", emailFromIntent );
                startActivity(intentadd);
                break;
        }
    }
}