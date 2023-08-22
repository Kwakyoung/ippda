package com.example.ipdda.goodsboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityCouponRegisterBinding;
import com.example.ipdda.databinding.ActivityGoodsBoardBinding;
import com.example.ipdda.databinding.ActivityGoodsboardBuyBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.inventory.InventoryVO;
import com.example.ipdda.order.OrderActivity;
import com.example.ipdda.pay.TossPayActivity;
import com.example.ipdda.like.LikeDTO;
import com.example.ipdda.like.LikeFragment;
import com.example.ipdda.profile.RecvCircleDTO;
import com.example.ipdda.profile.SubActivity;
import com.example.ipdda.profile.TrackDeliveryAdepter;
import com.example.ipdda.profile.coupon.CouponVO;
import com.example.ipdda.search.SearchFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class GoodsBoardActivity extends AppCompatActivity {

    Dialog write_dialog;
    boolean like = false;
    ActivityGoodsBoardBinding binding;
    ActivityGoodsboardBuyBinding dialogBinding;

    int goods_no;

    static String select_color,select_size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoodsBoardBinding.inflate(getLayoutInflater());





        // Dialog 초기화
//        write_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
//        write_dialog.setContentView(R.layout.activity_coupon_register);             // xml 레이아웃 파일과 연결
//        write_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        //리뷰 리사이클러
        binding.recvReview.setAdapter(new GoodsBoardReviewAdapter(GetGoodsBoardReview(),this));
        binding.recvReview.setLayoutManager(new LinearLayoutManager(this));



// 테스트용 추가한 부분
        binding.imgvLike.setOnClickListener(v -> {
            if (like) {
                binding.imgvLike.setImageResource(R.drawable.ic_like_blank);
                like = false;
            } else {
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

        goods_no = getIntent().getIntExtra("goods_no", 0);
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
                binding.tvGoodsPrice.setText(goodsPrice+" 원");
                binding.tvGoodsOriginalPrice.setVisibility(View.GONE);
                binding.tvOriginalPrice.setVisibility(View.GONE);
                binding.tvSalePercent.setVisibility(View.GONE);
                binding.tvSale.setVisibility(View.GONE);
                binding.lnOrignalPrice.setVisibility(View.GONE);
            }else{
                int goodsSalePrice = goodsPrice/(100/SalePercent);
                binding.tvGoodsPrice.setText(goodsSalePrice+" 원");
                binding.tvGoodsOriginalPrice.setText(goodsPrice+" 원");

            }
            binding.btnBuy.setOnClickListener(v -> {
                showDialog_buy();
            });

            binding.tvStoreName.setText(storeName);
            binding.tvStarCnt.setText(starCnt+"");
            binding.tvGoodsName.setText(goodsName);
            binding.tvGoodsContext.setText(goodsContext);
            binding.tvSalePercent.setText(SalePercent+"");
            binding.tvDeliveryTip.setText(goodsVO.getStore_delivery_tip()+" 원");
        });

        setContentView(binding.getRoot());
    }



    public ArrayList<GoodsBoardReviewDTO> GetGoodsBoardReview(){
        ArrayList<GoodsBoardReviewDTO> list = new ArrayList<>();
        list.add(new GoodsBoardReviewDTO(R.drawable.ic_profile,R.drawable.ic_home, R.drawable.ic_home,3, 5,"입다 스웨터", "남 180cm 85kg ", "옷이 정말 예쁘네염", "우랑우탄", "L", "20230207"));
        return list;
    }




    public void showDialog_buy(){
        write_dialog = new Dialog(this);
        Window window = write_dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); // 다이얼로그 크기 조절
        window.setGravity(Gravity.BOTTOM);

        dialogBinding = ActivityGoodsboardBuyBinding.inflate(write_dialog.getLayoutInflater());
        write_dialog.setContentView(dialogBinding.getRoot());

        dialogBinding.btnBuy.setOnClickListener(v -> {
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("goods_no", goods_no);
            startActivity(intent);
        });

        size_click(dialogBinding.btnXS,dialogBinding.btnSelectSize,dialogBinding.linSize);
        size_click(dialogBinding.btnS,dialogBinding.btnSelectSize,dialogBinding.linSize);
        size_click(dialogBinding.btnM,dialogBinding.btnSelectSize,dialogBinding.linSize);
        size_click(dialogBinding.btnL,dialogBinding.btnSelectSize,dialogBinding.linSize);
        size_click(dialogBinding.btnXL,dialogBinding.btnSelectSize,dialogBinding.linSize);
        size_click(dialogBinding.btnXXL,dialogBinding.btnSelectSize,dialogBinding.linSize);
        size(dialogBinding.btnXS);
        size(dialogBinding.btnS);
        size(dialogBinding.btnM);
        size(dialogBinding.btnL);
        size(dialogBinding.btnXL);
        size(dialogBinding.btnXXL);

        dialogBinding.btnSelectSize.setOnClickListener(v->{
            if (dialogBinding.linSize.getVisibility()==View.GONE) {
                dialogBinding.btnSelectSize.setText("사이즈");
                dialogBinding.linSize.setVisibility(View.VISIBLE);
                dialogBinding.recvColor.setVisibility(View.GONE);
            }else{
                dialogBinding.linSize.setVisibility(View.GONE);
                dialogBinding.recvColor.setVisibility(View.GONE);
            }

        });

        dialogBinding.btnSelectColor.setOnClickListener(v->{
            if(!dialogBinding.btnSelectSize.getText().equals("사이즈")){
                if (dialogBinding.recvColor.getVisibility()==View.GONE) {
                    dialogBinding.btnSelectColor.setText("색상");
                    dialogBinding.recvColor.setVisibility(View.VISIBLE);
                    dialogBinding.linSize.setVisibility(View.GONE);
                    color();
                }else{
                    dialogBinding.recvColor.setVisibility(View.GONE);
                    dialogBinding.linSize.setVisibility(View.GONE);
                }
            }else {
                Toast.makeText(this, "사이즈를 먼저 선택해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        write_dialog.show(); // 다이얼로그 띄우기
    }

    public void size(Button btn){
        CommonConn conn = new CommonConn(this, "inventory/check_size");
        conn.addParamMap("goods_no" , goods_no);
        conn.addParamMap("goods_size", btn.getText().toString());
        conn.onExcute(((isResult, data) -> {
            ArrayList<InventoryVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<InventoryVO>>(){}.getType());
            btn.setText(btn.getText());
            if ((list.size())==0){
                btn.setVisibility(View.GONE);
            }

        }));
    }
    public void size_click(Button btn, Button select, LinearLayout ln){
        btn.setOnClickListener(v -> {
            select.setText(btn.getText().toString());
            ln.setVisibility(View.GONE);
            if (btn == dialogBinding.btnXS) {
                select_size="XS";
            }else if (btn == dialogBinding.btnS) {
                select_size="S";
            }else if (btn == dialogBinding.btnM) {
                select_size="M";
            }else if (btn == dialogBinding.btnL) {
                select_size="L";
            }else if (btn == dialogBinding.btnXL) {
                select_size="XL";
            }else if (btn == dialogBinding.btnXXL) {
                select_size="XXL";
            }
        });
    }
    public void color() {
        CommonConn conn = new CommonConn(this, "inventory/check_size");
        conn.addParamMap("goods_no" , goods_no);
        conn.addParamMap("goods_size", select_size);
        conn.onExcute((isResult, data) -> {
            Log.d("ServerResponse", "isResult: " + isResult + ", data: " + data);
            ArrayList<InventoryVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<InventoryVO>>(){}.getType());
            // 어댑터 데이터 업데이트
            dialogBinding.recvColor.setAdapter(new GoodsBoardbuyAdapter(list, dialogBinding.btnSelectColor, dialogBinding.recvColor));
            dialogBinding.recvColor.setLayoutManager(new LinearLayoutManager(this));
        });
    }






}