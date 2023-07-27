package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {
    ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        int receivedValue = getIntent().getIntExtra("key", 0);
        if(receivedValue==0){
            binding.tvTitle.setText("장바구니");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);


        }else if(receivedValue==1){
            binding.tvTitle.setText("좋아요");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("좋아요 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);


        }else if(receivedValue==2){
            binding.tvTitle.setText("즐겨찾기");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("즐겨찾기 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);


        }else if(receivedValue==3){
            binding.tvTitle.setText("리뷰");
            binding.layoutText.setVisibility(View.GONE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.VISIBLE);
            binding.layout.setVisibility(View.GONE);


        }
        binding.btnBack.setOnClickListener(v -> this.finish());
    }
}