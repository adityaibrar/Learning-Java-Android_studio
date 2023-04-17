package com.example.pertemuan1.activities_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pertemuan1.R;
import com.example.pertemuan1.helper.DatabaseHelper;
import com.example.pertemuan1.model.Person;

public class AddActivity extends AppCompatActivity {

    private EditText editTextNama, editTextAlamat, editTextTelepon;
    private Button buttonTambah;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextNama = findViewById(R.id.editTextNama);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        editTextTelepon = findViewById(R.id.editTextTelepon);
        buttonTambah = findViewById(R.id.buttonTambah);

        databaseHelper = new DatabaseHelper(this);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = editTextNama.getText().toString();
                String alamat = editTextAlamat.getText().toString();
                String telepon = editTextTelepon.getText().toString();

                Person orang = new Person(0, nama, alamat, telepon);

                boolean success = databaseHelper.addPerson(orang);

                if (success) {
                    Toast.makeText(AddActivity.this, "Orang berhasil ditambahkan", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(AddActivity.this, "Gagal menambahkan orang", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}