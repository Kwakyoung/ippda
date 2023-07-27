package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.ipdda.MainActivity;
import com.example.ipdda.databinding.ActivityLoginBinding;

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
            Intent intent = new Intent(this, FindActivity.class);
            startActivity(intent);
        });

        binding.tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });

        binding.edtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.edtId.length()==0){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}