package com.example.jot.journeyhome;

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

import java.util.ArrayList;
import java.util.List;



public class HomeListActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatActivity activity = HomeListActivity.this;
    private AppCompatTextView textViewAddress;
    private AppCompatButton appCompatButtonAddProperty;
    private RecyclerView recyclerViewHome;
    private List<Home> listHome;
    private HomeRecyclerAdapter homeRecyclerAdapter;
    private HomeDatabaseHelper databaseHelper;
    String emailFromIntent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);
        getSupportActionBar().setTitle("");
        initViews();
        initListeners();
        initObjects();
    }

    //Method to initialize views
    private void initViews() {
        textViewAddress = findViewById(R.id.textViewAddress);
        recyclerViewHome = findViewById(R.id.recyclerViewUsers);
        appCompatButtonAddProperty = findViewById(R.id.appCompatButtonAddProperty);
    }


    private void initListeners() {
        appCompatButtonAddProperty.setOnClickListener(this);
        //textViewLinkRegister.setOnClickListener(this);
    }






    //Method to initialize objects
    public void initObjects() {
        listHome = new ArrayList<>();
        homeRecyclerAdapter = new HomeRecyclerAdapter(listHome);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHome.setLayoutManager(mLayoutManager);
        recyclerViewHome.setItemAnimator(new DefaultItemAnimator());
        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setAdapter(homeRecyclerAdapter);
        databaseHelper = new HomeDatabaseHelper(activity);

        Intent extras = getIntent();
        emailFromIntent = extras.getStringExtra("EMAIL");
        textViewAddress = this.findViewById(R.id.textViewName);
        textViewAddress.setText(emailFromIntent);
        getDataFromSQLite();


    }

    //Method to fetch all home records from SQLite
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listHome.clear();
                listHome.addAll(databaseHelper.getAllhomes());


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                homeRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

   //@Override
   // public void onPointerCaptureChanged(boolean hasCapture) {

   // }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonAddProperty:
                Intent intentadd = new Intent(getApplicationContext(), AddPropertyActivity.class);
                intentadd.putExtra("EMAIL", emailFromIntent );
                startActivity(intentadd);
                break;
        }
    }
}
