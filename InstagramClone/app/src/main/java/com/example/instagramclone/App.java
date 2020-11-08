package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5d60a1TWQMmFxYbDzMXjsw9fOCMBxrtPEYhrqnI0")
                // if defined
                .clientKey("YOQApng6LWLeLiiEXojLHocQNCxbvxemrSFznskcTEUR_CLIENT_KEY")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
