package com.creativejones.andre.musicmachine;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String KEY_SONG = "song_key";
    private Button mDownloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadBtn = (Button)findViewById(R.id.downloadBtn);

        mDownloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading...", Toast.LENGTH_SHORT).show();

                //Send Messages or Runnables to Handler for processing
                for(String song : Playlist.songs){
                    Intent intent = new Intent(MainActivity.this, DownloadIntentService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }
            }
        });
    }


}
