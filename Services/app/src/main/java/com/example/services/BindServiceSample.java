package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class BindServiceSample extends Service {

    private final IBinder iBinder = new LocalBinder();
    private final Random mGenerator = new Random();

    public int gerRandom() {
        return mGenerator.nextInt(200);
    }
    public BindServiceSample() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class LocalBinder extends Binder {
        BindServiceSample getService() {
            return BindServiceSample.this;
        }
    }
}