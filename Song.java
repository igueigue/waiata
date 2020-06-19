package com.example.waiata;

public class Song {

    private int title;
    private int vidPath;
    private int imgPath;
    private int  eLyrics;
    private int mLyrics;
    private int desc;


    public Song() {
    }

    public Song(int title, int vidPath, int imgPath, int eLyrics, int mLyrics, int desc) {
        this.title = title;
        this.vidPath = vidPath;
        this.imgPath = imgPath;
        this.eLyrics = eLyrics;
        this.mLyrics = mLyrics;
        this.desc = desc;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getVidPath() {
        return vidPath;
    }

    public void setVidPath(int vidPath) {
        this.vidPath = vidPath;
    }

    public int getImgPath() {
        return imgPath;
    }

    public void setImgPath(int imgPath) {
        this.imgPath = imgPath;
    }

    public int geteLyrics() {
        return eLyrics;
    }

    public void seteLyrics(int eLyrics) {
        this.eLyrics = eLyrics;
    }

    public int getmLyrics() {
        return mLyrics;
    }

    public void setmLyrics(int mLyrics) {
        this.mLyrics = mLyrics;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}



