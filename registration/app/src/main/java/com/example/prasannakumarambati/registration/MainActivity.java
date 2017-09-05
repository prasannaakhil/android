package com.example.prasannakumarambati.registration;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    EditText ed12;
    Button b1;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.ed1);
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
        ed12= (EditText) findViewById(R.id.ed12);



        b1= (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("submit details");
                alert.setMessage("press ok to submit \ncancel to terminate");
                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Toast.makeText(getApplicationContext(),"registration was successfull",Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                        intent.putExtra ( "name", ed1.getText().toString() );
                        intent.putExtra ( "email", ed2.getText().toString() );
                        intent.putExtra ( "dob", ed3.getText().toString() );
                        intent.putExtra ( "phone", ed4.getText().toString() );

                        intent.putExtra ( "mobile", ed5.getText().toString() );
                        intent.putExtra ( "pan", ed6.getText().toString() );
                        intent.putExtra ( "license", ed7.getText().toString() );
                        intent.putExtra ( "school", ed8.getText().toString() );
                        intent.putExtra ( "inter", ed9.getText().toString() );
                        intent.putExtra ( "eng", ed10.getText().toString() );
                        intent.putExtra ( "about", ed11.getText().toString() );
                        intent.putExtra ( "acc", ed12.getText().toString() );

                        startActivity(intent);


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
                        ed12.setText("");



                    }

                });
                alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
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
                        ed12.setText("");
                        Toast.makeText(getApplicationContext(),"registration failed",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog=alert.create();
                alertDialog.show();
            }
        });


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
                ed12.setText("");
                     Toast.makeText(getApplicationContext(),"details cleared",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
