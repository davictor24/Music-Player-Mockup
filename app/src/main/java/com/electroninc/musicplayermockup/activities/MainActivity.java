package com.electroninc.musicplayermockup.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.adapters.AlbumsAdapter;
import com.electroninc.musicplayermockup.models.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AlbumsAdapter.ItemClickListener {

    List<Album> recentlyPlayedAlbums = new ArrayList<>();
    List<Album> favouriteAlbums = new ArrayList<>();
    List<Album> popularAlbums = new ArrayList<>();
    List<Album> recommendedAlbums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.now_playing).setSelected(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Recently played
        for (int i = 1; i <= 10; i++)
            recentlyPlayedAlbums.add(new Album("Recently played " + i, Album.TYPE_RECENTLY_PLAYED, R.drawable.material_image));
        AlbumsAdapter recentlyPlayedAlbumsAdapter = new AlbumsAdapter(this, recentlyPlayedAlbums, this);
        RecyclerView recentlyPlayedRecyclerView = findViewById(R.id.recently_played);
        recentlyPlayedRecyclerView.setLayoutManager(layoutManager);
        recentlyPlayedRecyclerView.setAdapter(recentlyPlayedAlbumsAdapter);
    }

    @Override
    public void onItemClickListener(int type, int itemId) {
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

        if (album != null)
            Toast.makeText(this, album.getName(), Toast.LENGTH_SHORT).show();
    }

}
