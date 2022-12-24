package com.reserva.employe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.reserva.R;

public class ReservasiDetail extends AppCompatActivity {
    TextView tvname,tvtgl, tvservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasi_detail);
        tvname = findViewById(R.id.namers);
        tvtgl = findViewById(R.id.tanggalrs);
        tvservice = findViewById(R.id.servicers);

        String nama = getIntent().getStringExtra("nama");
        String tgl = getIntent().getStringExtra("tanggal");
        String servis = getIntent().getStringExtra("service");
        tvname.setText(nama);
        tvtgl.setText(tgl);
        tvservice.setText(servis);



    }
}