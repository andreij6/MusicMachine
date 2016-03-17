package com.creativejones.andre.musicmachine;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DownloadIntentService extends IntentService {
    private static final String TAG = DownloadIntentService.class.getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DownloadIntentService() {
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSong(song);
    }

    private void downloadSong(String song) {

        long endTime = System.currentTimeMillis() + 10 * 1000;

        while (System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.d(TAG, song + " downloaded!");

    }
}
