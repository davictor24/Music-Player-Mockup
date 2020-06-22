package com.electroninc.musicplayermockup.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.models.Song;
import com.electroninc.musicplayermockup.utils.Utils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_MAIN = 2;

    private List<Song> songs;
    private Context context;
    private ItemClickListener itemClickListener;

    public SongsAdapter(Context context, List<Song> songs, ItemClickListener itemClickListener) {
        this.context = context;
        this.songs = songs;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? TYPE_HEADER : TYPE_MAIN;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.song_header_view, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.song_view, parent, false);
            return new MainViewHolder(view);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        if (holder.getViewHolderType() == TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            int len = songs.size();
            if (len > 0) {
                Song indexSong = songs.get(0);
                headerViewHolder.getAlbumArt().setImageResource(indexSong.getAlbumArt());
                headerViewHolder.getAlbumInfo().setText(indexSong.getAlbum()
                        + " | " + len + ((len == 1) ? " song" : " songs"));
            }
        } else {
            MainViewHolder mainViewHolder = (MainViewHolder) holder;
            Song song = songs.get(position - 1);
            mainViewHolder.getSongNumber().setText(String.valueOf(position));
            mainViewHolder.getSongName().setText(song.getName());
            mainViewHolder.getSongArtist().setText(song.getArtist());
            mainViewHolder.getSongDuration().setText(Utils.formatDuration(song.getLength()));
        }
    }

    @Override
    public int getItemCount() {
        return songs == null ? 1 : songs.size() + 1;
    }

    public interface ItemClickListener {
        void onItemClicked(int itemId);
    }

    abstract class SongViewHolder extends RecyclerView.ViewHolder {
        SongViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        abstract int getViewHolderType();
    }

    class HeaderViewHolder extends SongViewHolder {
        private ImageView albumArt;
        private TextView albumInfo;

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            albumArt = itemView.findViewById(R.id.album_art);
            albumInfo = itemView.findViewById(R.id.album_info);
        }

        @Override
        int getViewHolderType() {
            return TYPE_HEADER;
        }

        ImageView getAlbumArt() {
            return albumArt;
        }

        TextView getAlbumInfo() {
            return albumInfo;
        }
    }

    class MainViewHolder extends SongViewHolder implements View.OnClickListener {
        private TextView songNumber;
        private TextView songName;
        private TextView songArtist;
        private TextView songDuration;

        MainViewHolder(View itemView) {
            super(itemView);
            songNumber = itemView.findViewById(R.id.song_number);
            songName = itemView.findViewById(R.id.song_name);
            songArtist = itemView.findViewById(R.id.song_artist);
            songDuration = itemView.findViewById(R.id.song_duration);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // TODO
//            itemClickListener.onItemClicked(...);
        }

        @Override
        int getViewHolderType() {
            return TYPE_MAIN;
        }

        TextView getSongNumber() {
            return songNumber;
        }

        TextView getSongName() {
            return songName;
        }

        TextView getSongArtist() {
            return songArtist;
        }

        TextView getSongDuration() {
            return songDuration;
        }
    }

}
