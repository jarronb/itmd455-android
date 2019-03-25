package com.example.bailey.midterm;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by baile on 9/26/2017.
 */

 class custom_adapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] class_number;
    private final String[] class_name;

    public custom_adapter(Activity context, String[] class_name, String[] class_number) {

        //ArrayAdapter(Context context, int resource, T[] objects)
        super(context, R.layout.class_view, class_name);
        this.context = context;
        this.class_name = class_name;
        this.class_number = class_number;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View rowView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        //inflate(int resource, ViewGroup root, boolean attachToRoot)
        rowView = inflater.inflate(R.layout.class_view,
                null, true);


        TextView tv_name = (TextView) (rowView.findViewById(R.id.tv_class_name));
        TextView tv_number = (TextView) (rowView.findViewById(R.id.tv_class_number));

        tv_name.setText(class_name[position]);
        tv_number.setText(class_number[position]);
        return rowView;
    }
}
