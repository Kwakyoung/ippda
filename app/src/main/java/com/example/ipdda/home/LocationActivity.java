package com.example.ipdda.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityLocationBinding;

public class LocationActivity extends AppCompatActivity {

    ActivityLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });


        binding.edtSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this, LocationSearchActivity.class);
            startActivity(intent);
        });
    }
}