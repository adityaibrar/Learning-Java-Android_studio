package com.example.pertemuan1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pertemuan1.helper.SessionManager;

public class RegistrationActivity extends AppCompatActivity {
    private EditText name,email,pass;
    private Spinner spnr;
    private Button tombol;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        sessionManager = new SessionManager(getApplicationContext());

        name = findViewById(R.id.txt_name);
        email = findViewById(R.id.txt_email);
        pass = findViewById(R.id.txt_pass);
        spnr = findViewById(R.id.spn_jk);
        tombol = findViewById(R.id.btn_result);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
                builder.setTitle("Konfirmasi");
                String message = "Email : " + email.getText().toString() + "\n" +
                        "Nama : " + name.getText().toString() + "\n" +
                        "Password : " + pass.getText().toString() + "\n" +
                        "Jenis Kelamin : " + spnr.getSelectedItem().toString();
                builder.setMessage(message);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        sessionManager.createRegisterSession(
                                email.getText().toString(),
                                name.getText().toString(),
                                pass.getText().toString(),
                                spnr.getSelectedItem().toString());
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr.setAdapter(adapter);
    }

}