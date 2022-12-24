package com.reserva.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.reserva.R;
import com.reserva.employe.adapter.AdapterReservasi;
import com.reserva.employe.model.ReservasiModel;
import com.reserva.users.adapter.HistoryAdapter;
import com.reserva.users.model.HistoryModel;
import com.reserva.utils.DatabaseHandler;

import java.util.List;

public class History extends AppCompatActivity {

    List<HistoryModel> list;
    RecyclerView recyclerView;
    DatabaseHandler db;
    HistoryAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = findViewById(R.id.rcHistory);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        db = new DatabaseHandler(this);
        list = db.getListHistory();
        myAdapter = new HistoryAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

    }
}