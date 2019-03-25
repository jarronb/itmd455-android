package com.example.bailey.bookreviews;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baile on 11/20/2017.
 */

public class CustomAdapter extends ArrayAdapter<Book> {

    private final Activity context;
    private final String[] bookName;
    private final Integer[] bookRating;
    private final String[] bookAuthor;
   // private final List<Book> list_books;
    SqlHelper db = new SqlHelper(getContext());

    public CustomAdapter(Activity context, Book book, String bookName[], Integer[] bookRating, String[] bookAuthor) {
        //ArrayAdapter(Context context, int resource, T[] objects)
        super(context, R.layout.listview_viewer, (List<Book>) book);
        Cursor data = db.getData();


        this.context = context;
        this.bookAuthor = moviename;
        this.bookName = imgid;
        this.bookRating = moviedescription;
        List<Book> books = new ArrayList<Book>();
        books=db.getAllBooks();

    }

    @Override
    public View getView(int position, @Nullable View rowView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        //inflate(int resource, ViewGroup root, boolean attachToRoot)
        rowView = inflater.inflate(R.layout.listview_viewer,
                null, true);


        TextView textView_itemNumber = (TextView) (rowView.findViewById(R.id.tv_itemNumber));
        TextView textView_bookName = (TextView) (rowView.findViewById(R.id.tv_BookName));
        TextView textView_bookAuthor = (TextView) (rowView.findViewById(R.id.tv_BookAuthur));
        RatingBar ratingBar = (RatingBar)(rowView.findViewById(R.id.rb_ratingBar));

        //imageView.setImageResource(imgid[position]);
        //textView_name.setText(moviename[position]);
        //textView_description.setText(moviedescription[position]);
        return rowView;
    }
}
