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
    private Button button,mail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
         button = findViewById(R.id.Back_button) ;
         mail = findViewById(R.id.mail_button);
        getSupportActionBar().setTitle("Notepad");
        Intent intent = getIntent();
        String contentString = intent.getStringExtra("titleName");
        int listNum = intent.getIntExtra("listNum",1);
        double code = intent.getDoubleExtra("double",0.1);


        EditText editText = findViewById(R.id.content);

        title = "";


        String currentContext = contentString;


        editText.setText(contentString);
        title = contentString;


        //save and leave
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
                Bundle bundle = new Bundle();


                if(code == 2.1){
                    backIntent.putExtra("Title",title);
                    setResult(2,backIntent);
                    finish();




                }
                bundle.putString("Title",title);
                bundle.putInt("ViewNumber",listNum);


                backIntent.putExtras(bundle);

                setResult(1,backIntent);
                finish();

            }
        });
        //send mail button
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mail_intent = new Intent(NotepadActivity.this,EmailActivity.class);
                mail_intent.putExtra("mailContext",editText.getText().toString());
                startActivity(mail_intent);



            }
        });










        //Intent backIntent = new Intent(this,MainActivity.class);
        //backIntent.putExtra("Title",title);
        //backIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //startActivityIfNeeded(backIntent,0);







    }



}
