package com.example.pertemuan1.activities_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pertemuan1.R;
import com.example.pertemuan1.model.Person;

public class ViewActivity extends AppCompatActivity {

    private TextView tvNama, tvAlamat, tvTelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTelepon = findViewById(R.id.tv_telepon);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        String nama = intent.getStringExtra("NAMA");
        String alamat = intent.getStringExtra("ALAMAT");
        String telepon = intent.getStringExtra("TELEPON");

        Person person = new Person(id, nama, alamat, telepon);

        tvNama.setText("Nama: " + person.getNama());
        tvAlamat.setText("Alamat: " + person.getAlamat());
        tvTelepon.setText("Telepon: " + person.getTelepon());

    }
}