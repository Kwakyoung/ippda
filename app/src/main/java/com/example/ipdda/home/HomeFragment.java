package com.example.ipdda.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.FragmentHomeBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.member.MemberVO;
import com.example.ipdda.packaging.PackagingFragment;
import com.example.ipdda.search.SearchFragment;
import com.google.android.gms.common.internal.service.Common;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

  //  TextView lastClickedMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);



        binding.recvGoodsRecommendCategory.setAdapter(new HomeGoodsRecommendCategoryAdapter(GetGoodsCategoryList(), getContext() , this));
        binding.recvGoodsRecommendCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.recvStyleRecommendCategory.setAdapter(new HomeStyleRecommendCategoryAdapter(GetStyleCategoryList(), getContext(), this));
        binding.recvStyleRecommendCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL , false));


        binding.lnSearch.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            transaction.replace(R.id.container , searchFragment);
            transaction.commit();
        });


        binding.imgvDelivery.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            DeliveryFragment deliveryFragment = new DeliveryFragment();
            transaction.replace(R.id.container , deliveryFragment);
            transaction.addToBackStack(null); // 백 스택에 추가
            transaction.commit();

        });

        binding.imgvPackaging.setOnClickListener(v -> {
//            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//            PackagingFragment packagingFragment = new PackagingFragment();
//            transaction.replace(R.id.container , packagingFragment);
//            transaction.addToBackStack(null); // 백 스택에 추가
//            transaction.commit();
            Toast.makeText(getContext(), "서비스 준비중입니다.", Toast.LENGTH_SHORT).show();
        });

        binding.relativeLocation.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LocationActivity.class);
            startActivity(intent);
        });



            //유저 현재주소 조회
            CommonConn conn = new CommonConn(getContext(), "member/address");
            conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
            conn.onExcute((isResult, data) -> {
                String cleanedData = data.replaceAll("\"", ""); // 더블 쿼테이션 제거
                binding.tvLocation.setText(cleanedData);
            });

        return binding.getRoot();
    }



    public ArrayList<HomeGoodsRecommendCategoryDTO> GetGoodsCategoryList(){
        ArrayList<HomeGoodsRecommendCategoryDTO> list = new ArrayList<>();
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.top1, "상의"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.outer, "아우터"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.pants, "하의"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.onepeecs, "원피스"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.skirt, "스커트"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.shoes, "신발"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.backpack, "가방"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.accessory, "악세사리"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.socks, "양말"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.watch, "시계"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.cap, "모자"));
        return list;
    }

    public ArrayList<HomeGoodsRecommendDTO> GetGoodsRecommendList(HomeGoodsRecommendCategoryDTO homeGoodsRecommendCategoryDTO){
        ArrayList<HomeGoodsRecommendDTO> list = new ArrayList<>();
        if (homeGoodsRecommendCategoryDTO.getTv_category().equals("상의")){
            CategoryConn(1);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("아우터")) {
            CategoryConn(2);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("하의")) {
            CategoryConn(3);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("원피스")) {
            CategoryConn(4);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("스커트")) {
            CategoryConn(5);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("신발")) {
            CategoryConn(6);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("가방")) {
            CategoryConn(7);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("악세사리")) {
            CategoryConn(8);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("양말")) {
            CategoryConn(9);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("시계")) {
            CategoryConn(10);
        }else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("모자")) {
            CategoryConn(11);
        }

        return list;
    }

    public ArrayList<HomeGoodsRecommendCategoryDTO> GetStyleCategoryList(){
        ArrayList<HomeGoodsRecommendCategoryDTO> list = new ArrayList<>();
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.casual, "캐쥬얼"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.street, "스트릿"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.dandy1, "댄디"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.amecaji, "아메카지"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.core, "고프코어"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.sports, "스포츠"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.romentic, "로맨틱"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.girl, "걸리쉬"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.sic, "시크"));


        return list;
    }


    public ArrayList<HomeGoodsRecommendDTO> GetStyleRecommendList(HomeGoodsRecommendCategoryDTO homeGoodsRecommendCategoryDTO){
        ArrayList<HomeGoodsRecommendDTO> list = new ArrayList<>();
        if (homeGoodsRecommendCategoryDTO.getTv_category().equals("캐쥬얼")){
            StyleConn(201);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("스트릿")) {
            StyleConn(202);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("댄디")) {
            StyleConn(203);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("아메카지")) {
            StyleConn(204);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("고프코어")) {
            StyleConn(205);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("스포츠")) {
            StyleConn(206);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("로맨틱")) {
            StyleConn(207);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("걸리쉬")) {
            StyleConn(208);
        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("시크")) {
            StyleConn(209);
        }

        return list;
    }



    public void CategoryConn(int i){
        CommonConn conn = new CommonConn(getContext(), "goods/categorylist");
        conn.addParamMap("goods_middle_category", i);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            HomeGoodsRecommendAdapter adapter = new HomeGoodsRecommendAdapter(arrayList, getContext());

            binding.recvGoodsRecommend.setAdapter(adapter);
            binding.recvGoodsRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });
    }

    public void StyleConn(int i){
        CommonConn conn = new CommonConn(getContext(), "goods/stylelist");
        conn.addParamMap("goods_style", i);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            HomeGoodsRecommendAdapter adapter = new HomeGoodsRecommendAdapter(arrayList, getContext());
            binding.recvStyleRecommend.setAdapter(adapter);
            binding.recvStyleRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });
    }

    private long backKeyPressedTime = 0;
    public void handleBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(getContext(), "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2초 이내에 뒤로가기 버튼을 한번 더 클릭시 finish()(앱 종료)
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
           if (getActivity() != null){
               getActivity().finish();
           }
            System.runFinalization();
            System.exit(0);
        }

    }


}