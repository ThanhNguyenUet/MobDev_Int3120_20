package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class greetingactivity extends AppCompatActivity {

    Button button;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetingactivity);

        button = findViewById(R.id.button3);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });

        Intent intent = this.getIntent();
        textView2.setText(intent.getStringExtra("fullName"));
        textView3.setText(intent.getStringExtra("message"));


    }

    public void goback() {
        this.onBackPressed();
    }
}