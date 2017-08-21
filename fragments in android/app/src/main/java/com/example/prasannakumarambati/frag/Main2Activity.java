package com.example.prasannakumarambati.frag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent=getIntent();
        String str=intent.getStringExtra("name");

        frag2 frag2=(frag2)getSupportFragmentManager().findFragmentById(R.id.fragment3);
        frag2.changeData(str);

    }
}