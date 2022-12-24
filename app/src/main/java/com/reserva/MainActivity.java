package com.reserva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.reserva.employe.LoginEmployee;
import com.reserva.users.LoginUsers;

public class MainActivity extends AppCompatActivity {
    AppCompatButton userLogin, employeeLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLogin = findViewById(R.id.loginUser);
        employeeLogin = findViewById(R.id.loginEmployee);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent user = new Intent(MainActivity.this, LoginUsers.class);
                startActivity(user);

            }
        });
        employeeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent employee = new Intent(MainActivity.this, LoginEmployee.class);
                startActivity(employee);

            }
        });
    }

}