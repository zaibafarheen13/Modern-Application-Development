package com.example.practice_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtReciever=findViewById(R.id.textReciever);

        Intent intent=getIntent();
        String myRecieverString=intent.getStringExtra("message");
        txtReciever.setText(myRecieverString);
    }
}