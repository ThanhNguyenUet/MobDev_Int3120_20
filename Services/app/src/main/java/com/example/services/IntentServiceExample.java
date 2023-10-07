package com.example.services;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class IntentServiceExample extends IntentService {
    /**
     * @param name
     * @deprecated
     */
    public IntentServiceExample(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // we will do some work here -> after done -> ondelete (automatically) -> decapricated
    }
}
