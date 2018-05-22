package com.example.diego.broadcasting;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by diego on 22-05-2018.
 */

public class DeviceBootReciver extends BroadcastReceiver {
    private String TAG = "device boot receiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            Intent myIntent = new Intent(context, MainActivity.class);
            context.startActivity(myIntent);
            Log.i(TAG,"Recived");

            Intent intentAlarm = new Intent(context, AlarmReceiver.class);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            alarmManager.setInexactRepeating(AlarmManager.RTC, SystemClock.elapsedRealtime(), 60000,
                    PendingIntent.getBroadcast(context,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
        }catch(Exception e){
            Log.e(TAG,e.toString());
        }
    }
}
