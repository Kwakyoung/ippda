package com.example.ipdda.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ActivityTossPayBinding;
import com.example.ipdda.member.MemberVO;
import com.google.gson.Gson;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    String TAG = "ippda";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recvOrderGoods.setLayoutManager(new LinearLayoutManager(this));
        binding.recvOrderGoods.setAdapter(new OrderAdapter(getlist()));

        Intent intent1 = getIntent();

        CommonVar.loginInfo = new MemberVO();
//        CommonVar.loginInfo.setMember_name(intent1.getStringExtra("id"));
//        CommonVar.loginInfo.setMember_phone(intent1.getStringExtra("pw"));

        CommonConn conn = new CommonConn(this,"member/order");
        conn.addParamMap("member_id", CommonVar.loginInfo.getMember_id());
        conn.addParamMap("member_pw", CommonVar.loginInfo.getMember_pw());

        conn.onExcute((isResult, data) -> {
            if (isResult) {
                CommonVar.loginInfo = new Gson().fromJson(data, MemberVO.class);
                if (CommonVar.loginInfo == null) {
                    binding.tvMemberName.setText("틀림");
                } else {
                    binding.tvMemberName.setText(CommonVar.loginInfo.getMember_name());
                    binding.tvMemberPhone.setText(CommonVar.loginInfo.getMember_phone());
                    binding.tvMemberAddress.setText(CommonVar.loginInfo.getMember_address()+"주소없으면 null");
                }
            }
        });





        binding.btnChangeAddress.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangeAddressActivity.class);
            startActivity(intent);
        });

    }



    public ArrayList<OrderDTO> getlist(){
        ArrayList<OrderDTO> list = new ArrayList<>();
        list.add(new OrderDTO("가게이름","상품이름","옵션(XL)","16,800원",R.drawable.test));
        list.add(new OrderDTO("목포점","새우깡","S","800원",R.drawable.test));

        return list;
    }
}