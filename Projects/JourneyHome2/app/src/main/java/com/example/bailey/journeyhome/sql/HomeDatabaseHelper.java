package com.example.bailey.journeyhome.sql;

/**
 * Created by kingo on 11/27/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bailey.journeyhome.model.Home;
//import com.example.kingo.journeyhome.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jot on 11/27/2017.
 */

public class HomeDatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "HomeManager.db";

    // User table name
    private static final String TABLE_HOME = "home";
    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_EMAIL = "user_email";

    // User Table Columns names
    private static final String COLUMN_HOME_ID = "home_id";
    private static final String COLUMN_HOME_ADDRESS = "home_address";
    private static final String COLUMN_HOME_BUYERSEMAIL = "home_buyersEmail";
    private static final String COLUMN_HOME_REALTORSEMAIL = "home_realtorsEmail";


    // Create table sql query
    private String CREATE_HOME_TABLE = "CREATE TABLE " + TABLE_HOME + "("
            + COLUMN_HOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_HOME_ADDRESS + " TEXT,"
            + COLUMN_HOME_BUYERSEMAIL + " TEXT," + COLUMN_HOME_REALTORSEMAIL+ " TEXT" + ")";

    // Drop table sql query
    private String DROP_HOME_TABLE = "DROP TABLE IF EXISTS " + TABLE_HOME;

    /**
     * Constructor
     *
     * @param context
     */
    public HomeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_HOME_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exists
        db.execSQL(DROP_HOME_TABLE);

        //Create tables again
        onCreate(db);
    }

    //Method to create a new home record
    public void addHome(Home home) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_HOME_ADDRESS, home.getAddress());
        values.put(COLUMN_HOME_BUYERSEMAIL, home.getBuyersEmail());
        values.put(COLUMN_HOME_REALTORSEMAIL, home.getRealtorsEmail());

        // Inserting a row
        db.insert(TABLE_HOME, null, values);
        db.close();
    }
    public List<Home> getAllhomes() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_HOME_ID,
                COLUMN_HOME_ADDRESS,
                COLUMN_HOME_BUYERSEMAIL,
                COLUMN_HOME_REALTORSEMAIL
        };
        // sorting orders
        String sortOrder =
                COLUMN_HOME_ID + " ASC";
        List<Home> homeList = new ArrayList<Home>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_HOME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Home home = new Home();
                home.setHome_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_ID))));
                home.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_ADDRESS)));
                home.setBuyersEmail(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_BUYERSEMAIL)));
                home.setRealtorsEmail(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_REALTORSEMAIL)));
                // Adding home record to list
                homeList.add(home);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return home list
        return homeList;
    }
    public void updateHome(Home home) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_HOME_ADDRESS, home.getAddress());
        values.put(COLUMN_HOME_BUYERSEMAIL, home.getBuyersEmail());
        values.put(COLUMN_HOME_REALTORSEMAIL, home.getRealtorsEmail());

        // updating row
        db.update(TABLE_HOME, values, COLUMN_HOME_ID + " = ?",
                new String[]{String.valueOf(home.getHome_id())});
        db.close();
    }
    public void deleteUser(Home home) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_HOME, COLUMN_HOME_ID + " = ?",
                new String[]{String.valueOf(home.getHome_id())});
        db.close();
    }
    public boolean checkHome(String home_id) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_HOME_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_HOME_ID + " = ?";

        // selection argument
        String[] selectionArgs = {home_id};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_HOME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
    public List<Home> getAllHomes(String string) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_HOME_ID,
                COLUMN_HOME_ADDRESS,
                COLUMN_HOME_BUYERSEMAIL,
                COLUMN_HOME_REALTORSEMAIL
        };
        // sorting orders
        String sortOrder =
                COLUMN_HOME_ID + " ASC";
        List<Home> homeList = new ArrayList<Home>();
        SQLiteDatabase db = this.getReadableDatabase();
        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        String selectQuery = "SELECT * FROM home WHERE home_buyersEmail = '" + string + "' OR home_realtorsEmail = '" + string + "'";
        Cursor cursor = db.rawQuery(selectQuery, null); //The sort order
        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Home home = new Home();
                home.setHome_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_ID))));
                home.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_ADDRESS)));
                home.setBuyersEmail(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_BUYERSEMAIL)));
                home.setRealtorsEmail(cursor.getString(cursor.getColumnIndex(COLUMN_HOME_REALTORSEMAIL)));
                // Adding home record to list
                homeList.add(home);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        Log.d("listAllHomes", homeList.toString());
        // return home list
        return homeList;
    }


}