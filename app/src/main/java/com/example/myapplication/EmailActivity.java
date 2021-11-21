package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity {
    EditText receiver;
    EditText context,title;
    Button sendButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        receiver = findViewById(R.id.receiver);
        context = findViewById(R.id.mail_text);
        title = findViewById(R.id.mail_title);
        sendButton = findViewById(R.id.send_button);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_TEXT,context.getText().toString());
                email.putExtra(Intent.EXTRA_SUBJECT,title.getText().toString());
                
            }
        });


    }
}
