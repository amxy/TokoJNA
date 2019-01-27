package com.example.amxyfa.tokojna;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button buttonSubmit;
    private EditText edNama;
    private EditText edStok;
    private EditText edHarga;

    View v;
    private DBdataSource dataSource;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_home, container, false);
        buttonSubmit =  v.findViewById(R.id.btnSimpan);
        buttonSubmit.setOnClickListener(this);
        edNama =  v.findViewById(R.id.edtNama);
        edHarga =  v.findViewById(R.id.edtHarga);
        edStok =  v.findViewById(R.id.edtStok);

        dataSource = new DBdataSource(getContext());

//membuat sambungan baru ke database
        dataSource.open();
       // dataSource.updateBarang();
        return v;
    }

    @Override
    public void onClick(View v) {
        // Inisialisasi data barang
        String nama = null;
        Integer stok = null;
        String harga = null;
        @SuppressWarnings("unused")

//inisialisasi barang baru (masih kosong)
                Barang barang ;
        if(edNama.getText()!=null &&edStok.getText()!=null &&edHarga.getText()!=null)
        {
            /* jika field nama, merk, dan harga tidak kosong
             * maka masukkan ke dalam data barang*/
            nama = edNama.getText().toString();
            stok = Integer.valueOf(edStok.getText().toString());
            harga = edHarga.getText().toString();
        }

        switch(v.getId())
        {
            case R.id.btnSimpan:
// insert data barang baru
                barang = dataSource.createBarang(nama, harga, stok);

//konfirmasi kesuksesan
                Toast.makeText(getActivity(), "Masuk Barang\n" +
                        "nama: " + barang.getNama_barang() +
                        ", harga: " + barang.getHarga_barang() +
                        ", stok: " + barang.getStok_barang(), Toast.LENGTH_LONG).show();
                //Intent intent = new Intent();
                //setResult("Data Sudah masuk", intent);
                //finish();
                break;
        }
    }
}
