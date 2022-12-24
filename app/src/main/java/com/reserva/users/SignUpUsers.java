package com.reserva.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.reserva.R;
import com.reserva.users.model.UsersModel;
import com.reserva.utils.DatabaseHandler;

public class SignUpUsers extends AppCompatActivity {
    EditText tvName, tvNotlp, tvEmail, tvPass, tvPassConfirm;
    AppCompatButton tvSignUp;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_users);
        db = new DatabaseHandler(this);

        tvName = findViewById(R.id.nameUsers);
        tvNotlp = findViewById(R.id.notlpUsers);
        tvEmail = findViewById(R.id.emailUsers);
        tvPass = findViewById(R.id.passwordUsers);
        tvPassConfirm = findViewById(R.id.confirmpasswordUser);
        tvSignUp = findViewById(R.id.btSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvName.getText().toString().trim().length() == 0){
                    Toast.makeText(SignUpUsers.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else if (tvNotlp.getText().toString().trim().length() !=12){
                    Toast.makeText(SignUpUsers.this, "No tlp tidak valid", Toast.LENGTH_SHORT).show();
                }else if (tvEmail.getText().toString().trim().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(tvEmail.getText().toString()).matches()){
                    Toast.makeText(SignUpUsers.this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                }else if (tvPass.getText().toString().trim().length() < 8){
                    Toast.makeText(SignUpUsers.this, "Password tidak valid", Toast.LENGTH_SHORT).show();
                }else if (tvPassConfirm.getText().toString().trim().length() < 8){
                    Toast.makeText(SignUpUsers.this, "Password Confirm tidak valid", Toast.LENGTH_SHORT).show();
                }else if (tvPass.getText().toString().trim().equals(tvPassConfirm.getText().toString().trim())){
                    UsersModel users = new UsersModel();

                    users.setNama(tvName.getText().toString().trim());
                    users.setNotlp(tvNotlp.getText().toString().trim());
                    users.setEmail(tvEmail.getText().toString().trim());
                    users.setPassword(tvPass.getText().toString().trim());
                    db.addUsers(users);
                    Toast.makeText(SignUpUsers.this, "Data telah terdaftar", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(SignUpUsers.this, LoginUsers.class);
                    startActivity(login);
                    finish();
                }else{
                    Toast.makeText(SignUpUsers.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}