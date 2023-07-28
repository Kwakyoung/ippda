package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityCouponBinding;

import java.util.ArrayList;

public class CouponActivity extends AppCompatActivity {
    ActivityCouponBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCouponBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.btnBack.setOnClickListener(v -> this.finish());

        binding.tvMyCoupon.setOnClickListener(v -> {
            binding.tvMyCoupon.setTextColor(Color.WHITE);
            binding.tvUsedCoupon.setTextColor(Color.parseColor("#777777"));
            binding.deadlineCoupon.setTextColor(Color.parseColor("#777777"));
            binding.cancelCcoupon.setTextColor(Color.parseColor("#777777"));
            binding.tvNothing.setText("현재 쿠폰함이 비어있습니다.");
            ArrayList<CouponDTO> couponList = getcouponList();
            if (couponList.isEmpty()) {
                binding.recv.setVisibility(View.GONE);
                binding.tvNothing.setVisibility(View.VISIBLE);
            } else {
                binding.recv.setVisibility(View.VISIBLE);
                binding.tvNothing.setVisibility(View.GONE);
                binding.recv.setAdapter(new HaveCouponAdapter(getcouponList(),this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
            }
        });
        binding.tvUsedCoupon.setOnClickListener(v -> {
            binding.tvMyCoupon.setTextColor(Color.parseColor("#777777"));
            binding.tvUsedCoupon.setTextColor(Color.WHITE);
            binding.deadlineCoupon.setTextColor(Color.parseColor("#777777"));
            binding.cancelCcoupon.setTextColor(Color.parseColor("#777777"));
            binding.tvNothing.setText("사용하신 쿠폰이 없습니다.");
            ArrayList<CouponDTO> couponList = getcouponList();
            if (couponList.isEmpty()) {
                binding.recv.setVisibility(View.GONE);
                binding.tvNothing.setVisibility(View.VISIBLE);
            } else {
                binding.recv.setVisibility(View.VISIBLE);
                binding.tvNothing.setVisibility(View.GONE);
                binding.recv.setAdapter(new UsedCouponAdapter(getcouponList(),this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
            }
        });
        binding.deadlineCoupon.setOnClickListener(v -> {
            binding.tvMyCoupon.setTextColor(Color.parseColor("#777777"));
            binding.tvUsedCoupon.setTextColor(Color.parseColor("#777777"));
            binding.deadlineCoupon.setTextColor(Color.WHITE);
            binding.cancelCcoupon.setTextColor(Color.parseColor("#777777"));
            binding.tvNothing.setText("기간 만료된 쿠폰이 없습니다.");
            ArrayList<CouponDTO> couponList = getcouponList();
            if (couponList.isEmpty()) {
                binding.recv.setVisibility(View.GONE);
                binding.tvNothing.setVisibility(View.VISIBLE);
            } else {
                binding.recv.setVisibility(View.VISIBLE);
                binding.tvNothing.setVisibility(View.GONE);
                binding.recv.setAdapter(new DeadlineCouponAdapter(getcouponList(),this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
            }
        });
        binding.cancelCcoupon.setOnClickListener(v -> {
            binding.tvMyCoupon.setTextColor(Color.parseColor("#777777"));
            binding.tvUsedCoupon.setTextColor(Color.parseColor("#777777"));
            binding.deadlineCoupon.setTextColor(Color.parseColor("#777777"));
            binding.cancelCcoupon.setTextColor(Color.WHITE);
            binding.tvNothing.setText("취소/환불 된 쿠폰함이 비어있습니다.");
            ArrayList<CouponDTO> couponList = getcouponList();
            if (couponList.isEmpty()) {
                binding.recv.setVisibility(View.GONE);
                binding.tvNothing.setVisibility(View.VISIBLE);
            } else {
                binding.recv.setVisibility(View.VISIBLE);
                binding.tvNothing.setVisibility(View.GONE);
                binding.recv.setAdapter(new CancleCouponAdapter(couponList, this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            }
        });
    }
    ArrayList<CouponDTO> getcouponList(){
        ArrayList<CouponDTO> list= new ArrayList<>();
        list.add(new CouponDTO(45615644,1,2,R.drawable.ic_launcher_background,"입다 오픈 쿠폰1","1입다 어플 오픈 기념 쿠폰 입니다. 입다에서 판매하는 모든 옷을 무료로 제공합니다.","2024.01.01"));
        list.add(new CouponDTO(25615644,81,8,R.drawable.ic_launcher_background,"입다 오픈 쿠폰2","2입다 어플 오픈 기념 쿠폰 입니다. 입다에서 판매하는 모든 옷을 무료로 제공합니다.","2024.01.02"));
        list.add(new CouponDTO(85615644,35,1,R.drawable.ic_launcher_background,"입다 오픈 쿠폰3","3입다 어플 오픈 기념 쿠폰 입니다. 입다에서 판매하는 모든 옷을 무료로 제공합니다.","2024.01.03"));

        return list;
    }

}