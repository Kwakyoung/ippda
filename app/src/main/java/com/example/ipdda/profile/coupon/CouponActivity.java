package com.example.ipdda.profile.coupon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityCouponBinding;
import com.example.ipdda.databinding.ActivityCouponRegisterBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity {
    Dialog write_dialog;
    ActivityCouponBinding binding;
    ActivityCouponRegisterBinding dialogBinding;
    private CouponAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCouponBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.couponRegister.setOnClickListener(v -> {
            showDialog();
        });
        binding.btnBack.setOnClickListener(v -> this.finish());



        CommonConn conn = new CommonConn(this, "coupon/load");
        conn.addParamMap("member_no" , CommonVar.loginInfo.getMember_no());
        binding.tvMyCoupon.setOnClickListener(v -> {
            int a=1;
            setTabColors(binding.tvMyCoupon);
            binding.tvNothing.setText("현재 쿠폰함이 비어있습니다.");

            conn.addParamMap("coupon_status" , "보유");
                conn.onExcute((isResult, data) -> {
                    ArrayList<CouponVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<CouponVO>>(){}.getType());
                    //if문으로 list의 사이즈처리 , 해야함.
                    CouponAdapter adapter = new CouponAdapter(list,1);
                    binding.recv.setAdapter(adapter);
                    binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
                    handleCouponData(data,a);
                });
        });


        binding.tvUsedCoupon.setOnClickListener(v -> {
            int a=2;
            setTabColors(binding.tvUsedCoupon);
            binding.tvNothing.setText("사용하신 쿠폰이 없습니다.");

            conn.addParamMap("coupon_status" , "사용완료");
            conn.onExcute((isResult, data) -> {
                ArrayList<CouponVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<CouponVO>>(){}.getType());
                //if문으로 list의 사이즈처리 , 해야함.
                CouponAdapter adapter = new CouponAdapter(list,2);
                binding.recv.setAdapter(adapter);
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
                handleCouponData(data,a);
            });
        });
        binding.deadlineCoupon.setOnClickListener(v -> {
            int a=3;
            setTabColors(binding.deadlineCoupon);
            binding.tvNothing.setText("기간 만료된 쿠폰이 없습니다.");

            conn.addParamMap("coupon_status" , "기간만료");
            conn.onExcute((isResult, data) -> {
                ArrayList<CouponVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<CouponVO>>(){}.getType());
                //if문으로 list의 사이즈처리 , 해야함.
                CouponAdapter adapter = new CouponAdapter(list,3);
                binding.recv.setAdapter(adapter);
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
                handleCouponData(data,a);
            });
        });
        binding.cancelCcoupon.setOnClickListener(v -> {
            int a=4;
            setTabColors(binding.cancelCcoupon);
            binding.tvNothing.setText("취소/환불 된 쿠폰함이 비어있습니다.");
            conn.addParamMap("coupon_status" , "환불");
            conn.onExcute((isResult, data) -> {
                ArrayList<CouponVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<CouponVO>>(){}.getType());
                //if문으로 list의 사이즈처리 , 해야함.
                CouponAdapter adapter = new CouponAdapter(list,4);
                binding.recv.setAdapter(adapter);
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
                handleCouponData(data,a);
            });
        });
    }
    private void handleCouponData(String data,int a) {
        ArrayList<CouponVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CouponVO>>() {}.getType());
        CouponAdapter adapter = new CouponAdapter(list,a);
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        if (list != null && !list.isEmpty()) {
            binding.recv.setVisibility(View.VISIBLE);
            binding.tvNothing.setVisibility(View.GONE);
        } else {
            binding.recv.setVisibility(View.GONE);
            binding.tvNothing.setVisibility(View.VISIBLE);
        }
    }
    private void setTabColors(TextView selectedTab) {
        TextView[] tabs = {binding.tvMyCoupon, binding.tvUsedCoupon, binding.deadlineCoupon, binding.cancelCcoupon};
        int selectedColor = Color.WHITE;
        int defaultColor = Color.parseColor("#777777");

        for (TextView tab : tabs) {
            tab.setTextColor(tab == selectedTab ? selectedColor : defaultColor);
        }
    }

    public void showDialog(){
        write_dialog = new Dialog(this);       // Dialog 초기화
        write_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        write_dialog.setContentView(R.layout.activity_coupon_register);             // xml 레이아웃 파일과 연결
        write_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        write_dialog.show(); // 다이얼로그 띄우기
        dialogBinding = ActivityCouponRegisterBinding.inflate(write_dialog.getLayoutInflater());
        write_dialog.setContentView(dialogBinding.getRoot());

        dialogBinding.btnCancle.setOnClickListener(v -> {
            write_dialog.dismiss();
        });
        dialogBinding.btnComplete.setOnClickListener(v -> {
            if(!dialogBinding.couponNo.getText().toString().isEmpty()) {
                CommonConn conn = new CommonConn(this, "coupon/register");
                conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                conn.addParamMap("coupon_no", dialogBinding.couponNo.getText().toString());
                conn.onExcute((isResult, data) -> {
                    Log.d("CommonConn", "isResult: " + isResult + ", data: " + data);
                    if (Integer.parseInt(data) >= 1) {
                        Toast.makeText(this, "쿠폰 등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "쿠폰 등록에 실패하였습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                Toast.makeText(this, "쿠폰번호를 입력해주세요.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}