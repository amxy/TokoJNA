package com.example.amxyfa.tokojna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateBarang extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSubmit;
    private EditText edNama;
    private EditText edStok;
    private EditText edHarga;
    //inisialisasi kontroller/Data Source
    private DBdataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_home);
        buttonSubmit =  findViewById(R.id.btnSimpan);
        buttonSubmit.setOnClickListener(this);
        edNama =  findViewById(R.id.edtNama);
        edHarga =  findViewById(R.id.edtHarga);
        edStok =  findViewById(R.id.edtStok);

// instanstiasi kelas DBDataSource
        dataSource = new DBdataSource(this);

//membuat sambungan baru ke database
        dataSource.open();
        dataSource.updateBarang();

    }

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
                Toast.makeText(this, "Masuk Barang\n" +
                        "nama: " + barang.getNama_barang() +
                        ", harga: " + barang.getHarga_barang() +
                        ", stok: " + barang.getStok_barang(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }



    }

