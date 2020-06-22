package com.electroninc.musicplayermockup.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.models.Song;

public class SongActivity extends AppCompatActivity {

    public static final String INTENT_SONG = "song";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra(INTENT_SONG);
        Toast.makeText(this, song.getName(), Toast.LENGTH_SHORT).show();
    }
}
