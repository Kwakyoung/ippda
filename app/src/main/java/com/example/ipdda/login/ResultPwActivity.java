package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

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

        binding.edtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtPw.length() == 0) {
                    binding.feedback.setVisibility(View.GONE);
                } else if (binding.edtPw.length() != 0) {
                    binding.feedback.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edtPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtPwCheck.length() == 0) {
                    binding.feedback2.setVisibility(View.GONE);
                } else if (binding.edtPwCheck.length() != 0) {
                    binding.feedback2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}