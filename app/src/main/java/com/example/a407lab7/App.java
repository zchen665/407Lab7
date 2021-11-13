package com.example.a407lab7;

import android.app.Application;
import android.os.Build;

public class App extends Application {
    public final static String CH_1_ID = "channel1";

    @Override
    public void onCreate(){
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){

        }
    }
}
