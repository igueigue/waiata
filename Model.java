package com.example.waiata;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    private int image;
    private int title;
    private int desc;

    public Model() {
    }

    public Model(int image, int title, int desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    protected Model(Parcel in) {
        image = in.readInt();
        title = in.readInt();
        desc = in.readInt();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeInt(title);
        dest.writeInt(desc);
    }
}
