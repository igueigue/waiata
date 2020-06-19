package com.example.waiata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import com.example.waiata.SongContract.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mySongs";
    public static final int DBVERSION = 1;


    private static DBHelper instance;
    private SQLiteDatabase mDB;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context.getApplicationContext()); //use DBhelper for whole app, instead of activity only
        }
        return instance;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.mDB = db;


        String create_songs_table = "CREATE TABLE IF NOT EXISTS " + SongsTable.TABLE_SONGS + "(" +
                SongsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                SongsTable.COL_SONG_TITLE + "INTEGER UNIQUE," +
                SongsTable.COL_VIDEO_PATH + " INTEGER, " +
                SongsTable.COL_IMAGE_PATH + " INTEGER, " +
                SongsTable.COL_mLyrics + " INTEGER, " +
                SongsTable.COL_elyrics + " INTEGER, " +
                SongsTable.COL_SONG_DESC + " INTEGER" +
                ")";
        db.execSQL(create_songs_table);
        fillSongs();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SongsTable.TABLE_SONGS);
        onCreate(db);

    }


    private void fillSongs() {

        Song song1 = new Song(R.string.title_tuti,R.raw.tutiramainga_1,R.drawable.feather,
                R.string.elyrics_tuti,R.string.mlyrics_tuti,R.string.desc_tuti);
        insertSong(song1);
        Song song2 = new Song(R.string.title_waikato,R.raw.waikatoteawa_2,R.drawable.culture,
                R.string.elyrics_tuti,R.string.mlyrics_waikato,R.string.desc_waikato);
        insertSong(song2);



    }

    private void insertSong(Song song) {
        ContentValues cv = new ContentValues();
        cv.put(String.valueOf(SongsTable.COL_SONG_TITLE), song.getTitle());
        cv.put(String.valueOf(SongsTable.COL_VIDEO_PATH), song.getVidPath());
        cv.put(String.valueOf(SongsTable.COL_IMAGE_PATH), song.getImgPath());
        cv.put(String.valueOf(SongsTable.COL_elyrics), song.geteLyrics());
        cv.put(String.valueOf(SongsTable.COL_mLyrics), song.getmLyrics());
        mDB.insert(SongsTable.TABLE_SONGS,null,cv);
    }


    public List<Song> getAllSongTitles() {
        List<Song> songList = new ArrayList<>();
        mDB = getReadableDatabase();
        Cursor c = mDB.rawQuery("SELECT * FROM " + SongsTable.TABLE_SONGS, null);
        if (c.moveToFirst()) {
            do {
                Song song = new Song();
                song.setTitle(c.getInt(c.getColumnIndex(String.valueOf(SongsTable.COL_SONG_TITLE))));
                song.setImgPath(c.getInt(c.getColumnIndex(String.valueOf(SongsTable.COL_IMAGE_PATH))));
                songList.add(song);
            } while (c.moveToNext());
        }
        c.close();
        return songList;
    }


}


