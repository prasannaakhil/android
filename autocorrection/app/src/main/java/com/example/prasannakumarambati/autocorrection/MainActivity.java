package com.example.prasannakumarambati.autocorrection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final  String[] countries={"select your country","India","Sri lanka","USA","UK","Africa","Afghanistan","Hungary","Russia","Indonesia","Iraq","Netherlands","Portugal","Philippines","Malawi","New Zealand","Malaysia","Maldives","Mali","Chad","Chile","China"};



        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);

        autoCompleteTextView.setAdapter(arrayAdapter);


    }
}
