package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button creator;
    private LinearLayout linearLayout;
    private ListView listView;
    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.content_list);
        Button creator = findViewById(R.id.creator);
        arrayList = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);




        arrayList.add("qqqqqqqqqq");
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object object = adapterView.getItemAtPosition(i);
                String contextString = object.toString();

                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("titleName",contextString);
                bundle.putInt("listNum",i);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });








        creator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add("");
                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                intent.putExtra("titleName","");



                startActivityForResult(intent,1);


            }

        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setContentView(R.layout.activity_main);

        Button creator = findViewById(R.id.creator);

        if(resultCode == 1){
                String title = data.getStringExtra("Title");
                Integer integer = data.getIntExtra("ViewNumber",0);
                listView.getItemAtPosition(integer);



        }
        else{
            content.setText("Something wrong");

        }
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String contentString = content.getText().toString();

                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                intent.putExtra("titleName",contentString);
                startActivityForResult(intent,1);

            }
        });
        creator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add("");
                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                intent.putExtra("titleName","");


                startActivityForResult(intent,1);


            }

        });

    }

}
