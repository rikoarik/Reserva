package com.reserva;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.reserva.employe.HomeEmploye;
import com.reserva.users.MenuLocation;
import com.reserva.utils.SharedPrefManagerEmployee;
import com.reserva.utils.SharedPrefManagerUsers;

public class SplashActivity extends AppCompatActivity {
    private int waktu_loading=3000;

    //3000=3 detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPrefManagerUsers sharedPrefManagerUsers;
        SharedPrefManagerEmployee sharedPrefManagerEmployee;
        sharedPrefManagerUsers = new SharedPrefManagerUsers(this);
        sharedPrefManagerEmployee = new SharedPrefManagerEmployee(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPrefManagerUsers.getSPSudahLogin()){
                    startActivity(new Intent(SplashActivity.this, MenuLocation.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }else if (sharedPrefManagerEmployee.getSPSudahLogin()){
                    startActivity(new Intent(SplashActivity.this, HomeEmploye.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }else {
                    Intent main =new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(main);
                    finish();
                }


            }
        },waktu_loading);
    }
}