package com.electroninc.musicplayermockup.models;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private String artist;
    private int length;
    private String album;
    private int albumArt;

    public Song(String name, String artist, int length, String album, int albumArt) {
        this.name = name;
        this.artist = artist;
        this.length = length;
        this.album = album;
        this.albumArt = albumArt;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }

    public String getAlbum() {
        return album;
    }

    public int getAlbumArt() {
        return albumArt;
    }
}
