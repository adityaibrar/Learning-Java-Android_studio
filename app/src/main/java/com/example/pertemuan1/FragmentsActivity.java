package com.example.pertemuan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.pertemuan1.fragment.BeverageFragment;
import com.example.pertemuan1.fragment.ExtraFragment;
import com.example.pertemuan1.fragment.FastFoodFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView botNavFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        botNavFood = findViewById(R.id.navigation);
        getSupportActionBar().hide();
        botNavFood.setOnItemSelectedListener(this);
        botNavFood.setSelectedItemId(R.id.food_nav);
    }

    FastFoodFragment foodFragment = new FastFoodFragment();
    BeverageFragment beverageFragment = new BeverageFragment();
    ExtraFragment extraFragment = new ExtraFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.food_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, foodFragment).commit();
                return true;
            case R.id.beverage_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, beverageFragment).commit();
                return true;
            case R.id.extra_food_nav:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, extraFragment).commit();
                return true;
        }
        return false;
    }
}