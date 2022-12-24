package com.reserva.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.reserva.R;
import com.reserva.utils.DatabaseHandler;
import com.reserva.utils.SharedPrefManagerUsers;

public class LoginUsers extends AppCompatActivity {
    EditText tvEmail, tvPass;
    AppCompatButton tvbtLoginUsers;
    TextView tvDaftar;
    String email, pass;
    DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_users);

        SharedPrefManagerUsers sharedPrefManagerUsers;
        sharedPrefManagerUsers = new SharedPrefManagerUsers(this);
        db = new DatabaseHandler(this);
        tvEmail = findViewById(R.id.emailUser);
        tvPass = findViewById(R.id.passwordUser);
        tvbtLoginUsers = findViewById(R.id.btLoginUser);
        tvDaftar = findViewById(R.id.btDaftar);

        tvbtLoginUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = tvEmail.getText().toString().trim();
                pass = tvPass.getText().toString().trim();
                boolean res = db.checkUsers(email, pass);
                if (res) {
                    if (tvEmail.getText().toString().trim().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(tvEmail.getText().toString()).matches()){
                        Toast.makeText(LoginUsers.this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                    }else if (tvPass.getText().toString().trim().length() <= 8){
                        Toast.makeText(LoginUsers.this, "Password tidak valid", Toast.LENGTH_SHORT).show();
                    }
                    sharedPrefManagerUsers.saveSPString(SharedPrefManagerUsers.SP_EMAIL, email);
                    sharedPrefManagerUsers.saveSPBoolean(SharedPrefManagerUsers.SP_SUDAH_LOGIN, true);
                    Toast.makeText(LoginUsers.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(LoginUsers.this, MenuLocation.class);
                    startActivity(login);

                }
                else
                {
                    Toast.makeText(LoginUsers.this, "Login Gagal!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftar = new Intent(LoginUsers.this, SignUpUsers.class);
                startActivity(daftar);

            }
        });
    }


}