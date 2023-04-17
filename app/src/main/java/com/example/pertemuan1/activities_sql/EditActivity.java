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

public class EditActivity extends AppCompatActivity {

    private EditText editNama, editAlamat, editTelp;
    private Button btnUpdate;

    private DatabaseHelper db;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        // Inisialisasi komponen UI
        editNama = findViewById(R.id.edit_nama);
        editAlamat = findViewById(R.id.edit_alamat);
        editTelp = findViewById(R.id.edit_telepon);
        btnUpdate = findViewById(R.id.btn_update);
        // Ambil data dari intent dan inisialisasi database
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("ID");
            String nama = extras.getString("NAMA");
            String alamat = extras.getString("ALAMAT");
            String telp = extras.getString("TELEPON");

            person = new Person(id, nama, alamat, telp);
        }
        db = new DatabaseHelper(this);

        // Set nilai awal pada komponen UI
        editNama.setText(person.getNama());
        editAlamat.setText(person.getAlamat());
        editTelp.setText(person.getTelepon());

        // Tambahkan listener pada tombol Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari komponen UI
                String nama = editNama.getText().toString().trim();
                String alamat = editAlamat.getText().toString().trim();
                String telp = editTelp.getText().toString().trim();

                // Validasi input
                if (nama.isEmpty() || alamat.isEmpty() || telp.isEmpty()) {
                    Toast.makeText(EditActivity.this, "Silakan lengkapi semua data", Toast.LENGTH_LONG).show();
                } else {
                    // Update data pada database
                    person.setNama(nama);
                    person.setAlamat(alamat);
                    person.setTelepon(telp);
                    boolean success = db.updatePerson(person);

                    if (success) {
                        Toast.makeText(EditActivity.this, "Data berhasil diupdate", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(EditActivity.this, "Terjadi kesalahan saat mengupdate data", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

}