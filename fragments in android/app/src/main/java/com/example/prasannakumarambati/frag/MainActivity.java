package com.example.prasannakumarambati.frag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements frag1.communicator{
frag2 frag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            frag2=(frag2)getSupportFragmentManager().findFragmentById(R.id.fragment3);


        }


    @Override
    public void respond(String str) {
        if (frag2!=null && frag2.isVisible()) {
            frag2.changeData(str);

        }



        else {

            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            intent.putExtra("name",str);
            startActivity(intent);

        }


    }
}
