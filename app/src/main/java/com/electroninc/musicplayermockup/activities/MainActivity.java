package com.electroninc.musicplayermockup.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.adapters.AlbumsAdapter;
import com.electroninc.musicplayermockup.models.Album;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AlbumsAdapter.ItemClickListener {

    public static final int[] ALBUM_ARTS = new int[]{
            R.drawable.generic_album_art_1,
            R.drawable.generic_album_art_2,
            R.drawable.generic_album_art_3,
            R.drawable.generic_album_art_4
    };
    public static final int GENERIC_ART_COUNT = ALBUM_ARTS.length;

    private List<Album> recentlyPlayedAlbums = new ArrayList<>();
    private List<Album> favouriteAlbums = new ArrayList<>();
    private List<Album> popularAlbums = new ArrayList<>();
    private List<Album> recommendedAlbums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.now_playing).setSelected(true);
        Random random = new Random();

        // Recently played
        for (int i = 1; i <= 10; i++) {
            recentlyPlayedAlbums.add(new Album(
                    "Recently played " + i,
                    Album.TYPE_RECENTLY_PLAYED,
                    ALBUM_ARTS[random.nextInt(GENERIC_ART_COUNT)])
            );
        }
        setupRecyclerView(recentlyPlayedAlbums, R.id.recently_played);

        // Favourites
        for (int i = 1; i <= 10; i++) {
            favouriteAlbums.add(new Album(
                    "Favourites " + i,
                    Album.TYPE_FAVOURITES,
                    ALBUM_ARTS[random.nextInt(GENERIC_ART_COUNT)])
            );
        }
        setupRecyclerView(favouriteAlbums, R.id.favourites);

        // Popular
        for (int i = 1; i <= 10; i++) {
            popularAlbums.add(new Album(
                    "Popular " + i,
                    Album.TYPE_POPULAR,
                    ALBUM_ARTS[random.nextInt(GENERIC_ART_COUNT)])
            );
        }
        setupRecyclerView(popularAlbums, R.id.popular);

        // Recommended
        for (int i = 1; i <= 10; i++) {
            recommendedAlbums.add(new Album(
                    "Recommended " + i,
                    Album.TYPE_RECOMMENDED,
                    ALBUM_ARTS[random.nextInt(GENERIC_ART_COUNT)])
            );
        }
        setupRecyclerView(recommendedAlbums, R.id.recommended);

        findViewById(R.id.bottom_song_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do nothing
                // This was added to activate 'selectableItemBackground'
            }
        });
    }

    @Override
    public void onItemClicked(int type, int itemId) {
        Album album = null;
        switch (type) {
            case Album.TYPE_RECENTLY_PLAYED:
                album = recentlyPlayedAlbums.get(itemId);
                break;
            case Album.TYPE_FAVOURITES:
                album = favouriteAlbums.get(itemId);
                break;
            case Album.TYPE_POPULAR:
                album = popularAlbums.get(itemId);
                break;
            case Album.TYPE_RECOMMENDED:
                album = recommendedAlbums.get(itemId);
                break;
        }

        if (album != null) {
            Intent intent = new Intent(this, SongListActivity.class);
            intent.putExtra(SongListActivity.INTENT_ALBUM, album);
            startActivity(intent);
        }
    }

    private void setupRecyclerView(List<Album> albums, int viewResource) {
        AlbumsAdapter albumsAdapter = new AlbumsAdapter(this, albums, this);
        RecyclerView recyclerView = findViewById(viewResource);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        ));
        recyclerView.setAdapter(albumsAdapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

}
