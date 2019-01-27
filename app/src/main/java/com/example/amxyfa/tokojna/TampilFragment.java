package com.example.amxyfa.tokojna;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TampilFragment extends Fragment {
    private DBdataSource dataSource;
    //inisialisasi arraylist
    private ArrayList<Barang> values;
    ListView ls_menu;

    View v;


    public TampilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tampil, container, false);
        ls_menu = v.findViewById(R.id.listBarang);
        dataSource = new DBdataSource(getContext());

        // buka kontroller
        dataSource.open();

// ambil semua data barang
        values = dataSource.getAllBarang();

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_dropdown_item_1line , values);
        ls_menu.setAdapter(adapter);

        return v;
    }

}
