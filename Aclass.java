package com.example.kalon.overchargeindicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.provider.Settings;

/**
 * Created by KALON on 02-07-2018.
 */

public class Aclass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
        MediaPlayer mp = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        if(level>97) {
            mp.start();
        }
    }
}
