package com.example.jot.journeyhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.List;

/**
 * Created by Jot on 12/2/2017.
 */

public class AddPropertyActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = AddPropertyActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutAddress;
    private TextInputLayout textInputLayoutBuyersEmail;

    private TextInputEditText textInputEditTextAddress;
    private TextInputEditText textInputEditTextBuyersEmail;

    private AppCompatButton appCompatButtonAddProperty;
    private AppCompatTextView appCompatTextViewPropertyList;

    private InputValidation inputValidation;
    private HomeDatabaseHelper homeDatabaseHelper;
    private User user;
    private Home home;

    public String emailIntent;

    public HomeDatabaseHelper db;



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        db = new HomeDatabaseHelper(this);
        getSupportActionBar().hide();


        initViews();
        initListeners();
        initObjects();

        //statements to edit the database
        List<Home> list = db.getAllhomes();
        //list homes
        db.getAllhomes();
        //delete a user
        //db.deleteHome(list.get(0));
        //list users
        db.getAllhomes();



    }

    //Method to initialize views
    private void initViews() {
        nestedScrollView = findViewById(R.id.nestedScrollView);

        textInputLayoutAddress = findViewById(R.id.textInputLayoutAddress);
        textInputLayoutBuyersEmail = findViewById(R.id.textInputLayoutBuyersEmail);


        textInputEditTextAddress = findViewById(R.id.textInputEditTextAddress);
        textInputEditTextBuyersEmail = findViewById(R.id.textInputEditTextBuyersEmail);


        appCompatButtonAddProperty = findViewById(R.id.appCompatButtonAddProperty);

        appCompatTextViewPropertyList = findViewById(R.id.appCompatTextViewPropertyList);


        Intent extras = getIntent();
        emailIntent = extras.getStringExtra("EMAIL");
        //TextView tv = this.findViewById(R.id.testing);
        //tv.setText(emailIntent);

    }

    //Method to initialize listeners
    private void initListeners() {
        appCompatButtonAddProperty.setOnClickListener(this);
        appCompatTextViewPropertyList.setOnClickListener(this);
    }

    //Method to initialize objects
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        //databaseHelper = new DatabaseHelper(activity);
        homeDatabaseHelper = new HomeDatabaseHelper(activity);
        user = new User();
        home = new Home();
    }

    //Method to listen to the on click view
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonAddProperty:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewPropertyList:
                finish();
                break;
        }
    }

        //Method to validate the input text fields and post data to SQLite
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextAddress, textInputLayoutAddress, getString(R.string.error_message_address))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextBuyersEmail, textInputLayoutBuyersEmail, getString(R.string.error_message_buyers_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextBuyersEmail, textInputLayoutBuyersEmail, getString(R.string.error_message_email))) {
            return;
        }

        if (!homeDatabaseHelper.checkHome(textInputEditTextAddress.getText().toString().trim())) {

            home.setAddress(textInputEditTextAddress.getText().toString().trim());
            home.setBuyersEmail(textInputEditTextBuyersEmail.getText().toString().trim());
            home.setRealtorsEmail(emailIntent);

            homeDatabaseHelper.addHome(home);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    //Method to clear out all EditText fields
    private void emptyInputEditText() {
        textInputEditTextAddress.setText(null);
        textInputEditTextBuyersEmail.setText(null);
    }
    }
