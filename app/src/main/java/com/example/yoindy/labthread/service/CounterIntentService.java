package com.example.yoindy.labthread.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.InterpolatorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by YoInDy on 18/6/2560.
 */

public class CounterIntentService extends IntentService {

    public CounterIntentService() {
        super("");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CounterIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Run in Background Thread
        for (int i = 0; i < 100; i++) {
            Log.d("IntentService","i = " +i);
            Intent broadcastIntent = new Intent("CounterIntentServiceUpdate");
            broadcastIntent.putExtra("counter", i);
            LocalBroadcastManager.getInstance(CounterIntentService.this)
                    .sendBroadcast(broadcastIntent);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
