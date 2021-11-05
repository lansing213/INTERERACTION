package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotepadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        getSupportActionBar().setTitle("Notepad");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        EditText editText = findViewById(R.id.content);
        String currentContext = editText.getText().toString();
        String title;
        if(currentContext.matches("")){
            currentContext = "                         ";
            title = "";
        }
        else{
            title = currentContext;
            if(title.length() > 6){
                title = currentContext.substring(0,6) + "......";
            }
            else if(title.length() == 6){
                title = currentContext.substring(0,6);}
            else{
                title = currentContext;
            }
        }

        //Intent intent = new Intent();
        //intent.putExtra("Title",title);
        //setResult(RESULT_OK,intent);
        //finish();

    }
}
