package com.example.week09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    public void sendMessage() {
        String fullname = this.editText.getText().toString();
        String message = "Hello";

        Intent intent = new Intent(getApplicationContext(), greetingactivity.class);
        intent.putExtra("fullName", fullname); // editText
        intent.putExtra("message", message); // hello
        startActivity(intent);
    }
}