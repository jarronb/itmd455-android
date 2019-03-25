package com.example.bailey.bookreviews;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

ListView listView;
Spinner spinner;
    private final ArrayList<String> bookName = new ArrayList<>();
    private final ArrayList<Integer> bookRating= new ArrayList<>();
    private final ArrayList<String> bookAuthor= new ArrayList<>();
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SqlHelper db = new SqlHelper(this);

/** CRUD Operations **/

// add Books

    //db.addBook(new Book("Professional Android 4 Application Development","Reto Meier",4));
    //db.addBook(new Book("Beginning Android 4 Application Development", "Wei- Meng Lee", 2));
    //db.addBook(new Book("Programming Android", "Wallace Jackson",7));
    //db.addBook(new Book("Hello, Android", "Wallace Jackson",1));

    // / get all books
    List<Book> list = db.getAllBooks();
// update one book
    //int j = db.updateBook(list.get(3), "Hello, Android", "Ben Wallace",1);

//	delete one book
    //db.deleteBook(list.get(0));
    //db.deleteBook(list.get(1));
    //db.deleteBook(list.get(2));
    //db.deleteBook(list.get(3));
    //db.deleteBook(list.get(4));

//	get all books
    db.getAllBooks();


// get count
    db.getIds();

        int length = db.getIds();
        for (int i = 0; i < length; i++ ) {
            bookAuthor.add(list.get(i).getAuthor());
            bookRating.add(list.get(i).getRating());
            bookName.add(list.get(i).getTitle());
            Log.d("message", " " + bookName.get(i));
            Log.d("message", " " + bookAuthor.get(i));
            Log.d("message", " " + bookRating.get(i));
        }
        ArrayList<String> bookName2= new ArrayList<>(bookName);
        bookName2.add(0, "Search by Titles:");

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, bookName, bookRating, bookAuthor);
    listView = findViewById(R.id.listview);
    listView.setAdapter(adapter);

    SpinnerAdapter spinnerAdapter = new SpinnerAdapter(MainActivity.this, bookName2);
    spinner = findViewById(R.id.spinner);
    spinner.setAdapter(spinnerAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Intent secondActivity = new Intent(MainActivity.this,SpinnerSelection.class);
            if(position > 0) {
                int xposition = position -1;
                secondActivity.putExtra("title", bookName.get(xposition));
                secondActivity.putExtra("author", bookAuthor.get(xposition));
                secondActivity.putExtra("rating", bookRating.get(xposition));
                startActivity(secondActivity);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
}
}
