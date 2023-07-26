package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityQnaBinding;

public class QnAActivity extends AppCompatActivity {

    ActivityQnaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityQnaBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> this.finish());
    }
}