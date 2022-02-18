package com.abhay.fitnessapp;

import android.widget.ImageView;

public class Model_Class {

    int image;
    String text1;
    String text2;

    Model_Class(int image, String text1, String text2){
        this.image=image;
        this.text1=text1;
        this.text2=text2;

    }

    public int getImage() {
        return image;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
