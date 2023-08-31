package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityTrackDeliveryBinding;
import com.example.ipdda.order.Order_ingVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TrackDeliveryActivity extends AppCompatActivity {
    ActivityTrackDeliveryBinding binding;
    int receivedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackDeliveryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> this.finish());
        receivedValue = getIntent().getIntExtra("key", 0);

        binding.imgvImg1.setOnClickListener(v -> updateBackgroundTint(0));
        binding.imgvImg2.setOnClickListener(v -> updateBackgroundTint(1));
        binding.imgvImg3.setOnClickListener(v -> updateBackgroundTint(2));
        binding.imgvImg4.setOnClickListener(v -> updateBackgroundTint(3));

        updateBackgroundTint(receivedValue);
    }

    private void updateBackgroundTint(int newValue) {
        receivedValue = newValue;
        binding.imgvImg1.setBackgroundTintList(receivedValue == 0 ? getResources().getColorStateList(R.color.green) : null);
        binding.imgvImg2.setBackgroundTintList(receivedValue == 1 ? getResources().getColorStateList(R.color.green) : null);
        binding.imgvImg3.setBackgroundTintList(receivedValue == 2 ? getResources().getColorStateList(R.color.green) : null);
        binding.imgvImg4.setBackgroundTintList(receivedValue == 3 ? getResources().getColorStateList(R.color.green) : null);

        CommonConn conn = new CommonConn(this, "order_ing/check");
        conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());

        String orderStatus = "",
                nothing="";

        switch (receivedValue) {
            case 0:
                orderStatus = "결제완료";
                nothing="결제가 완료된 상품이 없습니다.";
                break;
            case 1:
                orderStatus = "배송준비중";
                nothing="배송 준비 중인 상품이 없습니다.";
                break;
            case 2:
                orderStatus = "배송중";
                nothing="배송 중인 상품이 없습니다.";
                break;
            case 3:
                orderStatus = "배송완료";
                nothing="배송이 완료된 상품이 없습니다.";
                break;
        }

        conn.addParamMap("order_status", orderStatus);
        String finalNothing = nothing;
        conn.onExcute((isResult, data) -> {
            ArrayList<Order_ingVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<Order_ingVO>>() {}.getType());
            binding.recv.setVisibility(View.VISIBLE);
            binding.tvNothing.setVisibility(View.GONE);
            binding.recv.setAdapter(new TrackDeliveryListAdapter(list, this));
            binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            if (list.size()==0){
                binding.recv.setVisibility(View.GONE);
                binding.tvNothing.setText(finalNothing);
                binding.tvNothing.setVisibility(View.VISIBLE);
            }
        });
    }
}
