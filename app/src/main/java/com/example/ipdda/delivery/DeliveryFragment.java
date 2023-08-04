package com.example.ipdda.delivery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentDeliveryBinding;
import com.example.ipdda.home.goodslist.GoodsListFragment;
import com.example.ipdda.goodslist.GoodsListFragment;


import java.util.ArrayList;


public class DeliveryFragment extends Fragment {



    FragmentDeliveryBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeliveryBinding.inflate(inflater, container, false);

        binding.recvDeliveryTopCategory.setAdapter(new DeliveryTopCategoryAdapter(GetTopCategoryList(),getContext()));
        binding.recvDeliveryTopCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.recvDeliveryGoodsCategory.setAdapter(new DeliveryGoodsCategoryAdapter(GetGoodsCategoryList(), getContext()));
        binding.recvDeliveryGoodsCategory.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvDeliveryStoreCategory.setAdapter(new DeliveryStoreCategoryAdapter(GetStoreCategoryList(), getContext()));
        binding.recvDeliveryStoreCategory.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.tvDelivery.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            GoodsListFragment goodsListFragment = new GoodsListFragment();
            transaction.replace(R.id.container , goodsListFragment);
            transaction.commit();
        });


        return binding.getRoot();
    }


    public ArrayList<DeliveryTopCategoryDTO> GetTopCategoryList(){
        ArrayList<DeliveryTopCategoryDTO> list = new ArrayList<>();
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        list.add(new DeliveryTopCategoryDTO(R.drawable.ic_home));
        return list;
    }

    public ArrayList<DeliveryGoodsCategoryDTO> GetGoodsCategoryList(){
        ArrayList<DeliveryGoodsCategoryDTO> list = new ArrayList<>();
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.ic_home, R.drawable.ic_home , R.drawable.ic_home, R.drawable.ic_home , "상의" , "아우터", "하의", "원피스"));
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.ic_home, R.drawable.ic_home , R.drawable.ic_home, R.drawable.ic_home , "스커트" , "신발", "가방", "악세사리"));
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.ic_home, R.drawable.ic_home , R.drawable.ic_home, R.drawable.ic_home , "양말" , "시계", "", ""));
        return list;
    }


    public ArrayList<DeliveryStoreCategoryDTO> GetStoreCategoryList(){
        ArrayList<DeliveryStoreCategoryDTO> list = new ArrayList<>();
        list.add(new DeliveryStoreCategoryDTO(R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home,3000,20,10,"입다화정점"));
        list.add(new DeliveryStoreCategoryDTO(R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home,3000,20,10,"입다화정점"));
        list.add(new DeliveryStoreCategoryDTO(R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home,3000,20,10,"입다화정점"));
        list.add(new DeliveryStoreCategoryDTO(R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home,3000,20,10,"입다화정점"));
        list.add(new DeliveryStoreCategoryDTO(R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home,3000,20,10,"입다화정점"));
        return list;
    }



}