package com.example.ipdda.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityReviewBinding;
import com.example.ipdda.goodsboard.GoodsBoardActivity;

public class ReviewActivity extends AppCompatActivity {


    ActivityReviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReviewBinding.inflate(getLayoutInflater());



        int goods_no = getIntent().getIntExtra("goods_no", 0);
        int store_no = getIntent().getIntExtra("store_no", 0);

        binding.btnReviewComplete.setOnClickListener(v -> {
            float rating = binding.rtBar.getRating();
            String reviewContent = binding.editText.getText().toString();
            CommonConn conn = new CommonConn(this, "review/insert");
            conn.addParamMap("goods_no" , goods_no);
            conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
            conn.addParamMap("content", reviewContent);
            conn.addParamMap("store_no", store_no);
            conn.addParamMap("rating", rating);
            conn.onExcute((isResult, data) -> {
                Intent intent = new Intent(this, GoodsBoardActivity.class);
                intent.putExtra("goods_no", goods_no);
                startActivity(intent);

            });
        });


        setContentView(binding.getRoot());
    }
}