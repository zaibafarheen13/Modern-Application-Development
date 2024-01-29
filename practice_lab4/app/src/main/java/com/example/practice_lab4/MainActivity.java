package com.example.practice_lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSwitch;

    FragmentOne fragmentOne=new FragmentOne();
    FragmentTwo fragmentTwo=new FragmentTwo();

    int showFragments=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSwitch=findViewById(R.id.click);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.clayout,fragmentOne);
        showFragments=1;
        fragmentTransaction.commit();
    }

    public void switchFragment(View view){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(showFragments==1){
            fragmentTransaction.replace(R.id.clayout,fragmentTwo);
            showFragments=2;
        }
        else{
            fragmentTransaction.replace(R.id.clayout,fragmentOne);
            showFragments=1;
        }
        fragmentTransaction.commit();

    }
}