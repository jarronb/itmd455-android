package com.example.bailey.bookreviews;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<String> {
    private boolean emptyRemoved = false;


    public SpinnerAdapter(@NonNull Context context, ArrayList<String> titles) {
        super(context, R.layout.spinnerlayout, R.id.tv_spinTitle, titles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }


}
