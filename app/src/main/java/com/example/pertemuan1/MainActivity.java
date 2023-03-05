package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    DatePickerDialog picker;
    EditText txt_nama,txt_alamat,date_ttl;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_nama = findViewById(R.id.txt_nama);
        txt_alamat = findViewById(R.id.txt_alamat);
        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        date_ttl = (EditText) findViewById(R.id.txt_ttl);
        date_ttl.setInputType(InputType.TYPE_NULL);
        date_ttl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int MonthOfYear, int DayOfMonth){
                            date_ttl.setText(DayOfMonth + "/" + (MonthOfYear + 1 ) + "/" + year);
                        }
                },year,month, day);
                picker.show();
            }
        });
    }

    @Override
    public void onClick(View v){
        if(v == btn_submit){
            String name = txt_nama.getText().toString();
            String alamat = txt_alamat.getText().toString();
            String tanggal = date_ttl.getText().toString();
            String message = "Nama: " + name + " Alamat: " + alamat + " Tanggal Lahir: " + tanggal;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}