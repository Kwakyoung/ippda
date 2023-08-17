package com.example.ipdda.goodsboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityCouponRegisterBinding;
import com.example.ipdda.databinding.ActivityGoodsBoardBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.home.HomeFragment;
import com.example.ipdda.home.HomeGoodsRecommendAdapter;
import com.example.ipdda.pay.PayActivity;
import com.example.ipdda.pay.TossPayActivity;
import com.example.ipdda.like.LikeDTO;
import com.example.ipdda.like.LikeFragment;
import com.example.ipdda.profile.SubActivity;
import com.example.ipdda.search.SearchFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.sql.Connection;
import java.util.ArrayList;

public class GoodsBoardActivity extends AppCompatActivity {

    Dialog write_dialog;
    boolean like = false;
    ActivityGoodsBoardBinding binding;
    ActivityCouponRegisterBinding dialogBinding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoodsBoardBinding.inflate(getLayoutInflater());

        write_dialog = new Dialog(this);       // Dialog 초기화
        write_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        write_dialog.setContentView(R.layout.activity_coupon_register);             // xml 레이아웃 파일과 연결
        write_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        binding.recvReview.setAdapter(new GoodsBoardReviewAdapter(GetGoodsBoardReview(),this));
        binding.recvReview.setLayoutManager(new LinearLayoutManager(this));

        // 테스트용 추가함.
        binding.imgvLike.setOnClickListener(v -> {
            if (like) {
                binding.imgvLike.setImageResource(R.drawable.ic_like_blank);
                like = false;
            }else {
                binding.imgvLike.setImageResource(R.drawable.ic_like_green);

                like = true;
            }

        });

        binding.imgvHome.setOnClickListener(v -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        });


        binding.imgvSearch.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            searchFragment.show(getSupportFragmentManager(), "search_dialog");
        });

        binding.imgvMybag.setOnClickListener(v -> {
            Intent intent = new Intent(this, SubActivity.class);
            intent.putExtra("key", 0);
            startActivity(intent);
        });

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        int goods_no = getIntent().getIntExtra("goods_no", 0);
        Log.d("goods_no", "onCreate: " + goods_no);
        CommonConn conn = new CommonConn(this, "goods/goodsboard");
        conn.addParamMap("goods_no" , goods_no);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            GoodsVO goodsVO = arrayList.get(0);


            String goodsName = goodsVO.getGoods_name();
            int goodsPrice = goodsVO.getGoods_price();
            int SalePercent = goodsVO.getGoods_sale_percent();
            String storeName = goodsVO.getStore_name()+"";
            String starCnt = goodsVO.getGoods_star()+"";
            String goodsContext = goodsVO.getGoods_info()+"";



            if(SalePercent == 0){
                binding.tvGoodsPrice.setText(goodsPrice+"원");
                binding.tvGoodsOriginalPrice.setVisibility(View.GONE);
                binding.tvOriginalPrice.setVisibility(View.GONE);
                binding.tvSalePercent.setVisibility(View.GONE);
                binding.tvSale.setVisibility(View.GONE);

                binding.btnBuy.setOnClickListener(v -> {
                    showDialog();
                    /*Intent intent = new Intent(this, TossPayActivity.class);
                    intent.putExtra("price", goodsPrice);
                    startActivity(intent);*/
                });
            }else{
                int goodsSalePrice = goodsPrice/(100/SalePercent);
                binding.tvGoodsPrice.setText(goodsSalePrice+"원");
                binding.tvGoodsOriginalPrice.setText(goodsPrice+"원");

                binding.btnBuy.setOnClickListener(v -> {
                    showDialog();
                    /*Intent intent = new Intent(this, TossPayActivity.class);
                    intent.putExtra("price", goodsSalePrice);
                    startActivity(intent);*/
                });

            }

            binding.tvStoreName.setText(storeName);
            binding.tvStarCnt.setText(starCnt);
            binding.tvGoodsName.setText(goodsName);
            binding.tvGoodsContext.setText(goodsContext);
            binding.tvSalePercent.setText(SalePercent+"");
        });




        setContentView(binding.getRoot());
    }



    public ArrayList<GoodsBoardReviewDTO> GetGoodsBoardReview(){
        ArrayList<GoodsBoardReviewDTO> list = new ArrayList<>();
        list.add(new GoodsBoardReviewDTO(R.drawable.ic_profile,R.drawable.ic_home, R.drawable.ic_home,3, 5,"입다 스웨터", "남 180cm 85kg ", "옷이 정말 예쁘네염", "우랑우탄", "L", "20230207"));
        return list;
    }

    public void showDialog(){
        write_dialog.show(); // 다이얼로그 띄우기
        dialogBinding = ActivityCouponRegisterBinding.inflate(write_dialog.getLayoutInflater());
        write_dialog.setContentView(dialogBinding.getRoot());



    }

}