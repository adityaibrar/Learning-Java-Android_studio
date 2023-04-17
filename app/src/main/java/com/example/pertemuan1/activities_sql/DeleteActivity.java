package com.example.pertemuan1.activities_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pertemuan1.R;
import com.example.pertemuan1.helper.DatabaseHelper;
import com.example.pertemuan1.model.Person;

public class DeleteActivity extends AppCompatActivity {

    private DatabaseHelper db;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new DatabaseHelper(this);
        // Ambil data orang dari intent
        person = getIntent().getParcelableExtra("orang");
        Button buttonHapus = findViewById(R.id.button_hapus);
        Button buttonBatal = findViewById(R.id.button_batal);
        // Implementasi button hapus
        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hapus data orang dari database
                int deletedRows = db.deletePerson(person);
                if (deletedRows > 0) {
                    Toast.makeText(DeleteActivity.this, "Data berhasil dihapus", Toast.LENGTH_LONG).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(DeleteActivity.this, "Terjadi kesalahan saat menghapus data", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Implementasi button batal
        buttonBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}