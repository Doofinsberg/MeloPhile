package com.aditya.melophile;

import android.app.Application;
import com.firebase.client.Firebase;

public class FireApp extends Application {

    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
