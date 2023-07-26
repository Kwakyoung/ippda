package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.databinding.ActivityFindpwBinding;

public class FindpwActivity extends AppCompatActivity {

    ActivityFindpwBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindpwBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvFindId.setOnClickListener(v -> {
            Intent intent = new Intent(this, FindidActivity.class);
            startActivity(intent);
        });
    }
}