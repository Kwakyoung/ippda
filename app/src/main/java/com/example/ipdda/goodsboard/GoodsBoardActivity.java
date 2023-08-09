package com.example.ipdda.goodsboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.ActivityGoodsBoardBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.home.HomeGoodsRecommendAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.sql.Connection;
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

        int goods_no = getIntent().getIntExtra("goods_no", 0);
        Log.d("goods_no", "onCreate: " + goods_no);//goods/goodsboard
        CommonConn conn = new CommonConn(this, "goods/goodsboard");
        conn.addParamMap("goods_no" , goods_no);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            GoodsVO goodsVO = arrayList.get(0);

            String goodsName = goodsVO.getGoods_name();
            String goodsPrice = goodsVO.getGoods_price()+"";
            String storeName = goodsVO.getStore_name()+"";
            String starCnt = goodsVO.getGoods_star()+"";


            binding.tvStoreName.setText(storeName);
            binding.tvStarCnt.setText(starCnt);
            binding.tvGoodsName.setText(goodsName);
            binding.tvGoodsPrice.setText(goodsPrice);

        });
//

        setContentView(binding.getRoot());
    }

    public ArrayList<GoodsBoardReviewDTO> GetGoodsBoardReview(){
        ArrayList<GoodsBoardReviewDTO> list = new ArrayList<>();
        list.add(new GoodsBoardReviewDTO(R.drawable.ic_profile,R.drawable.ic_home, R.drawable.ic_home,3, 5,"입다 스웨터", "남 180cm 85kg ", "옷이 정말 예쁘네염", "우랑우탄", "L", "20230207"));
        return list;
    }




}