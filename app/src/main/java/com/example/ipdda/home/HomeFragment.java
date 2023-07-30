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


import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.recvGoodsRecommendCategory.setAdapter(new HomeGoodsRecommendCategoryAdapter(GetGoodsCategoryList(), getContext()));
        binding.recvGoodsRecommendCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.recvGoodsRecommend.setAdapter(new HomeGoodsRecommendAdapter(GetGoodsRecommendList(), getContext()));
        binding.recvGoodsRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.recvStyleRecommendCategory.setAdapter(new HomeStyleRecommendCategoryAdapter(GetStyleCategoryList(), getContext()));
        binding.recvStyleRecommendCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL , false));

        binding.recvStyleRecommend.setAdapter(new HomeStyleRecommendAdapter(GetStyleRecommendList(), getContext()));
        binding.recvStyleRecommend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.imgvDelivery.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            DeliveryFragment deliveryFragment = new DeliveryFragment();
            transaction.replace(R.id.container , deliveryFragment);
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

    public ArrayList<HomeGoodsRecommendDTO> GetGoodsRecommendList(){
        ArrayList<HomeGoodsRecommendDTO> list = new ArrayList<>();
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));

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


    public ArrayList<HomeGoodsRecommendDTO> GetStyleRecommendList(){
        ArrayList<HomeGoodsRecommendDTO> list = new ArrayList<>();
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));
        list.add(new HomeGoodsRecommendDTO(R.drawable.ic_home, R.drawable.ic_home));

        return list;
    }

}