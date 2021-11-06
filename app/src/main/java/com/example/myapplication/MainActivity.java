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
    private TextView content;
    private Button creator;
    private LinearLayout linearLayout;
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
                newTextView.setText("yyy");
                linearLayout.addView(newTextView);
                Intent intent = new Intent(MainActivity.this,NotepadActivity.class);


                startActivityForResult(intent,1);


            }

        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            if(resultCode == RESULT_OK){
                String title = data.getStringExtra("Title");

                content.setText(title);

            }
            else{
                content.setText("     ");

            }
        }
    }
}
