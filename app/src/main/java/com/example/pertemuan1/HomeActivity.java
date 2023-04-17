package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pertemuan1.activities_sql.CRUDSQLActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
     Button bio,lv,frag,reg,rv, inte, cmr, sqf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Praktikum Mobile");
        bio = findViewById(R.id.btn_bio);
        lv = findViewById(R.id.btn_lv);
        reg = findViewById(R.id.btn_reg);
        rv = findViewById(R.id.btn_recyc);
        frag = findViewById(R.id.btn_frag);
        inte = findViewById(R.id.btn_intn);
        cmr = findViewById(R.id.btn_camera);
        sqf = findViewById(R.id.btn_sqflite);

        bio.setOnClickListener(this);
        lv.setOnClickListener(this);
        reg.setOnClickListener(this);
        rv.setOnClickListener(this);
        frag.setOnClickListener(this);
        inte.setOnClickListener(this);
        cmr.setOnClickListener(this);
        sqf.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bio:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_lv:
                startActivity(new Intent(this, ListCountry.class));
                break;
            case R.id.btn_reg:
                startActivity(new Intent(this, RegistrationActivity.class));
                break;
            case R.id.btn_recyc:
                startActivity(new Intent(this, RecycleActivity.class));
                break;
            case R.id.btn_frag:
                startActivity(new Intent(this, BottomNavActivity.class));
                break;
            case R.id.btn_intn:
                startActivity(new Intent(this, IntentActivity.class));
                break;
            case R.id.btn_camera:
                startActivity(new Intent(this, CameraActivity.class));
                break;
            case R.id.btn_sqflite:
                startActivity(new Intent(this, CRUDSQLActivity.class));
                break;
        }
    }

}