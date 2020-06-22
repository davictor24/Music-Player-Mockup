package com.electroninc.musicplayermockup.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionInflater;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.adapters.SongsAdapter;
import com.electroninc.musicplayermockup.models.Album;
import com.electroninc.musicplayermockup.models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongListActivity extends AppCompatActivity implements SongsAdapter.ItemClickListener {

    public static final String INTENT_ALBUM = "album";
    private List<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        findViewById(R.id.now_playing).setSelected(true);
        Random random = new Random();

        Intent intent = getIntent();
        Album album = (Album) intent.getSerializableExtra(INTENT_ALBUM);
        if (album == null) return;

        // TODO: Save the generated data in a ViewModel
        songs = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
            songs.add(new Song(
                    album.getName() + " song " + i,
                    "Artist " + i,
                    120 + random.nextInt(180),
                    album.getName(),
                    album.getArtResource()
            ));

        RecyclerView recyclerView = findViewById(R.id.song_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SongsAdapter songsAdapter = new SongsAdapter(this, songs, this);
        recyclerView.setAdapter(songsAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this)
                    .inflateTransition(R.transition.album_art_transition));
    }

    @Override
    public void onItemClicked(int itemId) {
        Song song = songs.get(itemId);
        Intent intent = new Intent(this, SongActivity.class);
        intent.putExtra(SongActivity.INTENT_SONG, song);
        startActivity(intent);
    }

}
