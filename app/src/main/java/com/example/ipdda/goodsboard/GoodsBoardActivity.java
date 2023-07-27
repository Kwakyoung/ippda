package com.example.ipdda.goodsboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityGoodsBoardBinding;
import com.example.ipdda.databinding.ActivityMainBinding;

public class GoodsBoardActivity extends AppCompatActivity {

    ActivityGoodsBoardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoodsBoardBinding.inflate(getLayoutInflater());



        setContentView(binding.getRoot());
    }
}