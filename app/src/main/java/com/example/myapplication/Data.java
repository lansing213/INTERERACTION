package com.example.myapplication;

import android.app.Application;

public class Data extends Application {
    private static String data;

    public static String getData(){
        return data;
    }

    public static void setData(String data) {
        Data.data = data;
    }
}
