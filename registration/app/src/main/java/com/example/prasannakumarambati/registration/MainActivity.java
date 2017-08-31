package com.example.prasannakumarambati.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;
    EditText ed7;
    EditText ed8;
    EditText ed9;
    EditText ed10;
    EditText ed11;
    Button b1;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);
        ed3= (EditText) findViewById(R.id.ed3);
        ed4= (EditText) findViewById(R.id.ed4);
        ed5= (EditText) findViewById(R.id.ed5);
        ed6= (EditText) findViewById(R.id.ed6);
        ed7= (EditText) findViewById(R.id.ed7);
        ed8= (EditText) findViewById(R.id.ed8);
        ed9= (EditText) findViewById(R.id.ed9);
        ed10= (EditText) findViewById(R.id.ed10);
        ed11= (EditText) findViewById(R.id.ed11);



        b2= (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed6.setText("");
                ed7.setText("");
                ed8.setText("");
                ed9.setText("");
                ed10.setText("");
                ed11.setText("");
            }
        });
    }
}
