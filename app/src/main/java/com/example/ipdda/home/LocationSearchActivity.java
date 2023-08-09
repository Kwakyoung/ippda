package com.example.ipdda.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityLocationSearchBinding;

public class LocationSearchActivity extends AppCompatActivity {
    ActivityLocationSearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
    }
}