package com.example.steven.spaghetti;

import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import static android.R.attr.smallIcon;

/**
 * Created by Steven on 17-Oct-17.
 */

public class BackgroundNotification extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();

        //you can get your text message here.
        String text= data.get("text");

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle(text)
                        .setContentText(text);
    }

    // Sets an ID for the notification
    int mNotificationId = 1;
    // Gets an instance of the NotificationManager service
    NotificationManager mNotifyMgr =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    // Builds the notification and issues it.
    //mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

