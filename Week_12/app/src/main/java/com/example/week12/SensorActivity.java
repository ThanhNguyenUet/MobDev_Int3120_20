package com.example.week12;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    List list;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        tv = findViewById(R.id.text_sensor);
    }

    SensorEventListener sel = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            tv.setText("x : " + values[0] + "\ny :"
                    + values[1] + "\nz :" + values[2]);
        };

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        // get a sensorManager instance
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // accelerometer
        list = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (list.size() > 0) {
            sensorManager.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "Error : No accelerometer", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        // unregister
        if (list.size() > 0) {
            sensorManager.unregisterListener(sel);
        }
        super.onStop();
    }
}