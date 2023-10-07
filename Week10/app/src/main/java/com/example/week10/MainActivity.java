package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // cai ban phim luc an vao text view
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
    public void onClickAddDetails(View view) {

        // class to add values in the database
        ContentValues values = new ContentValues();

        EditText text = findViewById(R.id.textName);



        String[] divide = text.getText().toString().split("\n");

        for (int i = 0; i < divide.length; i++) {
            // fetching text from user
            values.put(AndroidIDProvider.name, divide[i]);
            getContentResolver().insert(AndroidIDProvider.CONTENT_URI, values);
        }

//        ((EditText) findViewById(R.id.textName)).getText().toString()
        // inserting into database through content URI
//        getContentResolver().insert(AndroidIDProvider.CONTENT_URI, values);

        // displaying a toast message
        Toast.makeText(getBaseContext(), "New Record Inserted", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("Range")
    public void onClickShowDetails(View view) {
        // inserting complete table details in this text field
        TextView resultView= (TextView) findViewById(R.id.res);

        // creating a cursor object of the
        // content URI
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.android.example.week10.AndroidIDProvider/users"), null, null, null, null);

        // iteration of the cursor
        // to print whole table
        if(cursor.moveToFirst()) {
            StringBuilder strBuild=new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n"+cursor.getString(cursor.getColumnIndex("id"))+ "-"+ cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
            resultView.setText(strBuild);
        }
        else {
            resultView.setText("No Records Found");
        }
    }

    public void onClickUpdateDetails(View view) {
        // get data by id
//        String user_id = findViewById(R.id.text_id).toString();
//        Cursor cursor = getContentResolver().update(Uri.parse("content://com.android.example.week10.AndroidIDProvider/users/" + user_id, );
//        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name")).toString();
//
//        TextView textUpdate = findViewById(R.id.text_update);
//
//
//        ContentValues values = new ContentValues();
//        values.put();

    }
}