package com.example.ipdda.order;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ActivityTossPayBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.member.MemberVO;
import com.google.android.gms.common.internal.service.Common;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    String TAG = "ippda";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //최초 실행시 직접입력 안보이게 하기
        binding.edtDeliveryRequest.setVisibility(View.GONE);

        //뒤로가기
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });


        //결제 정보 체크
       binding.radioPay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked){
                   binding.lnPay.setVisibility(View.VISIBLE);
               }else{
                   binding.lnPay.setVisibility(View.GONE);
               }
           }
       });

       binding.radioIppdapay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked){
                   binding.lnIppdapay.setVisibility(View.VISIBLE);
               }else{
                   binding.lnIppdapay.setVisibility(View.GONE);
               }
           }
       });

        int goods_no = getIntent().getIntExtra("goods_no", 0);
        Log.d("goods_no", "onCreate: " + goods_no);
        CommonConn conn = new CommonConn(this, "goods/goodsboard");
        conn.addParamMap("goods_no" , goods_no);
        conn.onExcute((isResult, data) -> {
                    ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>() {}.getType());
                    GoodsVO goodsVO = arrayList.get(0);

            binding.recvOrderGoods.setLayoutManager(new LinearLayoutManager(this));
            binding.recvOrderGoods.setAdapter(new OrderAdapter(arrayList));

            int goodsPrice = goodsVO.getGoods_price();
            int SalePercent = goodsVO.getGoods_sale_percent();

            if(goodsVO.getGoods_sale_percent() == 0){
                binding.tvSalePrice.setText("0 원");
                binding.tvPayPrice.setText(goodsVO.getGoods_price()+" 원");
                binding.tvOriginalPrice.setText(goodsVO.getGoods_price()+" 원");
            }else {
                int goodsPayPrice = goodsPrice/(100/SalePercent);
                int goodsSalePrice = goodsPrice-goodsPayPrice;
                binding.tvOriginalPrice.setText(goodsVO.getGoods_price()+" 원");
                binding.tvSalePrice.setText(goodsSalePrice+" 원");
                binding.tvPayPrice.setText(goodsPayPrice+" 원");
            }


                });


                //배송지 정보
                binding.tvMemberName.setText(CommonVar.loginInfo.getMember_name()+"");
                binding.tvMemberPhone.setText(CommonVar.loginInfo.getMember_phone()+"");
                binding.tvMemberAddress.setText(CommonVar.loginInfo.getMember_address()+"");

                //상세주소 없을 때 null표기되는거 안뜨게
                if(CommonVar.loginInfo.getMember_sub_address() == null){
                    binding.tvSubMemberAddress.setText("");
                }else {
                    binding.tvSubMemberAddress.setText(CommonVar.loginInfo.getMember_sub_address()+"");
                }

                //배송 요청사항 팝업리스트
                binding.tvDeliveryRequest.setOnClickListener(v -> {
                    showPopupList();
                });




        binding.btnChangeAddress.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangeAddressActivity.class);
            startActivity(intent);
        });

    }


    private void showPopupList() {
        final String[] items = {"부재시 경비실에 맡겨주세요", "부재 시 택배함에 넣어주세요", "부재 시 집 앞에 놔주세요", "직접입력"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                String selectedItem = items[item];
                if(selectedItem.equals("부재시 경비실에 맡겨주세요")){
                    binding.tvDeliveryRequest.setText("부재시 경비실에 맡겨주세요");
                    binding.edtDeliveryRequest.setVisibility(View.GONE);
                } else if (selectedItem.equals("부재 시 택배함에 넣어주세요")) {
                    binding.tvDeliveryRequest.setText("부재 시 택배함에 넣어주세요");
                    binding.edtDeliveryRequest.setVisibility(View.GONE);
                } else if (selectedItem.equals("부재 시 집 앞에 놔주세요")) {
                    binding.tvDeliveryRequest.setText("부재 시 집 앞에 놔주세요");
                    binding.edtDeliveryRequest.setVisibility(View.GONE);
                }else if (selectedItem.equals("직접입력")) {
                    binding.tvDeliveryRequest.setText("직접입력");
                    binding.edtDeliveryRequest.setVisibility(View.VISIBLE);
                }


            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}