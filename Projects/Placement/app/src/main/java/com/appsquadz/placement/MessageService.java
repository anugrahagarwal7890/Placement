package com.appsquadz.placement;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MessageService extends FirebaseMessagingService {

//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        new SharedPrefManager(this).setToken(s);
        Log.e("tkn",s);
    }
}
