package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pertemuan1.helper.SessionManager;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private Button buttonlogin, buttonregister;
    private EditText txtUsr, txtPass;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.isLoggedIn() == true) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_login);
            txtUsr = findViewById(R.id.txt_user);
            txtPass = findViewById(R.id.txt_passlg);
            buttonregister = findViewById(R.id.btn_register);
            buttonregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                }
            });
            buttonlogin = findViewById(R.id.btn_login);
            buttonlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = txtUsr.getText().toString();
                    String pass = txtPass.getText().toString();

                    if (email.trim().isEmpty() || pass.trim().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    } else {
                        HashMap<String, String> userDetails = sessionManager.getUserDetails();
                        String storedEmail = userDetails.get(SessionManager.KEY_EMAIL);
                        String storedPassword = userDetails.get(SessionManager.KEY_PASSWORD);
                        if (email.equals(storedEmail) && pass.equals(storedPassword)) {
                            sessionManager.createLoginSession(email, pass);
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Email atau Password salah!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }
}