package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userMessage;

    Button counter;

    CheckBox remember;

    int count = 0;

    String name;
    String message;
    Boolean checked;

    SharedPreferences sharedPreferences;

    Button changeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.editTextText);
        userMessage = findViewById(R.id.editTextTextMultiLine);
        counter = findViewById(R.id.button);
        remember = findViewById(R.id.checkBox);
        changeButton = findViewById(R.id.change);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                counter.setText("" + count);
            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        retrieveData();
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    public void saveData() {
        // name = for main sharedPreferences class , mode = private -> save data from everywhere but restrict from outside ( other application
        // can't reach this sharedPreferences)
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = userName.getText().toString();
        message = userMessage.getText().toString();
        if(remember.isChecked()) {
            checked = true;
        } else {
            checked = false;
        }

        // save data
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key name", name);
        editor.putString("key message", message);
        editor.putInt("key count", count);
        editor.putBoolean("key remember", checked);
        editor.commit(); // store data
        Toast.makeText(getApplicationContext(), "Your data is saved", Toast.LENGTH_LONG).show();
    }

    public void retrieveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("key name", null); // null = default value if key name does not present or nothing is saved
        message = sharedPreferences.getString("key message", null);
        count = sharedPreferences.getInt("key count", 0);
        checked = sharedPreferences.getBoolean("key remember", false);

        userName.setText(name);
        userMessage.setText(message);
        counter.setText(""+count); // convert int to string

        if (checked == true) {
            remember.setChecked(true);
        } else {
            remember.setChecked(false);
        }

    }
}