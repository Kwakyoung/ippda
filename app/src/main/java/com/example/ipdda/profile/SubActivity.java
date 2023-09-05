package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivitySubBinding;
import com.example.ipdda.home.GoodsVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

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
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);

        }else if(receivedValue==1){
            binding.tvTitle.setText("좋아요");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("좋아요 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);

            CommonConn conn = new CommonConn(this, "goods_like/list");
            conn.addParamMap("member_no",CommonVar.loginInfo.getMember_no());
            conn.addParamMap("goods_no", CommonVar.loginInfo.getMember_no());
            conn.onExcute((isResult, data) -> {
                ArrayList<GoodsVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<GoodsVO>>(){}.getType());
                binding.recv.setAdapter(new BascketRecvAdapter(list,this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
            });

        }else if(receivedValue==2){
            binding.tvTitle.setText("즐겨찾기");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("즐겨찾기 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);

        }else if(receivedValue==3){
            binding.tvTitle.setText("리뷰");
            binding.layoutText.setVisibility(View.GONE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.VISIBLE);
            binding.layout.setVisibility(View.GONE);


        }

        binding.btnBack.setOnClickListener(v -> this.finish());
    }


}