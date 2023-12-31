package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.ipdda.databinding.ActivitySplashBinding;
import com.example.ipdda.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ProgressDialog dialog = new ProgressDialog(this);

        new Handler().postDelayed(()->{
            dialog.dismiss();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } , 2000);


    }

}
