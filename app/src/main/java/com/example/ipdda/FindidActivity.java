package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.databinding.ActivityFindidBinding;

public class FindidActivity extends AppCompatActivity {

    ActivityFindidBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindidBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvFindPw.setOnClickListener(v -> {
            Intent intent = new Intent(this , FindpwActivity.class);
            startActivity(intent);
        });
    }
}