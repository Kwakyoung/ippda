package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.databinding.ActivityLoginBinding;
import com.example.ipdda.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentManager manager = getSupportFragmentManager();


        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        });

        binding.tvFind.setOnClickListener(v -> {
            Intent intent = new Intent(this, FindidActivity.class);
            startActivity(intent);
        });

        binding.tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}