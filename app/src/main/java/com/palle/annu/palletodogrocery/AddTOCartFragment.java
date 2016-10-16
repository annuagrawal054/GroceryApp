package com.palle.annu.palletodogrocery;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTOCartFragment extends Fragment {
MyDatabase mydatabase;
    Button b_add_to_cart;
    EditText et_item_added,et_item_quantity;
    Spinner sp;
    String[] quantity_unit ={"kg","gram","ml","litre"};
    ArrayAdapter mArrayAdapter;
    public AddTOCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_first_screen, container, false);
        b_add_to_cart = (Button)v.findViewById(R.id.b_Add_item);
        et_item_added = (EditText)v.findViewById(R.id.et_items);
        et_item_quantity = (EditText)v.findViewById(R.id.et_items_quantity);
        sp = (Spinner)v.findViewById(R.id.sp_quantity);
        mArrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,quantity_unit);
        sp.setAdapter(mArrayAdapter);

        mydatabase = new MyDatabase(getActivity());
        mydatabase.open();

        Cursor c = mydatabase.getItem();
        while(c.moveToNext()==true)
        {
            int item_id = c.getInt(0);
            String item_name = c.getString(1);
            Integer item_quantity = c.getInt(2);

        }
        b_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item_add = et_item_added.getText().toString();
                Integer item_quantity = Integer.parseInt(et_item_quantity.getText().toString());
               mydatabase.InsertItem(item_add,item_quantity);

                AddedItemInListViewFragment fragment2 = new AddedItemInListViewFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

               /* et_item_added.setText(" ");
                et_item_quantity.setText(" ");*/
            }
        });

        return v;
    }

}
