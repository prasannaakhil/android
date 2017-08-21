package com.example.prasannakumarambati.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class frag1 extends Fragment {



ListView list;

    public  frag1(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_frag1,container,false);

        final String[] names={"sai","Prasanna","ambati","Prasanna","ambati","Prasanna","ambati","Prasanna","ambati"};

        list=(ListView) view.findViewById(R.id.list);

        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,names);

        list.setAdapter(stringArrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                communicator communicator;
                communicator=(communicator) getActivity();

                communicator.respond(names[position]);



            }
        });


        return view;
    }

    public interface communicator{
        public void respond(String str);
    }



}
