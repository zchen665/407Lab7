package com.example.a407lab7;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public final static String CH_1_ID = "channel1";
    public final static String CH_2_ID = "channel2";

    @Override
    public void onCreate(){
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel ch1 = new NotificationChannel(
                    CH_1_ID,
                    "channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationChannel ch2 = new NotificationChannel(
                    CH_2_ID,
                    "channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            ch1.setDescription("This is channel 1");
            ch2.setDescription("This is channel 2 hutao");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(ch1);
            manager.createNotificationChannel(ch2);

        }
    }
}
