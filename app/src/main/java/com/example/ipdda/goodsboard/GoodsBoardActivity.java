package com.example.ipdda.goodsboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityGoodsBoardBinding;


import java.util.ArrayList;

public class GoodsBoardActivity extends AppCompatActivity {

    ActivityGoodsBoardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoodsBoardBinding.inflate(getLayoutInflater());


        binding.recvReview.setAdapter(new GoodsBoardReviewAdapter(GetGoodsBoardReview(),this));
        binding.recvReview.setLayoutManager(new LinearLayoutManager(this));

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        setContentView(binding.getRoot());
    }

    public ArrayList<GoodsBoardReviewDTO> GetGoodsBoardReview(){
        ArrayList<GoodsBoardReviewDTO> list = new ArrayList<>();
        list.add(new GoodsBoardReviewDTO(R.drawable.ic_profile,R.drawable.ic_home, R.drawable.ic_home,3, 5,"입다 스웨터", "남 180cm 85kg ", "옷이 정말 예쁘네염", "우랑우탄", "L", "20230207"));
        return list;
    }

}