package com.example.amabti.asssignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> array=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ed=(EditText)findViewById(R.id.ed);
        Button bt=(Button)findViewById(R.id.bt);

        final ListView listv=(ListView)findViewById(R.id.listv);
        final ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
      listv.setAdapter(arrayAdapter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                array.add(ed.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                ed.setText("");
            }
        });
    }
}
