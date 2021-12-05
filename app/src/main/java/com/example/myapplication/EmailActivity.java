package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        getSupportActionBar().setTitle("Mail");
        String[] cc = {"jerichojing@hotmail.com"};

        String[] to;
        Intent intent = getIntent();
        context.setText(intent.getStringExtra("mailContext"));
        String receiver_address;
        receiver_address = receiver.getText().toString();
        to = new String[]{receiver_address};
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AlertDialog alertDialog = new AlertDialog.Builder(EmailActivity.this).create();
        alertDialog.setTitle("Notification");
        alertDialog.setMessage("Your mail has been sent.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });



                sendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.setType("message/rfc822");
                        email.putExtra(Intent.EXTRA_EMAIL, to);
                        email.putExtra(Intent.EXTRA_CC, cc);
                        email.putExtra(Intent.EXTRA_TEXT, context.getText().toString());
                        email.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
                        startActivity(email);
                        alertDialog.show();
                    }
                });


    }

}
