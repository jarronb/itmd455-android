package com.example.bailey.bookreviews;

import android.app.Activity;
import android.app.Notification;
import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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

 public class CustomAdapter extends BaseAdapter {

    private final Activity context;
    private final ArrayList<String> bookName;
    private final ArrayList<Integer> bookRating;
    private final ArrayList<String> bookAuthor;
    // private final List<Book> list_books;
    SqlHelper db;

    public CustomAdapter(Activity context, ArrayList<String> bookName, ArrayList<Integer> bookRating, ArrayList<String> bookAuthor) {
        //ArrayAdapter(Context context, int resource, T[] objects)
        db = new SqlHelper(context);
        Cursor data = db.getData();
        List<Book> list = db.getAllBooks();

        this.context = context;
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.bookRating = bookRating;


    }

    @Override
    public int getCount() {
    return bookAuthor.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View rowView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        //inflate(int resource, ViewGroup root, boolean attachToRoot)
        rowView = inflater.inflate(R.layout.listview,
                null, true);


        TextView textView_itemNumber = rowView.findViewById(R.id.tv_itemNumber);
        TextView textView_bookName = rowView.findViewById(R.id.tv_BookName);
        TextView textView_bookAuthor = rowView.findViewById(R.id.tv_BookAuthur);
        RatingBar ratingBar = rowView.findViewById(R.id.rb_ratingBar);
        textView_itemNumber.setText(Integer.toString(position+1));
        textView_bookAuthor.setText(bookAuthor.get(position));
        textView_bookName.setText(bookName.get(position));
        ratingBar.setNumStars(5);
        ratingBar.setRating(bookRating.get(position));
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
        return rowView;
    }

}
