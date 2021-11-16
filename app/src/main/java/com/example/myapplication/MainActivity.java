package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView content;
    private Button creator;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.list_layout);
        TextView content = findViewById(R.id.content_list);
        Button creator = findViewById(R.id.creator);

        content.setText("qqqqqqqqqq");
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
                TextView newTextView = new TextView(MainActivity.this);

                linearLayout.addView(newTextView);
                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                intent.putExtra("titleName",newTextView.getText().toString());


                startActivityForResult(intent,1);


            }

        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.list_layout);
        TextView content = findViewById(R.id.content_list);
        Button creator = findViewById(R.id.creator);

        if(resultCode == 1){
                String title = data.getStringExtra("Title");
                content.setText(title);
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
                TextView newTextView = new TextView(MainActivity.this);

                linearLayout.addView(newTextView);
                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                intent.putExtra("titleName",newTextView.getText().toString());


                startActivityForResult(intent,1);


            }

        });

    }

}
