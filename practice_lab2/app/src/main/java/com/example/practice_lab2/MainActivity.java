package com.example.practice_lab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtProgress;
    Button btnClick;
    ProgressBar progressBar;

    int showProgress=0;

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProgress=findViewById(R.id.txtProgress);
        btnClick=findViewById(R.id.btnClick);
        progressBar=findViewById(R.id.progressBar);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.alert);
                builder.setTitle("Alert");
                builder.setMessage("Are you sure, you want to exit?");

                builder.setPositiveButton("Accpet",(dialog, which) ->
                        finish());

                builder.setNegativeButton("Reject",(dialog, which) ->
                        dialog.cancel());

                builder.setNeutralButton("Cancel",(dialog, which) ->
                        dialog.cancel());

                builder.setCancelable(false);


                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
               while(showProgress<100){

                   showProgress+=1;

                   handler.post(new Runnable() {
                       @Override
                       public void run() {

                           progressBar.setProgress(showProgress);
                           txtProgress.setText(showProgress+"% done");

                       }
                   });

                   try{
                       Thread.sleep(40);
                   }
                   catch(InterruptedException e){
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }
}