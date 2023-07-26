package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {
    ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> this.finish());
    }
}