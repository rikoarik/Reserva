package com.reserva.employe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.reserva.R;
import com.reserva.utils.SharedPrefManagerEmployee;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginEmployee extends AppCompatActivity {

    String JSON_STRING = "{\"employee\":{\"email\":\"admin@gmail.com\",\"pass\":admin}}";
    String email, pass;
    EditText tvemail, tvpassword;
    AppCompatButton tvlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);
        SharedPrefManagerEmployee sharedPrefManagerEmployee;
        sharedPrefManagerEmployee = new SharedPrefManagerEmployee(this);
        tvemail = findViewById(R.id.emailEmployee);
        tvpassword = findViewById(R.id.passwordEmployee);
        tvlogin = findViewById(R.id.btLoginEmployee);

        try {
            JSONObject obj = new JSONObject(JSON_STRING);

            JSONObject employee = obj.getJSONObject("employee");

            email = employee.getString("email");
            pass = employee.getString("pass");

            tvlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvemail.getText().toString().trim().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(tvemail.getText().toString()).matches()){
                        Toast.makeText(LoginEmployee.this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                    }else if (tvpassword.getText().toString().trim().length() <= 8){
                        Toast.makeText(LoginEmployee.this, "Password tidak valid", Toast.LENGTH_SHORT).show();
                    }else {
                        if (tvemail.getText().toString().equals(email) & tvpassword.getText().toString().equals(pass)){
                            sharedPrefManagerEmployee.saveSPString(SharedPrefManagerEmployee.SP_EMAIL_EMPLOYEE, email);
                            sharedPrefManagerEmployee.saveSPBoolean(SharedPrefManagerEmployee.SP_LOGIN, true);
                            Intent lgn = new Intent(LoginEmployee.this, HomeEmploye.class);
                            startActivity(lgn);
                            finish();
                            
                        }else if (!tvemail.getText().toString().trim().equals(email)) {
                            Toast.makeText(LoginEmployee.this, "email salah", Toast.LENGTH_SHORT).show();
                        }else if (!tvpassword.getText().toString().trim().equals(email)) {
                            Toast.makeText(LoginEmployee.this, "password salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}