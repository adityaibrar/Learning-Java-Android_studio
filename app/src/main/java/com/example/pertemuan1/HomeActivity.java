package com.example.pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
     Button bio,lv,frag,reg,rv, inte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Praktikum Mobile");
        bio = findViewById(R.id.btn_bio);
        bio.setOnClickListener(this);
        lv = findViewById(R.id.btn_lv);
        lv.setOnClickListener(this);
        reg = findViewById(R.id.btn_reg);
        reg.setOnClickListener(this);
        rv = findViewById(R.id.btn_recyc);
        rv.setOnClickListener(this);
        frag = findViewById(R.id.btn_frag);
        frag.setOnClickListener(this);
        inte = findViewById(R.id.btn_intn);
        inte.setOnClickListener(this);
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
                startActivity(new Intent(this, FragmentsActivity.class));
                break;
            case R.id.btn_intn:
                startActivity(new Intent(this, IntentActivity.class));
                break;
        }
    }

}