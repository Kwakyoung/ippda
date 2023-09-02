package com.example.ipdda.order;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.goodsboard.GoodsBoardBuyCheckDTO;
import com.example.ipdda.goodsboard.Goods_optionVO;
import com.example.ipdda.home.GoodsOptionVO;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.member.MemberVO;
import com.example.ipdda.pay.IppdaPayActivity;
import com.example.ipdda.pay.TossPayActivity;
import com.example.ipdda.profile.TrackDeliveryActivity;
import com.google.android.gms.common.internal.service.Common;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    String TAG = "ippda";

    int goods_no, storeNo;
    String cleanedData, goods_name;

//    ArrayList<GoodsBoardBuyCheckDTO> getBuyCheck;
    // 기본 생성자 추가
    public OrderActivity() {
    }


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
            ArrayList<GoodsBoardBuyCheckDTO> receivedList = getIntent().getParcelableArrayListExtra("getBuyCheck");
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>() {}.getType());
                    GoodsVO goodsVO = arrayList.get(0);
                    goods_name=goodsVO.getGoods_name();
                    storeNo = goodsVO.getStore_no();
            binding.recvOrderGoods.setLayoutManager(new LinearLayoutManager(this));
            binding.recvOrderGoods.setAdapter(new OrderAdapter(arrayList, receivedList));

            int goodsPrice = goodsVO.getGoods_price();
            int salePercent = goodsVO.getGoods_sale_percent();
            int totalprice=0;
            if (receivedList != null) {
                for (int i = 0; i <receivedList.size(); i++) {
                    totalprice+=(receivedList.get(i).getCheck_goods_price()*receivedList.get(i).getCheck_goods_cnt());
                    //23.08.29 추가 by 수봉  ---------------------------------------------------
                    receivedList.get(i).setMember_no( CommonVar.loginInfo.getMember_no() );
                    receivedList.get(i).setGoods_no( goodsVO.getGoods_no() );
                    receivedList.get(i).setOrder_status( "결제완료" );
                    //-------------------------------------------------------------------------
                }
            }
            int cnt=0;
            for (int i = 0; i < receivedList.size(); i++) {
                cnt=receivedList.get(i).getCheck_goods_cnt();
            }
            int HoldingAmount = Integer.parseInt(cleanedData);
            int remaingAmount = HoldingAmount - (totalprice + goodsVO.getStore_delivery_tip());
            if(salePercent == 0){

                binding.tvSalePrice.setText("0 원");
                binding.tvOriginalPrice.setText((goodsPrice*cnt)+" 원");
                binding.tvPayPrice.setText((totalprice+goodsVO.getStore_delivery_tip())+" 원");
                binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");

                //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                binding.tvGoodsAmount.setText("-" + totalprice+" 원");

                //입다페이 사용하기 눌렀을 때 (배달비) 표시
                binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

                binding.tvRemainingAmount.setText(remaingAmount+" 원");
                //결제 눌렀을 때 로직
                OnclickPayment(remaingAmount, HoldingAmount, goodsPrice,  goodsVO);
            }else {

                binding.tvOriginalPrice.setText((goodsPrice*cnt)+" 원");
                binding.tvPayPrice.setText((totalprice+goodsVO.getStore_delivery_tip())+" 원");
                binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                binding.tvSalePrice.setText((goodsPrice-totalprice)+" 원");


                //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                binding.tvGoodsAmount.setText("-" + totalprice+" 원");
                binding.tvRemainingAmount.setText(remaingAmount+" 원");

                //입다페이 사용하기 눌렀을 때 (배달비) 표시
                binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

                //결제 눌렀을 때 로직
                OnclickPayment(remaingAmount, HoldingAmount, totalprice,  goodsVO);
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
                    ArrayList<GoodsBoardBuyCheckDTO> receivedList = getIntent().getParcelableArrayListExtra("getBuyCheck");

                    binding.recvOrderGoods.setLayoutManager(new LinearLayoutManager(this));
                    binding.recvOrderGoods.setAdapter(new OrderAdapter(arrayList, receivedList));

                    int goodsPrice = goodsVO.getGoods_price();
                    int SalePercent = goodsVO.getGoods_sale_percent();
                    int totalprice=0;
                    if (receivedList != null) {
                        for (int i = 0; i <receivedList.size(); i++) {
                            totalprice+=(receivedList.get(i).getCheck_goods_price()*receivedList.get(i).getCheck_goods_cnt());
                        }
                    }
                    int cnt=0;
                    for (int i = 0; i < receivedList.size(); i++) {
                        cnt=receivedList.get(i).getCheck_goods_cnt();
                    }
                    int HoldingAmount = Integer.parseInt(cleanedData);
                    int remaingAmount = HoldingAmount - (totalprice + goodsVO.getStore_delivery_tip());
                    if(goodsVO.getGoods_sale_percent() == 0){

                        binding.tvSalePrice.setText("0 원");
                        binding.tvPayPrice.setText((totalprice+goodsVO.getStore_delivery_tip())+" 원");
                        binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                        binding.tvOriginalPrice.setText((goodsPrice*cnt)+" 원");
                        //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                        binding.tvGoodsAmount.setText("-" + totalprice+" 원");

                        //결제후 남은 금액 = 잔액 -(상품금액 + 배달비);
                        binding.tvRemainingAmount.setText(remaingAmount+" 원");

                        //입다페이 사용하기 눌렀을 때 (배달비) 표시
                        binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

//                        결제 눌렀을 때 로직
                        OnclickPayment(remaingAmount, HoldingAmount, goodsPrice,  goodsVO);

                    }else {

                        int goodsPayPrice = (SalePercent/100)*goodsPrice;

                        binding.tvOriginalPrice.setText((goodsPrice*cnt)+" 원");
                        binding.tvPayPrice.setText((totalprice+goodsVO.getStore_delivery_tip())+" 원");
                        binding.tvDeliveryTip1.setText(goodsVO.getStore_delivery_tip()+" 원");
                        binding.tvSalePrice.setText((goodsPrice-totalprice)+" 원");

                        //입다페이 사용하기 눌렀을 때 (상품 금액) 표시
                        binding.tvGoodsAmount.setText("-" + totalprice+" 원");
                        //입다페이 사용하기 눌렀을 때 (결제 후 남은 금액) 표시

                        binding.tvRemainingAmount.setText(remaingAmount+" 원");

                        //입다페이 사용하기 눌렀을 때 (배달비) 표시
                        binding.tvDeliveryTip.setText("-" + goodsVO.getStore_delivery_tip()+" 원");

                        //                        결제 눌렀을 때 로직
                        OnclickPayment(remaingAmount, HoldingAmount, goodsPayPrice,  goodsVO);
                    }


                });





            });




    }

    private void OnclickPayment(int remaingAmount, int holdingAmount, int goodsPrice,  GoodsVO goodsVO) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
            binding.btnPayment.setOnClickListener(v -> {
                if( 0 < holdingAmount-(goodsPrice + goodsVO.getStore_delivery_tip())){
                    if(binding.radioIppdapay.isChecked()){
                        ArrayList<GoodsBoardBuyCheckDTO> receivedList = getIntent().getParcelableArrayListExtra("getBuyCheck");

                        int totalprice=0;
                        if (receivedList != null) {
                            CommonConn orderConn = new CommonConn(this, "order_ing/insert");
                            //23.08.29 옵션전체 한번에 저장 요청으로 변경 by 수봉 ----------------------------------------
//                            ArrayList<HashMap<String, Object>> list = new ArrayList< HashMap<String, Object>>();
                            for (int i = 0; i <receivedList.size(); i++) {
                                totalprice+=(receivedList.get(i).getCheck_goods_price()*receivedList.get(i).getCheck_goods_cnt());
//                                HashMap<String, Object> map = new HashMap<String, Object>();
//                                map.put("member_no",  receivedList.get(i).getMember_no());
//                                map.put("goods_no", receivedList.get(i).getGoods_no());
//                                map.put("order_size",  receivedList.get(i).getCheck_goods_size());
//                                map.put("order_cnt",  receivedList.get(i).getCheck_goods_cnt());
//                                map.put("order_address",  CommonVar.loginInfo.getMember_address());
//                                map.put("order_status",  "결제완료");
//                                map.put("order_color",  receivedList.get(i).getCheck_goods_color());
//                                list.add( map);
//                                orderConn.addParamMap("order_list",  map);
                                //---------------------------------------------------------------------------------------
                                int StoreNo = getIntent().getIntExtra("storeNo", 0);
                                int OrderPrice = getIntent().getIntExtra("goodsPrice", 0);
                               orderConn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                                orderConn.addParamMap("goods_no", goods_no);
                                orderConn.addParamMap("order_size",  receivedList.get(i).getCheck_goods_size());
                                orderConn.addParamMap("order_cnt",  receivedList.get(i).getCheck_goods_cnt());
                                orderConn.addParamMap("order_address",  CommonVar.loginInfo.getMember_address()+"");
                                orderConn.addParamMap("order_status",  "결제완료");
                                orderConn.addParamMap("order_color",  receivedList.get(i).getCheck_goods_color());
                                orderConn.addParamMap("store_no", StoreNo);
                                orderConn.addParamMap("order_price", totalprice);
                                orderConn.addParamMap("order_goods_name", goodsVO.getGoods_name());

                                orderConn.onExcute((isResult, data) -> {
                                });
                            }
                        }

                        //페이 줄어드는 로직
                        CommonConn conn = new CommonConn(this , "member/payment");
                        conn.addParamMap("member_money", remaingAmount);
                        conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                        conn.onExcute((isResult, data) -> {

                        });




                        CommonConn conn3 = new CommonConn(this , "goods_option/order");
                        for (int i = 0; i < receivedList.size(); i++) {
                            conn3.addParamMap("goods_cnt", receivedList.get(i).getCheck_goods_cnt());
                            conn3.addParamMap("goods_no", goods_no);
                            conn3.addParamMap("goods_color", receivedList.get(i).getCheck_goods_color());
                            conn3.addParamMap("goods_size", receivedList.get(i).getCheck_goods_size());
                            conn3.onExcute(((isResult, data) -> {}));
                        }

                        finish();

                        makeNotification();

                        Intent intent = new Intent(this, OrderCompleteActivity.class);
                        intent.putExtra("holdingAmount", totalprice+goodsVO.getStore_delivery_tip());
                        intent.putExtra("totalprice" ,totalprice);
                        intent.putExtra("storeDeliverytip",goodsVO.getStore_delivery_tip());
                        startActivity(intent);

                    }else {
                        Toast.makeText(this, "결제 수단을 클릭해주세요", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this, "잔액이 부족합니다 충전해주세요", Toast.LENGTH_SHORT).show();
                }



            });


    }

    public void makeNotification(){
        String chanelID="CHANNEL_ID_NOTIFICATION";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),chanelID);
        builder.setSmallIcon(R.drawable.ippda_logo)
                .setContentTitle("IPPDA")
                .setContentText("주문이 완료되었습니다.")
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Intent intent = new Intent(getApplicationContext(), TrackDeliveryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //        .putExtra("data","Somevalue to be passed here");//이거 데이터 값 넘겨주는거

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(chanelID);
            if (notificationChannel==null){
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(chanelID,"Some description", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        notificationManager.notify(0,builder.build());
    }


}