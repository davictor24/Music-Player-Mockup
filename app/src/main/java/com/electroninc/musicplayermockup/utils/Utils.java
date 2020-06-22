package com.electroninc.musicplayermockup.utils;

import android.content.Context;

import com.electroninc.musicplayermockup.R;
import com.electroninc.musicplayermockup.models.Song;

import java.util.Locale;

public final class Utils {
    private Utils() {
        // Private constructor, to prevent instantiation
    }

    public static String formatDuration(int duration) {
        return String.format(
                Locale.getDefault(),
                "%02d:%02d",
                duration / 60,
                (duration % 60)
        );
    }

    public static Song getDummySong(Context context) {
        return new Song(
                context.getString(R.string.mozart_sonata),
                "W A Mozart",
                307,
                "Mozart Sonatas Classical Piano",
                R.drawable.generic_album_art_4
        );
    }
}
