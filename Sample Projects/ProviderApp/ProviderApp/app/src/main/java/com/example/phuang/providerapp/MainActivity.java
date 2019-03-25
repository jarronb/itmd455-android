package com.example.phuang.providerapp;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {
    Button butSave, butRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butSave = (Button) findViewById(R.id.butsave);
        butRead = (Button) findViewById(R.id.butread);

        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(StudentsProvider.NAME,
                        ((EditText)findViewById(R.id.editname)).getText().toString());

                values.put(StudentsProvider.GRADE,
                        ((EditText)findViewById(R.id.editgrade)).getText().toString());

                Uri uri = getContentResolver().insert(
                        StudentsProvider.CONTENT_URI, values);

                Toast.makeText(getBaseContext(),
                        uri.toString(), Toast.LENGTH_LONG).show();
            }
        });

        butRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL = "content://com.example.MyApplication.StudentsProvider";

                Uri students = Uri.parse(URL);
                Cursor c = managedQuery(students, null, null, null, "name");

                if (c.moveToFirst()) {
                    do{
                        Toast.makeText(getApplicationContext(),
                                c.getString(c.getColumnIndex(StudentsProvider._ID)) + ", "
                                        +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) + ", "
                                        + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                                Toast.LENGTH_SHORT).show();
                    } while (c.moveToNext());
                }
            }
        });
    }

}
