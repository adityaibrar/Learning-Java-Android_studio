package com.example.pertemuan1.activities_sql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.pertemuan1.R;
import com.example.pertemuan1.adapter.BiodataAdapter;
import com.example.pertemuan1.helper.DatabaseHelper;

public class CRUDSQLActivity extends AppCompatActivity {

    private Button addButton;
    private BiodataAdapter adapter;
    private DatabaseHelper databaseHelper;

    private void refreshList() {
        adapter.updateData(databaseHelper.getAllPerson());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudsqlactivity);

        ListView listView = findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);

        adapter = new BiodataAdapter(this, databaseHelper.getAllPerson());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final String[] options = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};

                AlertDialog.Builder builder = new AlertDialog.Builder(CRUDSQLActivity.this);
                builder.setTitle("Pilih Aktifitas")
                        .setItems(options, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0: // Lihat Biodata
                                        Intent intentLihat = new Intent(CRUDSQLActivity.this, ViewActivity.class);
                                        intentLihat.putExtra("ID", adapter.getItem(position).getId());
                                        intentLihat.putExtra("NAMA", adapter.getItem(position).getNama());
                                        intentLihat.putExtra("ALAMAT", adapter.getItem(position).getAlamat());
                                        intentLihat.putExtra("TELEPON", adapter.getItem(position).getTelepon());
                                        startActivity(intentLihat);
                                        break;

                                    case 1: // Update Biodata
                                        Intent intentUpdate = new Intent(CRUDSQLActivity.this, EditActivity.class);
                                        intentUpdate.putExtra("ID", adapter.getItem(position).getId());
                                        intentUpdate.putExtra("NAMA", adapter.getItem(position).getNama());
                                        intentUpdate.putExtra("ALAMAT", adapter.getItem(position).getAlamat());
                                        intentUpdate.putExtra("TELEPON", adapter.getItem(position).getTelepon());
                                        startActivity(intentUpdate);
                                        break;
                                    case 2: // Hapus Biodata
                                        Intent intentHapus = new Intent(CRUDSQLActivity.this, DeleteActivity.class);
                                        intentHapus.putExtra("ID", adapter.getItem(position).getId());
                                        intentHapus.putExtra("NAMA", adapter.getItem(position).getNama());
                                        intentHapus.putExtra("ALAMAT", adapter.getItem(position).getAlamat());
                                        intentHapus.putExtra("TELEPON", adapter.getItem(position).getTelepon());
                                        startActivity(intentHapus);
                                        break;
                                }
                            }
                        });
                builder.show();
            }
        });


        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTambah = new Intent(CRUDSQLActivity.this, AddActivity.class);
                startActivity(intentTambah);
            }
        });

        refreshList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateData(databaseHelper.getAllPerson());
        refreshList();

    }
}