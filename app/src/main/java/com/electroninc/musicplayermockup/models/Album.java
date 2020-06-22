package com.electroninc.musicplayermockup.models;

import java.io.Serializable;

public class Album implements Serializable {
    public static final int TYPE_RECENTLY_PLAYED = 1;
    public static final int TYPE_FAVOURITES = 2;
    public static final int TYPE_POPULAR = 3;
    public static final int TYPE_RECOMMENDED = 4;

    private String name;
    private int type;
    private int artResource;

    public Album(String name, int type, int artResource) {
        this.name = name;
        this.type = type;
        this.artResource = artResource;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getArtResource() {
        return artResource;
    }
}
