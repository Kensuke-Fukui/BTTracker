package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        TextView mainButton1 = findViewById(R.id.MainButton1);
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.MainButton2);
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.MainButton3);
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.MainButton4);
        mainButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MainButton1:
                // If MainButton1 is clicked, do something
                Intent toLog = new Intent(this, LogActivity.class);
                startActivity(toLog);
                break;
            case R.id.MainButton2:
                // If MainButton2 is clicked, do something
                Intent toNormal = new Intent(this, NormalActivity.class);
                startActivity(toNormal);
                break;
            case R.id.MainButton3:
                // If MainButton3 is clicked, do something
                Intent toMechanism = new Intent(this, MechanismActivity.class);
                startActivity(toMechanism);
                break;
            case R.id.MainButton4:
                // If MainButton4 is clicked, do something
                Intent toHandle = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));

                startActivity(toHandle);
                break;
        }

    }

    public void setReminder(View view) {
        // When user clicks "SET REMINDER" button, a toast message will pop up to let user know that reminder is set
        Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
        // Create an intent object to start the ReminderBroadcastReceiver class
        Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
        // Create a pending intent so that the intent object above will only fire when alarm triggers
        PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
        // Create an AlarmManager
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        // Repeating interval for the alarmManager is set to 6 second for demonstration purpose
        // In real world application, users may want to get daily reminder
        // In that case, set the interval to 1000 * 60 * 60 * 24
        long interval = 1000*6;
        // set up a repeating alarm so that the notification reminder gets fired at the set interval
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), interval, pd);
    }
    private  void createNotificationChannel(){
        // First, check SDK version
        // Create notification channel only if SDK version > Android 8 Oreo
        // CAUTION: It's Oreo's O, not number 0!!!
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelDescription = "Channel for BTTracker reminder";
            int inportance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID, channelName, inportance);
            channel.setDescription(channelDescription);
            // Create a notification manager
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            // Create notification channel
            notificationManager.createNotificationChannel(channel);
        }
    }
}
