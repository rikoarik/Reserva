package com.reserva.users;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.reserva.R;
import com.reserva.users.model.HistoryModel;
import com.reserva.utils.DatabaseHandler;
import com.reserva.utils.FunctionHelper;
import com.reserva.utils.SharedPrefManagerUsers;

import java.util.ArrayList;
import java.util.Arrays;

public class BON extends AppCompatActivity {
    TextView tvtotal;
    ListView listProduk, listHarga;
    AppCompatButton tvSave;
    SharedPrefManagerUsers sharedPrefManagerUsers;
    DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon);
        listProduk = findViewById(R.id.listviewProduk);
        listHarga = findViewById(R.id.listviewHarga);
        tvtotal = findViewById(R.id.total);
        tvSave = findViewById(R.id.save);
        tvtotal.setText("0");
        sharedPrefManagerUsers = new SharedPrefManagerUsers(this);
        db = new DatabaseHandler(this);

        Intent intent = getIntent();
        String total = intent.getExtras().getString("total");
        String datetime = intent.getExtras().getString("date");
        ArrayList<String> produk = intent.getStringArrayListExtra("Listproduk");
        ArrayList<String> harga = intent.getStringArrayListExtra("Listjumlah");

        String[] Produk = produk.toArray(new String[produk.size()]);
        String[] Harga = harga.toArray(new String[harga.size()]);

        ArrayAdapter<String> adapterProduk = new ArrayAdapter<String>(
                this, R.layout.items_pay, Produk
        );
        ArrayAdapter<String> adapterHarga = new ArrayAdapter<String>(
                this, R.layout.items_pay, Harga
        );

        // set data
        listProduk.setAdapter(adapterProduk);
        listHarga.setAdapter(adapterHarga);
        tvtotal.setText(FunctionHelper.rupiahFormat(Integer.parseInt(total)));

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ss", Arrays.toString(Produk));
                Log.d("ss", sharedPrefManagerUsers.getSPEmail());
                HistoryModel trs = new HistoryModel();
                trs.setEmailusers(sharedPrefManagerUsers.getSPEmail().trim());
                trs.setProduk(Arrays.toString(Produk).trim());
                trs.setDateTime(datetime.trim());
                trs.setTotal(tvtotal.getText().toString().trim());
                db.addTransaksi(trs);
                ProgressDialog progressDialog = new ProgressDialog(BON.this);
                progressDialog.setMessage("Pembayaran Selesai");

                Intent i = new Intent(BON.this, MenuLocation.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(BON.this, Treatment.class);
        startActivity(i);
        finish();
    }
}