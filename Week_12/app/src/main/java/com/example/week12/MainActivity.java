package com.example.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_sensor;
    Button btn_wifi;
    Button btn_tele_service;
    Button btn_camera;
    Button btn_bluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sensor = findViewById(R.id.sensor);
        btn_wifi = findViewById(R.id.wifi);
        btn_tele_service = findViewById(R.id.tele_service);
        btn_camera = findViewById(R.id.camera);
        btn_bluetooth = findViewById(R.id.bluetooth);

        btn_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(intent);
                finish(); // stop mainActivity
            }
        });

        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WifiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_tele_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TelephonyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BluetoothActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}