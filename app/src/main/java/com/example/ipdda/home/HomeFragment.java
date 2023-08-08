package com.example.ipdda.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.FragmentHomeBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.packaging.PackagingFragment;
import com.example.ipdda.search.SearchFragment;
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
            transaction.commit();

        });

        binding.imgvPackaging.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            PackagingFragment packagingFragment = new PackagingFragment();
            transaction.replace(R.id.container , packagingFragment);
            transaction.commit();

        });




        return binding.getRoot();
    }



    public ArrayList<HomeGoodsRecommendCategoryDTO> GetGoodsCategoryList(){
        ArrayList<HomeGoodsRecommendCategoryDTO> list = new ArrayList<>();
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.clothes_top, "상의"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "아우터"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "하의"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "원피스"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "스커트"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "신발"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "가방"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "악세사리"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "양말"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "시계"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "모자"));
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
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "캐쥬얼"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "스트릿"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "댄디"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "아메카지"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "고프코어"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "스포츠"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "로맨틱"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "걸리쉬"));
        list.add(new HomeGoodsRecommendCategoryDTO(R.drawable.img_setting, "시크"));


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
        conn.addParamMap("GOODS_MIDDLE_CATEGORY", i);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            HomeGoodsRecommendAdapter adapter = new HomeGoodsRecommendAdapter(arrayList, getContext());

            binding.recvGoodsRecommend.setAdapter(adapter);
            binding.recvGoodsRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });
    }

    public void StyleConn(int i){
        CommonConn conn = new CommonConn(getContext(), "goods/stylelist");
        conn.addParamMap("GOODS_STYLE", i);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            HomeGoodsRecommendAdapter adapter = new HomeGoodsRecommendAdapter(arrayList, getContext());
            binding.recvStyleRecommend.setAdapter(adapter);
            binding.recvStyleRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        });
    }



}