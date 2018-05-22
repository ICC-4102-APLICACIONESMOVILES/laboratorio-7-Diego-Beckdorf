package com.example.diego.broadcasting;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Random;

/**
 * Created by diego on 22-05-2018.
 */

public class AlarmReceiver extends BroadcastReceiver {
    private String TAG = "Alarm reciever";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i(TAG, "Alarm recieved");
        //Notify
        NotificationCompat.Builder mbuilder =
                new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Notification")
                .setContentText("Alarm recieved");

        Intent resultIntent = new Intent(context, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);

        stackBuilder.addParentStack(MainActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_CANCEL_CURRENT
                );

        Random r = new Random();
        int i1 = r.nextInt(100 - 1) + 1;
        mbuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(i1, mbuilder.build());
    }
}
