package com.example.ipdda.packaging;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentPackagingBinding;
import com.example.ipdda.delivery.DeliveryGoodsCategoryAdapter;
import com.example.ipdda.delivery.DeliveryGoodsCategoryDTO;
import com.example.ipdda.delivery.DeliveryStoreCategoryAdapter;
import com.example.ipdda.delivery.DeliveryStoreCategoryDTO;
import com.example.ipdda.delivery.DeliveryTopCategoryAdapter;
import com.example.ipdda.delivery.DeliveryTopCategoryDTO;

import java.util.ArrayList;


public class PackagingFragment extends Fragment {

    FragmentPackagingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPackagingBinding.inflate(inflater, container, false);

        binding.recvDeliveryTopCategory.setAdapter(new DeliveryTopCategoryAdapter(GetTopCategoryList(),getContext()));
        binding.recvDeliveryTopCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

//        binding.recvDeliveryGoodsCategory.setAdapter(new DeliveryGoodsCategoryAdapter(GetGoodsCategoryList(), getContext(), PackagingFragment));
        binding.recvDeliveryGoodsCategory.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvDeliveryStoreCategory.setAdapter(new DeliveryStoreCategoryAdapter(GetStoreCategoryList(), getContext()));
        binding.recvDeliveryStoreCategory.setLayoutManager(new LinearLayoutManager(getContext()));


        return binding.getRoot();
    }

    // 이전 프래그먼트로 이동
    public void handleBackPressed() {
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.popBackStack();
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