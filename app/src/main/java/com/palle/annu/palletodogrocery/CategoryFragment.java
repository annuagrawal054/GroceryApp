package com.palle.annu.palletodogrocery;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    String[] countries = new String[] {
            "Apple",
            "Banana",
            "Mango",
            "Orange",
            "Papaya",
            "Sapota",
            "Carrot",
            "Kiwi",
            "Avagado"
    };

    int[] flags = new int[]{
            R.drawable.biodata,
            R.drawable.growthmonitor,
            R.drawable.immunisationtracker,
            R.drawable.ort,
            R.drawable.feeding,
            R.drawable.momcom,
            R.drawable.food_supps,
            R.drawable.fampl,
            R.drawable.fem
    };


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_category, container, false);


        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<9;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt" +
                    "", "" + countries[i]);

            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), aList, R.layout.listview_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView )v.findViewById(R.id.list_view);
        ;

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:Intent in = new Intent(getActivity(),MainActivity.class);
                        startActivity(in);

                        break;

                    default:
                        break;
                }
                // Toast.makeText(context,temparr.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        return  v;
    }

}
