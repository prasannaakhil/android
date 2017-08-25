package com.example.prasannakumarambati.timepickeranddatepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timePicker= (TimePicker) findViewById(R.id.timePicker);

        b1= (Button) findViewById(R.id.b1);
         b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hours=timePicker.getHour()+"";
                String mins=timePicker.getMinute()+"";
                Toast.makeText(getApplicationContext(), "Time :"+hours+":"+mins, Toast.LENGTH_SHORT).show();
            }
        });

        b2= (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,datepicker.class);
                startActivity(intent);
            }
        });
    }
}
