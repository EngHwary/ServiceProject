package com.example.nh.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Toast.makeText(MyService.this,"Service Created",Toast.LENGTH_SHORT).show();
        super.onCreate();

    }
    MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(MyService.this,"Service Started",Toast.LENGTH_SHORT).show();

        new Thread(new Runnable() {
            @Override
            public void run() {

                player = MediaPlayer.create(MyService.this, R.raw.music);
                player.start();

            }
        }).start();






        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this,"Service Ended",Toast.LENGTH_SHORT).show();
        player.stop();
        super.onDestroy();
    }
}
