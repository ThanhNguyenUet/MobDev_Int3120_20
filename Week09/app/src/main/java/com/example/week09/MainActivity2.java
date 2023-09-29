package com.example.week09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    BroadcastExample br = new BroadcastExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // take receiver & send boolean parameter in intent.getbooleanextra
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(br, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}