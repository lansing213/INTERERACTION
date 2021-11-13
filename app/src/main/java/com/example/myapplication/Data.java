package com.example.myapplication;

public class Data{
    private static String data;

    public String getData(){
        return data;
    }

    public static void setData(String data) {
        Data.data = data;
    }
}
