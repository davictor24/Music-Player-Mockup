package com.electroninc.musicplayermockup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.models.Album;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {
    private List<Album> albums;
    private Context context;
    private ItemClickListener itemClickListener;

    public AlbumsAdapter(Context context, List<Album> albums, ItemClickListener itemClickListener) {
        this.context = context;
        this.albums = albums;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.album_view, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return albums == null ? 0 : albums.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.albumArt.setImageResource(album.getArtResource());
        holder.albumName.setText(album.getName());
    }

    public interface ItemClickListener {
        void onItemClicked(ImageView imageView, int type, int itemId);
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView albumArt;
        TextView albumName;

        AlbumViewHolder(View itemView) {
            super(itemView);
            albumArt = itemView.findViewById(R.id.album_art);
            albumName = itemView.findViewById(R.id.album_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Album album = albums.get(getAdapterPosition());
            itemClickListener.onItemClicked(albumArt, album.getType(), getAdapterPosition());
        }
    }
}
