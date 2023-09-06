package com.example.ipdda.goodsboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityGoodsBoardBinding;
import com.example.ipdda.databinding.ActivityGoodsboardBuyBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.order.OrderActivity;
import com.example.ipdda.pay.TossPayActivity;
import com.example.ipdda.order.OrderActivity;
import com.example.ipdda.profile.SubActivity;
import com.example.ipdda.review.ReviewActivity;
import com.example.ipdda.review.ReviewVO;
import com.example.ipdda.search.SearchFragment;
import com.google.android.gms.common.internal.service.Common;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class GoodsBoardActivity extends AppCompatActivity {

    Dialog write_dialog;
    ActivityGoodsBoardBinding binding;
    ActivityGoodsboardBuyBinding dialogBinding;
    int totalPrice = 0, totalCnt = 0;
    int goods_no, goodsPrice, goods_sale_price, store_no;


    static String select_size;

    ArrayList<GoodsVO> lst;
    ArrayList<GoodsBoardBuyCheckDTO> getBuyCheck = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoodsBoardBinding.inflate(getLayoutInflater());




        //리뷰 리사이클러


        binding.imgvHome.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        //리뷰작성버튼
        binding.btnReview.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReviewActivity.class);
            intent.putExtra("goods_no", goods_no);
            intent.putExtra("store_no", store_no);
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

        //리뷰 갯수
        CommonConn reviewconn = new CommonConn(this, "review/count");
        reviewconn.addParamMap("goods_no", goods_no);
        reviewconn.onExcute((isResult, data) -> {
            binding.tvReviewCnt1.setText(data+"");
            binding.tvReviewCnt.setText(data+"");
        });

        //평점 평균
        CommonConn ratingconn = new CommonConn(this, "review/rating");
        ratingconn.addParamMap("goods_no", goods_no);
        ratingconn.onExcute((isResult, data) -> {
            binding.tvRatingCnt.setText(data+"");
        });



        Log.d("goods_no", "onCreate: " + goods_no);
        CommonConn conn = new CommonConn(this, "goods/goodsboard");
        conn.addParamMap("goods_no", goods_no);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>() {
            }.getType());
            GoodsVO goodsVO = arrayList.get(0);

            store_no = goodsVO.getStore_no();

            String goodsName = goodsVO.getGoods_name();
            goodsPrice = goodsVO.getGoods_price();
            int SalePercent = goodsVO.getGoods_sale_percent();
            String storeName = goodsVO.getStore_name() + "";
            String goodsContext = goodsVO.getGoods_info() + "";
            goods_sale_price = goodsVO.getGoods_sale_price();

            if (SalePercent == 0) {
                binding.tvGoodsPrice.setText(goodsPrice + " 원");
                binding.tvGoodsOriginalPrice.setVisibility(View.GONE);
                binding.tvOriginalPrice.setVisibility(View.GONE);
                binding.tvSalePercent.setVisibility(View.GONE);
                binding.tvSale.setVisibility(View.GONE);
                binding.lnOrignalPrice.setVisibility(View.GONE);
            } else {
                binding.tvGoodsPrice.setText(goods_sale_price + " 원");
                binding.tvGoodsOriginalPrice.setText(goodsPrice + " 원");

            }


            binding.btnBuy.setOnClickListener(v -> {
                showDialog_buy();
            });

            binding.tvStoreName.setText(storeName);

            binding.tvGoodsName.setText(goodsName);
            binding.tvGoodsContext.setText(goodsContext);
            binding.tvSalePercent.setText(SalePercent + "");
            binding.tvDeliveryTip.setText(goodsVO.getStore_delivery_tip() + " 원");


            String mainImageUrl = goodsVO.getGoods_main_image(); // 이미지의 실제 URL을 입력해주세요
            String subImageUrl = goodsVO.getGoods_sub_image();

            Picasso.get()
                    .load(mainImageUrl)
                    .into(binding.imgvMainGoods);

            Picasso.get()
                    .load(subImageUrl)
                    .into(binding.imgvSubGoods);

        });

        binding.imgvLike.setOnClickListener(v -> {
            //
            if (lst.size() == 0 || lst.get(0).getGoods_no() == 0) {
                CommonConn conn3 = new CommonConn(this, "goods_like/add");
                conn3.addParamMap("goods_no", goods_no);
                conn3.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                conn3.onExcute((isResult, data) -> {
                    selectLike();
                });
                Toast.makeText(this, "찜목록에 추가되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                CommonConn conn2 = new CommonConn(this, "goods_like/delete");
                conn2.addParamMap("goods_no", goods_no);
                conn2.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                conn2.onExcute((isResult, data) -> {
                    selectLike();
                });
            }
        });


//        //리뷰 불러오기
        CommonConn reviewConn = new CommonConn(this, "review/list");
        reviewConn.addParamMap("goods_no", goods_no);
        reviewConn.onExcute((isResult, data) -> {
            ArrayList<ReviewVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<ReviewVO>>() {
            }.getType());

            binding.recvReview.setAdapter(new GoodsBoardReviewAdapter(list, this));
            binding.recvReview.setLayoutManager(new LinearLayoutManager(this));
        });

        setContentView(binding.getRoot());
    }


    public void showDialog_buy() {
        write_dialog = new Dialog(this);
        Window window = write_dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); // 다이얼로그 크기 조절
        window.setGravity(Gravity.BOTTOM);

        dialogBinding = ActivityGoodsboardBuyBinding.inflate(write_dialog.getLayoutInflater());
        write_dialog.setContentView(dialogBinding.getRoot());

        dialogBinding.btnBuy.setOnClickListener(v -> {
            if (getBuyCheck.size() == 0) {
                Toast.makeText(this, "상품을 선택해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("goods_no", goods_no);
                intent.putExtra("goodsPrice", totalPrice);
                intent.putExtra("storeNo", store_no);


                intent.putParcelableArrayListExtra("getBuyCheck", (ArrayList<? extends Parcelable>) getBuyCheck);
                startActivity(intent);

            }
        });

        size_click(dialogBinding.btn2XS, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btnXS, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btnS, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btnM, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btnL, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btnXL, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btn2XL, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btn3XL, dialogBinding.btnSelectSize, dialogBinding.linSize);
        size_click(dialogBinding.btnFree, dialogBinding.btnSelectSize, dialogBinding.linSize);

        size(dialogBinding.btn2XS);
        size(dialogBinding.btnXS);
        size(dialogBinding.btnS);
        size(dialogBinding.btnM);
        size(dialogBinding.btnL);
        size(dialogBinding.btnXL);
        size(dialogBinding.btn2XL);
        size(dialogBinding.btn3XL);
        size(dialogBinding.btnFree);

        dialogBinding.btnSelectSize.setOnClickListener(v -> {
            if (dialogBinding.linSize.getVisibility() == View.GONE) {
                dialogBinding.btnSelectSize.setText("사이즈");
                dialogBinding.linSize.setVisibility(View.VISIBLE);
                dialogBinding.recvColor.setVisibility(View.GONE);
            } else {
                dialogBinding.linSize.setVisibility(View.GONE);
                dialogBinding.recvColor.setVisibility(View.GONE);
            }

        });

        dialogBinding.btnSelectColor.setOnClickListener(v -> {
            if (!dialogBinding.btnSelectSize.getText().equals("사이즈")) {
                if (dialogBinding.recvColor.getVisibility() == View.GONE) {
                    dialogBinding.btnSelectColor.setText("색상");
                    dialogBinding.recvColor.setVisibility(View.VISIBLE);
                    dialogBinding.linSize.setVisibility(View.GONE);
                    color();
                } else {
                    dialogBinding.recvColor.setVisibility(View.GONE);
                    dialogBinding.linSize.setVisibility(View.GONE);
                }
            } else {
                Toast.makeText(this, "사이즈를 먼저 선택해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
        int totalGoods = 0;
        if (getBuyCheck != null) {
            for (int i = 0; i < getBuyCheck.size(); i++) {
                totalGoods += getBuyCheck.get(i).getCheck_goods_cnt();
            }
            dialogBinding.tvTotalGoods.setText("상품 " + totalGoods + "개");
        } else {
            dialogBinding.tvTotalGoods.setText("상품 0개");
        }

        //calcTotalPrice();
        write_dialog.show(); // 다이얼로그 띄우기
    }

    // CheckAdapter 수량 * 가격 .
    //totalPrice 에 누적
    public void calcTotalPrice(ArrayList<GoodsBoardBuyCheckDTO> list) {
        if (list != null) {
            totalCnt = 0;
            totalPrice = 0;
            for (int i = 0; i < list.size(); i++) {
                totalCnt += list.get(i).getCheck_goods_cnt();
            }
            dialogBinding.tvTotalGoods.setText("상품 " + totalCnt + "개");
            for (int i = 0; i < list.size(); i++) {
                totalPrice += list.get(i).getCheck_goods_price() * list.get(i).getCheck_goods_cnt();

            }
            dialogBinding.tvTotalPrice.setText(totalPrice + "원");
        }

    }


    public void size(Button btn) {
        CommonConn conn = new CommonConn(this, "goods_option/check_size");
        conn.addParamMap("goods_no", goods_no);
        conn.addParamMap("goods_size", btn.getText().toString());
        conn.onExcute(((isResult, data) -> {
            ArrayList<Goods_optionVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<Goods_optionVO>>() {
            }.getType());
            btn.setText(btn.getText());
            if ((list.size()) == 0) {
                btn.setVisibility(View.GONE);
            }

        }));
    }

    public void size_click(Button btn, Button select, LinearLayout ln) {
        btn.setOnClickListener(v -> {
            String sizeText = btn.getText().toString();
            select.setText(sizeText);
            ln.setVisibility(View.GONE);

            switch (sizeText) {
                case "2XS":
                case "XS":
                case "S":
                case "M":
                case "L":
                case "XL":
                case "2XL":
                case "3XL":
                case "FREE":
                    select_size = sizeText;
                    break;
                default:
                    // 다른 사이즈에 대한 처리
                    break;
            }
        });

    }

    public void color() {
        CommonConn conn = new CommonConn(this, "goods_option/check_size");
        conn.addParamMap("goods_no", goods_no);
        conn.addParamMap("goods_size", select_size);
        conn.onExcute((isResult, data) -> {
            Log.d("ServerResponse", "isResult: " + isResult + ", data: " + data);
            ArrayList<Goods_optionVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<Goods_optionVO>>() {
            }.getType());
            // 어댑터 데이터 업데이트


            dialogBinding.recvColor.setAdapter(new GoodsBoardbuyAdapter(this, list, dialogBinding, getBuyCheck, goods_sale_price));
            dialogBinding.recvColor.setLayoutManager(new LinearLayoutManager(this));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void selectLike() {
        lst = new ArrayList<>();
        CommonConn conn1 = new CommonConn(this, "goods_like/list");
        conn1.addParamMap("goods_no", goods_no);
        conn1.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
        conn1.onExcute((isResult, data) -> {
            lst = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>() {}.getType());
            if (lst.size() == 0) {
                binding.imgvLike.setImageResource(R.drawable.ic_like_blank);
            } else {
                binding.imgvLike.setImageResource(R.drawable.ic_like_green);
            }
        });
    }

}