package com.example.week09;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class BroadcastExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
         if (isAirPlaneModeOn(context.getApplicationContext())) {
             Toast.makeText(context, "Device is in airplane mod", Toast.LENGTH_LONG).show();
         } else {
             Toast.makeText(context, "Device is not in airplane mod", Toast.LENGTH_LONG).show();
         }
    }

    private static boolean isAirPlaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
