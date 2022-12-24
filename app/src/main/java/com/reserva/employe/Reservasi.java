package com.reserva.employe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reserva.R;
import com.reserva.employe.adapter.AdapterReservasi;
import com.reserva.employe.model.ReservasiModel;
import com.reserva.utils.DatabaseHandler;

import java.util.Collections;
import java.util.List;

public class Reservasi extends AppCompatActivity {

    List<ReservasiModel> listreser;
    RecyclerView recyclerView;
    DatabaseHandler db;
    AdapterReservasi myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasi);
        recyclerView = findViewById(R.id.rcReservasi);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        db = new DatabaseHandler(this);
        listreser = db.getListReservasi();
        myAdapter = new AdapterReservasi(this, listreser);
        recyclerView.setAdapter(myAdapter);
    }
}