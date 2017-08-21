package com.example.prasannakumarambati.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class frag2 extends Fragment {
    TextView textview;

    public  frag2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_frag2,container,false);

        textview=(TextView) view.findViewById(R.id.textview);

        return view;
    }






    public void changeData(String str) {
        textview.setText(str);
    }


}
