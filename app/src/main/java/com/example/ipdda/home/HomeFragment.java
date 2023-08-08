package com.example.ipdda.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentHomeBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.packaging.PackagingFragment;
import com.example.ipdda.search.SearchFragment;


import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;


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
        return list;
    }

    public ArrayList<HomeGoodsRecommendDTO> GetGoodsRecommendList(HomeGoodsRecommendCategoryDTO homeGoodsRecommendCategoryDTO){
        ArrayList<HomeGoodsRecommendDTO> list = new ArrayList<>();
        if (homeGoodsRecommendCategoryDTO.getTv_category().equals("상의")){
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));

        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("아우터")) {
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));

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
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
            list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));

        } else if (homeGoodsRecommendCategoryDTO.getTv_category().equals("스트릿")) {
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));
            list.add(new HomeGoodsRecommendDTO(R.drawable.img_setting, R.drawable.img_setting));

        }


        return list;
    }




    public void onClickGoods(HomeGoodsRecommendCategoryDTO homeGoodsRecommendCategoryDTO){
        ArrayList<HomeGoodsRecommendDTO> list = GetGoodsRecommendList(homeGoodsRecommendCategoryDTO);
        binding.recvGoodsRecommend.setAdapter(new HomeGoodsRecommendAdapter(list, getContext()));
        binding.recvGoodsRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    public void onClickStyle(HomeGoodsRecommendCategoryDTO homeGoodsRecommendCategoryDTO){
        ArrayList<HomeGoodsRecommendDTO> list = GetStyleRecommendList(homeGoodsRecommendCategoryDTO);
        binding.recvStyleRecommend.setAdapter(new HomeStyleRecommendAdapter(list, getContext()));
        binding.recvStyleRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }



}