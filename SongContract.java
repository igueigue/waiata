package com.example.waiata;

import android.provider.BaseColumns;

public final class SongContract {

    private SongContract() {}

    public static class SongsTable implements BaseColumns {
        public static final String TABLE_SONGS = "songs";
        public static final String COL_SONG_TITLE = "title";
        public static final String COL_VIDEO_PATH = "video_path";
        public static final String COL_SONG_DESC = "description";
        public static final String COL_IMAGE_PATH = "image_path";
        public static final String COL_elyrics = "english_lyrics";
        public static final String COL_mLyrics = "maori_lyrics";

    }


}
