package com.example.bttracker;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.util.Log;

public class ReminderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String TAG = "onReceive";
        // TODO: This method is called when the BroadcastReceiver is receiving
        Intent notificationIntent = new Intent(context, LogActivity.class);
        PendingIntent contentInent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        // an Intent broadcast.
        Log.d(TAG, "start building notification");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "BT_Tracker_Channel")//this second argument has to match the Channel ID defined in MainActivity.java
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notification from BT Tracker")
                .setContentText("Please log your body temperature now")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(contentInent);
        Log.d(TAG, "finish building notification");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        Log.d(TAG,"start firing notification");
        notificationManager.notify(200, builder.build());
        Log.d(TAG, "notification fired");
    }
}
