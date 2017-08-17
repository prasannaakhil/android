package com.example.prasannakumarambati.mycam2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



//permission for recording audio and storing data in memory
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.provider.MediaStore.EXTRA_OUTPUT;

public class MainActivity extends AppCompatActivity {
    //instaling button imageview and videoview
    Button picb,videob;
    ImageView pic;
    VideoView video;

    //instaling uri for image and video to be display
    public static final String Image_Directory="Images";
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference of button image and video view
        picb= (Button) findViewById(R.id.picb);
        videob= (Button) findViewById(R.id.videob);
        pic= (ImageView) findViewById(R.id.pic);
        video= (VideoView) findViewById(R.id.video);

        //pic button onclick listner
        picb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //for checking dangoures permission or else it will not work
                if(!checkingpermission()){
                    //if permsission was not granted requesting permisiion
                    requestingpermission();
                }
                else{
                    //method should be creatred for this
                    captureImage();
                }
            }

            


        });

        //video button onclick lister
        videob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for checking dangoures permission or else it will not work
                if(!checkingpermission()){
                    //if permsission was not granted requesting permisiion
                    requestingpermission();
                }
                else {
                    //method should be creatred for this
                    capturevideo();
                }
            }
        });


        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


    }



    //connecting videoview intent to action
    private void capturevideo() {
        Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        uri=getOutputMediaFileUri(2);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(intent,200);
    }


    //connecting imageview to action
    private void captureImage() {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        uri=getOutputMediaFileUri(1);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        startActivityForResult(intent,100);
    }





    //override method needed to get action based on result contains both image and video
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==100){
            if(resultCode==RESULT_OK){
                previewimagehere();
            }
            else if(resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"something went wronge",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"something went wronge",Toast.LENGTH_SHORT).show();

            }
        }
        else if(requestCode==200){
            if (resultCode==RESULT_OK){
                perviewvideo();

            }else if (resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"sonethingwentwronge",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"somethingwentwronge",Toast.LENGTH_SHORT).show();
            }

        }
    }




    //method for preview video
    private void perviewvideo() {
        video.setVisibility(View.VISIBLE);
        pic.setVisibility(View.GONE);
        video.setVideoURI(uri);
        video.start();
    }



    //method for preview image
    private void previewimagehere() {
        pic.setVisibility(View.VISIBLE);
        video.setVisibility(View.GONE);
        BitmapFactory.Options option= new BitmapFactory.Options();
        option.inSampleSize=8;
        final Bitmap bitmap=BitmapFactory.decodeFile(uri.getPath(),option);
        pic.setImageBitmap(bitmap);
    }







    //this is copied code for uri process
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /*
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),Image_Directory
        );

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(Image_Directory, "Oops! Failed create "
                        + Image_Directory + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == 1) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == 2) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }




    //method for requesting permissions
    private void requestingpermission() {
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{WRITE_EXTERNAL_STORAGE,RECORD_AUDIO},1);
    }




    //method for checking premissions
    private boolean checkingpermission() {
        int result= ContextCompat.checkSelfPermission(MainActivity.this,WRITE_EXTERNAL_STORAGE);
        int result2=ContextCompat.checkSelfPermission(MainActivity.this,RECORD_AUDIO);
        
        return result== PackageManager.PERMISSION_GRANTED && result2== PackageManager.PERMISSION_GRANTED;
    }



    //for here to down it is complete copied code
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean record = grantResults[1] == PackageManager.PERMISSION_GRANTED;


                    if (locationAccepted && record ){
                        Toast.makeText(getApplicationContext(),"Permissions granted",Toast.LENGTH_SHORT).show();
                    }
                    // Snackbar.make(view, "Permission Granted, Now you can access location data and camera.", Snackbar.LENGTH_LONG).show();
                    else {
                        Toast.makeText(getApplicationContext(),"Permissions denied",Toast.LENGTH_SHORT).show();
                        // Snackbar.make(view, "Permission Denied, You cannot access location data and camera.", Snackbar.LENGTH_LONG).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,RECORD_AUDIO},
                                                            1);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
