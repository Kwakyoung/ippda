package com.example.ipdda.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ActivityOrderCompleteBinding;
import com.example.ipdda.home.HomeFragment;
import com.example.ipdda.login.FindidFragment;

public class OrderCompleteActivity extends AppCompatActivity {
    Intent intent;
    ActivityOrderCompleteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderCompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        intent = getIntent();
        //binding.tvOrderNum.setText();
        binding.tvPayPrice.setText(intent.getExtras().getInt("holdingAmount")+" 원");
        binding.tvGoodsPrice.setText(intent.getExtras().getInt("totalprice")+ " 원");
        binding.tvDeliveryTip.setText(intent.getExtras().getInt("storeDeliverytip")+ " 원");

        binding.tvMainAddress.setText(CommonVar.loginInfo.getMember_address());
        binding.tvSubAddress.setText(CommonVar.loginInfo.getMember_sub_address());
        binding.tvPhone.setText(CommonVar.loginInfo.getMember_phone());
        binding.tvName.setText(CommonVar.loginInfo.getMember_name());




        binding.tvLogo.setOnClickListener(v -> {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}