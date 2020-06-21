package com.electroninc.musicplayermockup.models;

public class Song {
    private String name;
    private String artist;
    private int length;

    public Song(String name, String artist, int length) {
        this.name = name;
        this.artist = artist;
        this.length = length;
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
}
