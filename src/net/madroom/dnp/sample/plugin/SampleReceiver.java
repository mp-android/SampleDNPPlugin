package net.madroom.dnp.sample.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;

public class SampleReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if(bundle==null) {
            return;
        }

        Intent i = new Intent("net.madroom.dnp.plugin.MUSIC_STATUS");
        i.putExtra("artist", bundle.getString("artist"));
        i.putExtra("album", bundle.getString("album"));
        i.putExtra("track", bundle.getString("track"));
        new ContextWrapper(context).sendBroadcast(i);
        System.exit(0);
    }
}
