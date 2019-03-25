package com.example.bailey.bookreviews;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity { @Override

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SqlHelper db = new SqlHelper(this);

/** CRUD Operations **/
// add Books

    //db.addBook(new Book("Professional Android 4 Application Development","Reto Meier"));
    //db.addBook(new Book("Beginning Android 4 Application Development", "Wei- Meng Lee"));
    //db.addBook(new Book("Programming Android", "Wallace Jackson"));
    //db.addBook(new Book("Hello, Android", "Wallace Jackson"));

    // / get all books
    List<Book> list = db.getAllBooks();
// update one book
   // int j = db.updateBook(list.get(3), "Hello, Android", "Ben Wallace", 4);

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

   // ListDataActivity listDataActivity = new ListDataActivity();
}

}
