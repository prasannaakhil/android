package com.example.prasannakumarambati.edittexttextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView t1;
    Button b1;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= (TextView) findViewById(R.id.t1);
        b1= (Button) findViewById(R.id.b1);
        e1= (EditText) findViewById(R.id.e1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(e1.getText().toString());
            }
        });
    }
}
