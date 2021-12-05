package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ShowListAdapter extends ArrayAdapter<ShowList>{
    List<ShowList> arrayList;
     Context context;
     int resource;
    public ShowListAdapter(Context context, int resource,      List<ShowList>
            arrayList){
        super(context, resource,arrayList);
        this.context = context;
        this.resource = resource;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view   = convertView;

            LayoutInflater layoutInflater = LayoutInflater.from(context);
             view = layoutInflater.inflate(resource,null,false);


        TextView list_item_view = view.findViewById(R.id.list_item_text);
        Button list_item_button = view.findViewById(R.id.list_item_button);

        ShowList showList = arrayList.get(position);


        list_item_view.setText(showList.getTitle());

        list_item_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(position);
                notifyDataSetChanged();

            }
        });


        return view;
        //return super.getView(position, convertView, parent);
    }
}
