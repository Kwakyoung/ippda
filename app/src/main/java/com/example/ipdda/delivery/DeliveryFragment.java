package com.example.ipdda.delivery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentDeliveryBinding;
import com.example.ipdda.home.HomeGoodsRecommendCategoryDTO;

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

        binding.recvDeliveryStoreCategory.setAdapter(new DeliveryStoreCategoryAdapter());

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
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.ic_home, R.drawable.ic_home , R.drawable.ic_home, R.drawable.ic_home , "상의" , "아우터", "하의", "원피스"));
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.ic_home, R.drawable.ic_home , R.drawable.ic_home, R.drawable.ic_home , "상의" , "아우터", "하의", ""));
        return list;
    }

}