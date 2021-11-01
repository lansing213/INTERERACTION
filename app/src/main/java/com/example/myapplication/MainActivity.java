package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView content = findViewById(R.id.content_list);
        Button creator = findViewById(R.id.creator);
        LinearLayout linearLayout = findViewById(R.id.list_layout);
        content.setText("uighiu");

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.setText("yyy");
                Intent intent = new Intent(MainActivity.this, NotepadActivity.class);
                startActivity(intent);
            }
        });
        creator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView newTextView = new TextView(MainActivity.this);
                newTextView.setText("yyy");
                linearLayout.addView(newTextView);
                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);
                startActivity(intent);

            }
        });

    }


}
