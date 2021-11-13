package com.example.a407lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat nManager;
    private EditText edit_title;
    private EditText edit_message;
    private String CH_1_ID = App.CH_1_ID;
    private String CH_2_ID = App.CH_2_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nManager = NotificationManagerCompat.from(this);
    }

    public void sendOnChannel1(View v){
        edit_title = (EditText) findViewById(R.id.text_title);
        edit_message = (EditText) findViewById(R.id.text_message);
        String title = edit_title.getText().toString();
        String msg = edit_message.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,0);

        Intent broadcastIntent =  new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", msg);
        PendingIntent aIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = new NotificationCompat.Builder(this, CH_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher,"Toast", aIntent)
                .build();
        nManager.notify(1,notification);
    }
    public void sendOnChannel2(View v){
        edit_title = (EditText) findViewById(R.id.text_title);
        edit_message = (EditText) findViewById(R.id.text_message);
        String title = edit_title.getText().toString();
        String msg = edit_message.getText().toString();


        Notification notification = new NotificationCompat.Builder(this, CH_2_ID)
                .setSmallIcon(R.drawable.hutao)
                .setContentTitle(title)
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        nManager.notify(2,notification);
    }
}