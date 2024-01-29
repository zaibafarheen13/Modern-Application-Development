package com.example.practice_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ImageButton imgBtn;
    Switch mySwitch;
    ConstraintLayout clayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn=findViewById(R.id.imgBtn);
        mySwitch=findViewById(R.id.switch1);
        clayout=findViewById(R.id.clayout);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    imgBtn.setEnabled(true);
                    mySwitch.setText("Enabled");
                }
                else{
                    imgBtn.setEnabled(false);
                    mySwitch.setText("Disabled");
                }
            }
        });

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Button is clicked",Toast.LENGTH_LONG).show();
                //Snackbar.make(v,"Button is clicked",Snackbar.LENGTH_LONG).show();

            }
        });

        CalendarView cv=new CalendarView(getApplicationContext());
        ConstraintLayout.LayoutParams params=new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        clayout.addView(cv,params);
    }
}