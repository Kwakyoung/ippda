package com.example.ipdda.order;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.ipdda.pay.IppdaPayActivity;
import com.example.ipdda.pay.TossPayActivity;
import com.google.android.gms.common.internal.service.Common;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    String TAG = "ippda";

    int goods_no;

    int storeNo;
    String cleanedData;
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

        //첫화면에 입다페이 체크
        binding.radioIppdapay.setChecked(true);


        binding.lnTosspay.setOnClickListener(v -> {
            Intent intent = new Intent(this, TossPayActivity.class);
            startActivity(intent);
        });


        //입다페이 현재 잔액조회
        CommonConn conn1 = new CommonConn(this, "member/money");
        conn1.addParamMap("member_no" ,CommonVar.loginInfo.getMember_no());
        conn1.onExcute((isResult, data) -> {

            cleanedData = data.replaceAll("\"", ""); // 더블 쿼테이션 제거
            binding.tvMemberMoney.setText(cleanedData);

        });




        //입다페이 충전하기 눌렀을 때 충천하는 화면으로 전환
        binding.tvCharge.setOnClickListener(v -> {
            Intent intent = new Intent(this , IppdaPayActivity.class);
            startActivity(intent);
        });

        //입다페이 사용하기 눌렀을 때
        binding.tvUseMoney.setOnClickListener(v -> {
            binding.lnIppdapay.getLayoutParams().height = 650;
            binding.lnIppdapay.requestLayout();
            //보유 금액표시
            binding.tvHoldingAmount.setText(cleanedData+" 원");

        });

        //다른 결제 수단 체크
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

                    storeNo = goodsVO.getStore_no();
            binding.recvOrderGoods.setLayoutManager(new LinearLayoutManager(this));
            binding.recvOrderGoods.setAdapter(new OrderAdapter(arrayList));

            int goodsPrice = goodsVO.getGoods_price();
            int SalePercent = goodsVO.getGoods_sale_percent();

            if(goodsVO.getGoods_sale_percent() == 0){
                binding.tvSalePrice.setText("0 원");
                binding.tvPayPrice.setText(goodsVO.getGoods_price()+" 원");
                binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                binding.tvOriginalPrice.setText(goodsVO.getGoods_price()+" 원");

                //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                binding.tvGoodsAmount.setText("-" + goodsVO.getGoods_price()+" 원");
                //입다페이 사용하기 눌렀을 때 (배달비) 표시
                binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

                int HoldingAmount = Integer.parseInt(cleanedData);
                int remaingAmount = HoldingAmount - (goodsVO.getGoods_price() + goodsVO.getStore_delivery_tip());
                binding.tvRemainingAmount.setText(remaingAmount+" 원");
                //결제 눌렀을 때 로직
                OnclickPayment(remaingAmount, HoldingAmount, goodsPrice,  goodsVO.getStore_delivery_tip());
            }else {
                int goodsPayPrice = goodsPrice/(100/SalePercent);
                int goodsSalePrice = goodsPrice-goodsPayPrice;
                binding.tvOriginalPrice.setText(goodsVO.getGoods_price()+" 원");
                binding.tvSalePrice.setText(goodsSalePrice+" 원");
                binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                binding.tvPayPrice.setText(goodsPayPrice+" 원");

                //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                binding.tvGoodsAmount.setText("-" + goodsPayPrice+" 원");
                //입다페이 사용하기 눌렀을 때 (결제 후 남은 금액) 표시
                int HoldingAmount = Integer.parseInt(cleanedData);
                int remaingAmount = HoldingAmount - (goodsSalePrice + goodsVO.getStore_delivery_tip());
                binding.tvRemainingAmount.setText(remaingAmount+" 원");

                //입다페이 사용하기 눌렀을 때 (배달비) 표시
                binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

                //결제 눌렀을 때 로직
                OnclickPayment(remaingAmount, HoldingAmount, goodsPayPrice,  goodsVO.getStore_delivery_tip());
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

    @Override
    protected void onResume() {
        super.onResume();
        //입다페이 현재 잔액조회
            CommonConn conn1 = new CommonConn(this, "member/money");
            conn1.addParamMap("member_no" ,CommonVar.loginInfo.getMember_no());
            conn1.onExcute((isResult, data) -> {
                String cleanedData = data.replaceAll("\"", ""); // 더블 쿼테이션 제거
                binding.tvMemberMoney.setText(cleanedData);
                //보유 금액표시
                binding.tvHoldingAmount.setText(cleanedData+" 원");

                //충전하기 이후 사용하기 안에 데이터값 변경
                goods_no = getIntent().getIntExtra("goods_no", 0);
                Log.d("goods_no", "onCreate: " + goods_no);
                CommonConn conn2 = new CommonConn(this, "goods/goodsboard");
                conn2.addParamMap("goods_no" , goods_no);
                conn2.onExcute((isResult2, data2) -> {
                    ArrayList<GoodsVO> arrayList = new Gson().fromJson(data2, new TypeToken<ArrayList<GoodsVO>>() {}.getType());
                    GoodsVO goodsVO = arrayList.get(0);

                    binding.recvOrderGoods.setLayoutManager(new LinearLayoutManager(this));
                    binding.recvOrderGoods.setAdapter(new OrderAdapter(arrayList));

                    int goodsPrice = goodsVO.getGoods_price();
                    int SalePercent = goodsVO.getGoods_sale_percent();

                    if(goodsVO.getGoods_sale_percent() == 0){
                        binding.tvSalePrice.setText("0 원");
                        binding.tvPayPrice.setText(goodsPrice+" 원");
                        binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                        binding.tvOriginalPrice.setText(goodsPrice+" 원");

                        //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                        binding.tvGoodsAmount.setText("-" + goodsVO.getGoods_price()+" 원");

                        //보유금액
                        int HoldingAmount = Integer.parseInt(cleanedData);
                        int remaingAmount = HoldingAmount - (goodsVO.getGoods_price() + goodsVO.getStore_delivery_tip());
                        binding.tvRemainingAmount.setText(remaingAmount+" 원");

                        //입다페이 사용하기 눌렀을 때 (배달비) 표시
                        binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

//                        결제 눌렀을 때 로직
                        OnclickPayment(remaingAmount, HoldingAmount, goodsPrice,  goodsVO.getStore_delivery_tip());

                    }else {
                        int goodsPayPrice = goodsPrice/(100/SalePercent);
                        int goodsSalePrice = goodsPrice-goodsPayPrice;
                        binding.tvOriginalPrice.setText(goodsPrice+" 원");
                        binding.tvSalePrice.setText(goodsSalePrice+" 원");
                        binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                        binding.tvPayPrice.setText(goodsPayPrice+" 원");

                        //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                        binding.tvGoodsAmount.setText("-" + goodsPayPrice+" 원");
                        //입다페이 사용하기 눌렀을 때 (결제 후 남은 금액) 표시
                        int HoldingAmount = Integer.parseInt(cleanedData);
                        int remaingAmount = HoldingAmount - (goodsSalePrice + goodsVO.getStore_delivery_tip());
                        binding.tvRemainingAmount.setText(remaingAmount+" 원");

                        //입다페이 사용하기 눌렀을 때 (배달비) 표시
                        binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

                        //                        결제 눌렀을 때 로직
                        OnclickPayment(remaingAmount, HoldingAmount, goodsPayPrice,  goodsVO.getStore_delivery_tip());
                    }


                });





            });




    }

    private void OnclickPayment(int remaingAmount, int holdingAmount, int goodsPrice, int storeDeliverytip) {


            binding.btnPayment.setOnClickListener(v -> {
                if(holdingAmount >= (goodsPrice + storeDeliverytip)){
                    if(binding.radioIppdapay.isChecked()){
                        //페이 줄어드는 로직
                        CommonConn conn = new CommonConn(this , "member/payment");
                        conn.addParamMap("member_money", remaingAmount);
                        conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                        conn.onExcute((isResult, data) -> {
                            finish();
                        Intent intent = new Intent(this, OrderCompleteActivity.class);
                        intent.putExtra("holdingAmount", goodsPrice+storeDeliverytip);
                        intent.putExtra("goodsPrice" ,goodsPrice);
                        intent.putExtra("storeDeliverytip", storeDeliverytip);
                        startActivity(intent);
                        });

//                        CommonConn orderConn = new CommonConn(this, "order/ing");
//                        orderConn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
//                        orderConn.addParamMap("goods_no", goods_no);
//                        orderConn.addParamMap("store_no",  storeNo);


                    }else {
                        Toast.makeText(this, "결제 수단을 클릭해주세요", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this, "잔액이 부족합니다 충전해주세요", Toast.LENGTH_SHORT).show();
                }



            });


    }




}