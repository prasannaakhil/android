package com.example.prasannakumarambati.registration;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    TextView tv11;
    TextView tv12;
    TextView tv13;
    Button b3;
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv11= (TextView) findViewById(R.id.tv11);
        tv12 = (TextView) findViewById(R.id.tv12);
        tv13 = (TextView) findViewById(R.id.tv13);
        
        Bundle bb;
        bb=getIntent().getExtras();
        tv1.setText(bb.getString("name"));
        tv2.setText(bb.getString("email"));
        tv3.setText(bb.getString("dob"));
        tv4.setText(bb.getString("phone"));
        tv5.setText(bb.getString("gender"));
        tv6.setText(bb.getString("mobile"));
        tv7.setText(bb.getString("pan"));
        tv8.setText(bb.getString("license"));
        tv9.setText(bb.getString("school"));
        tv10.setText(bb.getString("inter"));
        tv11.setText(bb.getString("eng"));
        tv12.setText(bb.getString("about"));
        tv13.setText(bb.getString("acc"));




        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });






        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert =new AlertDialog.Builder(Main2Activity.this);
                alert.setTitle("do you want to close this application");
                alert.setMessage("yes-to-exit \nno-to-terminate");
                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();
                        moveTaskToBack(true);
                        Toast.makeText(getApplicationContext(),"application closed",Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"exit process terminated",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog=alert.create();
                alertDialog.show();

            }
        });

    }
}