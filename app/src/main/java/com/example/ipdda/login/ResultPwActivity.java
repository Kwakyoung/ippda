package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityResultPwBinding;

public class ResultPwActivity extends AppCompatActivity {
    ActivityResultPwBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPwBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnActivitylogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}