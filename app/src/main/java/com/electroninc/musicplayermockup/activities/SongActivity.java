package com.electroninc.musicplayermockup.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.models.Song;
import com.electroninc.musicplayermockup.utils.Utils;

public class SongActivity extends AppCompatActivity {

    public static final String INTENT_SONG = "song";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent intent = getIntent();
        Song song = (Song) intent.getSerializableExtra(INTENT_SONG);
        if (song == null) return;

        // song duration, rewind, play_pause, forward
        ImageView albumArtBackground = findViewById(R.id.album_art_background);
        ImageView albumArt = findViewById(R.id.album_art);
        TextView albumName = findViewById(R.id.album_name);
        TextView nowPlaying = findViewById(R.id.now_playing);
        TextView artistName = findViewById(R.id.artist_name);
        TextView songDuration = findViewById(R.id.song_duration);
        ImageView rewind = findViewById(R.id.rewind);
        ImageView playPause = findViewById(R.id.play_pause);
        ImageView forward = findViewById(R.id.forward);

        albumArtBackground.setImageResource(song.getAlbumArt());
        albumArt.setImageResource(song.getAlbumArt());
        albumName.setText(song.getAlbum());
        nowPlaying.setText(song.getName());
        nowPlaying.setSelected(true);
        artistName.setText(song.getArtist());
        songDuration.setText(Utils.formatDuration(song.getLength()));
    }
}
