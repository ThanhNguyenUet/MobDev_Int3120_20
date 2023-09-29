package com.example.week09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class greetingactivity extends AppCompatActivity {

    Button button;

    Button dial;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetingactivity);

        button = findViewById(R.id.button3);
        dial = findViewById(R.id.button4);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"));
                startActivity(dialIntent);
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