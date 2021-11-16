package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotepadActivity extends AppCompatActivity {
    private String title;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        Button button = findViewById(R.id.Back_button) ;

        getSupportActionBar().setTitle("Notepad");
        Intent intent = getIntent();
        String contentString = intent.getStringExtra("titleName");



        EditText editText = findViewById(R.id.content);

        title = "";


        String currentContext = contentString;


        editText.setText(contentString);
        title = contentString;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = editText.getText().toString();

                if(title.isEmpty() == true){
                    title = "";
                }
                else {

                    if (title.length() > 6) {

                        title = title.substring(0, 6) + "......";

                    }
                }
                Intent backIntent = new Intent();
                backIntent.putExtra("Title",title);
                setResult(1,backIntent);
                finish();

            }
        });
        //Intent backIntent = new Intent(this,MainActivity.class);
        //backIntent.putExtra("Title",title);
        //backIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivityIfNeeded(backIntent,0);







    }



}
