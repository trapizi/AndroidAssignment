package com.example.steven.spaghetti.Model;

import android.media.Image;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Steven on 12-Oct-17.
 */

public class Quiz {

    private String Name;
    private String Image;

    public Quiz(){

    }

    public Quiz(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
