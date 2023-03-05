package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,email,pass;
    Spinner spnr;
    Button tombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.txt_name);
        email = findViewById(R.id.txt_email);
        pass = findViewById(R.id.txt_pass);
        spnr = findViewById(R.id.spn_jk);
        tombol = findViewById(R.id.btn_result);
        tombol.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if( v == tombol){
            String nama = name.getText().toString();
            String imel = email.getText().toString();
            String passw = pass.getText().toString();
            String spinr = spnr.getSelectedItem().toString();
            String result = "nama: " + nama + "\n" + "Email: " + imel + "\n"+ "Password: " + passw + "\n" +"Kelamin: " + spinr;
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }
}