package com.example.amabti.email;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {
     EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1=(EditText)findViewById(R.id.ed1);
                ed2=(EditText)findViewById(R.id.ed2);
                ed3=(EditText)findViewById(R.id.ed3);
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ed1.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, ed2.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,ed3.getText().toString() );
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"send email via"));

            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
            }
        });


        b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed4=(EditText)findViewById(R.id.ed4);

                String callnumber= "tel:9059859589";
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE);
                if (permissionCheck== PackageManager.PERMISSION_GRANTED){
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(callnumber)));
                }
            }
        });


        b4=(Button)findViewById(R.id.b4);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ed5=(EditText)findViewById(R.id.ed5);
                //Intent sintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:9059859589"));
                //sintent.putExtra("sms_body",ed5.getText().toString());
                //startActivity(sintent);
                if (!checkingPermission()){
                    requestingPermissions();

                }
                else{

                }
            }
        });

    }

    private void requestingPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{CALL_PHONE},90);
    }

    private boolean checkingPermission() {
        int result=ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);
        return result==PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
