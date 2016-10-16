package com.palle.annu.palletodogrocery;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddedItemInListViewFragment extends Fragment {
ListView lv;
    MyDatabase myDatabase;

    public AddedItemInListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_added_item_in_list_view, container, false);
        lv = (ListView)v.findViewById(R.id.list_view_item);

        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();

        Cursor c = myDatabase.getItem();
        SimpleCursorAdapter s = new SimpleCursorAdapter(getActivity(),R.layout.row,c,new String[]{"_id","item","quantity"},new int[] {R.id.text_id,R.id.text_item,R.id.text_quantity});
        lv.setAdapter(s);


        return  v;
    }

}
