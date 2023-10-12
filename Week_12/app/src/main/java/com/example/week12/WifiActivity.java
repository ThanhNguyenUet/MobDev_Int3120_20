package com.example.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WifiActivity extends AppCompatActivity {

    Button btn_on;
    Button btn_off;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        btn_on = findViewById(R.id.btn_on);
        btn_off = findViewById(R.id.btn_off);
        tv = findViewById(R.id.wifi_tv);
        WifiManager wifiManager = (WifiManager) getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        btn_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.setWifiEnabled(true); // wait for google as from API 29 above this does not work
                tv.setText(""+wifiManager.getWifiState());
            }
        });

        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifiManager.setWifiEnabled(false);
            }
        });
    }
}