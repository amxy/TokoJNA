package com.example.amxyfa.tokojna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {
    private DBdataSource dataSource;
    //inisialisasi arraylist
    private ArrayList<Barang> values;
    ListView ls_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_tampil);
        ls_menu = (ListView) findViewById(R.id.listBarang);
        dataSource = new DBdataSource(this);
// buka kontroller
        dataSource.open();

// ambil semua data barang
        values = dataSource.getAllBarang();

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_dropdown_item_1line , values);
        ls_menu.setAdapter(adapter);
    }


}
