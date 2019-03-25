package com.example.bailey.bookreviews;

import java.util.LinkedList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by baile on 11/15/2017.
 */

public class SqlHelper extends SQLiteOpenHelper	{
    // Database Version
    private static	final int DATABASE_VERSION	= 5;
    // Database Name
    private static	final String DATABASE_NAME	= "BookDB";
    // Books table	name
    private static	final String TABLE_BOOKS =	"books";
// Books Table	Columns names

    SQLiteDatabase db;
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_RATING = "rating";

    public SqlHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table

        String CREATE_BOOK_TABLE = "CREATE TABLE books ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, "+
                "author TEXT," +
                "rating INTEGER )";
        //	create books table
        db.execSQL(CREATE_BOOK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

//	Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");

//	create fresh books table
        this.onCreate(db);
    }

    /*CRUD operations (create "add", read "get", update, delete) */
    public void addBook(Book book){
        Log.d("addBook", book.toString());

//	1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

//	2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle()); // get title
        values.put(KEY_AUTHOR, book.getAuthor()); // get author
        values.put(KEY_RATING, book.getRating());
//	3. insert
        db.insert(TABLE_BOOKS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/values

//	4. Close dbase
        db.close();

    }

    // Get All Books
    public List<Book> getAllBooks() {

        List<Book> books = new LinkedList<Book>();
        // 1. build the query
        String query = "SELECT * FROM " + TABLE_BOOKS;

//	2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

//	3. go over each row, build book and add it to list
        Book book = null;

        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setRating(cursor.getInt(3));

//	Add book to books
                books.add(book);

            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", books.toString());
        return books; // return books
    }
    // Updating single book
    public int updateBook(Book book, String newTitle, String newAuthor, int newRating) {

//	1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

//	2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("title", newTitle); // get title
        values.put("author", newAuthor); // get author
        values.put("rating", newRating);
//	3. updating row
        int i = db.update(TABLE_BOOKS, //table
                values, // column/value
                KEY_ID+" = ?", // selections

                new String[] { String.valueOf(book.getId()) + "\n" }); //selection args

// 4. close dbase

        db.close();
        Log.d("UpdateBook", book.toString());
        return i;

    }

    // Deleting single book
    public void deleteBook(Book book) {

//	1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

//	2. delete
        db.delete(TABLE_BOOKS, KEY_ID+" = ?",
                new String[] { String.valueOf(book.getId()) });

//	3. close
        db.close();

        Log.d("deleteBook", book.toString());

    }

    public int getIds()

    {
        String selectQuery = "SELECT id FROM books";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        Log.d("getIds", String.valueOf(total));
        return total;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BOOKS;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
