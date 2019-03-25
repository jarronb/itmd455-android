package com.example.bailey.journeyhome.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.example.bailey.journeyhome.R;
import com.example.bailey.journeyhome.helper.InputValidation;
import com.example.bailey.journeyhome.model.Home;
import com.example.bailey.journeyhome.model.User;
import com.example.bailey.journeyhome.sql.DatabaseHelper;
import com.example.bailey.journeyhome.sql.HomeDatabaseHelper;

/**
 * Created by kingo on 12/2/2017.
 */

public class Add_activity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = Add_activity.this;
    private TextInputLayout textinputLayoutaddress;
    private TextInputLayout textinputlayoutbuyersemail;
    private TextInputEditText textinputedittextaddress;
    private TextInputEditText textinputedittextemail;
    private InputValidation inputValidation;
    private NestedScrollView nestedScrollView;
    private HomeDatabaseHelper homedatabaseHelper;
    private User user;
    private Home home;
    private AppCompatButton addproperty;
    String emailintent;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        getSupportActionBar().hide();
        initViews();
        initObjects();
        initListeners();
    }

    private void initListeners() {
        addproperty.setOnClickListener(this);
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textinputLayoutaddress=(TextInputLayout)findViewById(R.id.textInputLayoutAddress);
        textinputlayoutbuyersemail=(TextInputLayout)findViewById(R.id.textInputLayoutBuyersEmail);
        textinputedittextaddress = (TextInputEditText)findViewById(R.id.textInputEditTextAddress);
        textinputedittextemail = (TextInputEditText)findViewById(R.id.textInputEditTextBuyersEmail);
        addproperty = (AppCompatButton)findViewById(R.id.appCompatButtonAddProperty);
        Intent extras = getIntent();
        emailintent = extras.getStringExtra("EMAIL");


        //textinputLayoutaddress = ()
    }
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        homedatabaseHelper = new HomeDatabaseHelper(activity);
        home = new Home();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.appCompatButtonAddProperty:
                postDataToSQLite1();
                break;
        }

    }

    private void postDataToSQLite1() {
           // Home home = new Home();
//        if (!inputValidation.isInputEditTextFilled(textinputedittextaddress, textinputLayoutaddress, "enter user type")) {
//            return;
//        }
//        if (!inputValidation.isInputEditTexttype(textInputEditTextType, textInputLayoutType, "invalid user type")) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextFilled(textinputedittextemail, textinputlayoutbuyersemail, getString(R.string.error_message_email))) {
//            return;
//        }

        if (!inputValidation.isInputEditTextFilled(textinputedittextemail, textinputlayoutbuyersemail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textinputedittextaddress, textinputLayoutaddress, getString(R.string.error_message_email))) {
            return;
        }

            home.setAddress(textinputedittextaddress.getText().toString().trim());
            home.setBuyersEmail(textinputedittextemail.getText().toString().trim());
            //home.setHome_id(1);
            home.setRealtorsEmail(emailintent);
            homedatabaseHelper.addHome(home);
            Intent propIntent = new Intent(activity, UsersListActivity.class);
            startActivity(propIntent);

    }
}
