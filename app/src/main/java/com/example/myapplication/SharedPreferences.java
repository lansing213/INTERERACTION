package com.example.myapplication;

import android.content.Context;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
//initialize shardPreferences to store real time data;

public class SharedPreferences {
    private static final String keyString = "key";
    public static void writeListViewInPref(Context context, List<ShowList> showlist){
        Gson gson = new Gson();

        String string = gson.toJson(showlist);

        android.content.SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(keyString,string);
        editor.apply();

    }
    public static List<ShowList> readListViewFromPref(Context context){
        android.content.SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String json = sharedPreferences.getString(keyString,"");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ShowList>>(){}.getType();

        List<ShowList> l = gson.fromJson(json,type);
        return l;



    }

}
//https://www.youtube.com/watch?v=TsASX0ZK9ak