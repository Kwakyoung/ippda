package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {
    ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}