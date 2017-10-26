package com.example.prasannakumarambati.timepickeranddatepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class datepicker extends AppCompatActivity {


    Button b3;
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        final DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
        b3= (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date=datePicker.getDayOfMonth()+"";
                String month=(datePicker.getMonth()+1)+"";
                String year=datePicker.getYear()+"";
                Toast.makeText(getApplicationContext(),"Selected Date: "+date +"/"+month+"/"+year,Toast.LENGTH_LONG).
                        show();
            }
        });

        Intent intent=getIntent();
        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
