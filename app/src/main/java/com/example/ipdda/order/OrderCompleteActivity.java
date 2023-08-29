package com.example.ipdda.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ActivityOrderCompleteBinding;

public class OrderCompleteActivity extends AppCompatActivity {

    ActivityOrderCompleteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        binding.tvPayPrice.setText(intent.getExtras().getInt("holdingAmount")+" 원");
        binding.tvGoodsPrice.setText(intent.getExtras().getInt("totalpice")+ " 원");
        binding.tvDeliveryTip.setText(intent.getExtras().getInt("storeDeliverytip")+ " 원");

        binding.tvMainAddress.setText(CommonVar.loginInfo.getMember_address());
        binding.tvSubAddress.setText(CommonVar.loginInfo.getMember_sub_address());
        binding.tvPhone.setText(CommonVar.loginInfo.getMember_phone());
        binding.tvName.setText(CommonVar.loginInfo.getMember_name());


    }
}