package com.reserva.employe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.reserva.MainActivity;
import com.reserva.R;

import com.reserva.utils.SharedPrefManagerEmployee;

public class HomeEmploye extends AppCompatActivity {
    TextView btLogout;
    AppCompatButton tvstok, tvreservasi, tvsalein, tvsaleout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_employe);
        tvstok = findViewById(R.id.menuStok);
        tvreservasi = findViewById(R.id.menuReservasi);
        tvsalein = findViewById(R.id.menuSaleIn);
        tvsaleout = findViewById(R.id.menuSaleOut);
        btLogout = findViewById(R.id.logout);

        SharedPrefManagerEmployee sharedPrefManagerEmployee;
        sharedPrefManagerEmployee = new SharedPrefManagerEmployee(this);
        
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefManagerEmployee.saveSPBoolean(SharedPrefManagerEmployee.SP_LOGIN, false);
                Intent i = new Intent(HomeEmploye.this, MainActivity.class);
                startActivity(i);
                finish();
                
            }
        });
        

        tvstok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stok= new Intent(HomeEmploye.this, StokBarang.class);
                startActivity(stok);
            }
        });

        tvreservasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reservasi= new Intent(HomeEmploye.this, Reservasi.class);
                startActivity(reservasi);
            }
        });

        tvsalein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salin= new Intent(HomeEmploye.this, SaleIn.class);
                startActivity(salin);
            }
        });

        tvsaleout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saleout= new Intent(HomeEmploye.this, SaleOut.class);
                startActivity(saleout);
            }
        });






    }
}