package com.example.prasannakumarambati.alertdialoug;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertdialog =new AlertDialog.Builder(MainActivity.this);
                alertdialog.setTitle("hello");
                alertdialog.setMessage("world");
                alertdialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"accepted the warning",Toast.LENGTH_SHORT).show();
                    }
                });

                alertdialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"denied the waring",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = alertdialog.create();
                alertDialog.show();



            }
        });

    }

}
