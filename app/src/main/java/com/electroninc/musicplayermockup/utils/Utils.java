package com.electroninc.musicplayermockup.utils;

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
}
