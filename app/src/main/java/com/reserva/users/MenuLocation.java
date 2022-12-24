package com.reserva.users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.reserva.MainActivity;
import com.reserva.R;
import com.reserva.utils.SharedPrefManagerUsers;

public class MenuLocation extends AppCompatActivity {

    AppCompatButton btserpong, btbsd, btalamsutera, bthistory, btmaps;
    TextView tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_location);
        btserpong = findViewById(R.id.serpong);
        btbsd = findViewById(R.id.bsd);
        btalamsutera = findViewById(R.id.alamsutera);
        tvLogout = findViewById(R.id.btlogout);
        bthistory = findViewById(R.id.history);
        btmaps = findViewById(R.id.maps);

        SharedPrefManagerUsers sharedPrefManagerUsers;
        sharedPrefManagerUsers = new SharedPrefManagerUsers(this);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPrefManagerUsers.saveSPBoolean(SharedPrefManagerUsers.SP_SUDAH_LOGIN, false);
                Intent i = new Intent(MenuLocation.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btserpong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent serpong = new Intent(MenuLocation.this, Treatment.class);
                startActivity(serpong);
            }
        });
        btbsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent bsd = new Intent(MenuLocation.this, Treatment.class);
                startActivity(bsd);
            }
        });
        btalamsutera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alamsutera = new Intent(MenuLocation.this, Treatment.class);
                startActivity(alamsutera);
            }
        });
        bthistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(MenuLocation.this, History.class);
                startActivity(history);
            }
        });
        btmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maps = new Intent(MenuLocation.this, Maps.class);
                startActivity(maps);
            }
        });
    }
}