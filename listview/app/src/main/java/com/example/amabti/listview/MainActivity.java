package com.example.amabti.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining listview
        ListView listview=(ListView)findViewById(R.id.list);
        //arraylist declartion
        final ArrayList<String>arrayList = new ArrayList<String>();
        //adding items to arraylist
        arrayList.add("java");
        arrayList.add("c+");
        arrayList.add("swift");
        arrayList.add("python");
        //adapter is use to connect arrraylist items to the list
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(arrayAdapter);
        //this is create to get toast when ever the items in list was clicked
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
