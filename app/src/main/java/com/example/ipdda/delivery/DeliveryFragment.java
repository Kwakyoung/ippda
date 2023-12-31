package com.example.ipdda.delivery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.FragmentDeliveryBinding;
import com.example.ipdda.goodslist.GoodsListFragment;
import com.example.ipdda.store.StoreVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;


public class DeliveryFragment extends Fragment {



    FragmentDeliveryBinding binding;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeliveryBinding.inflate(inflater, container, false);

        binding.recvDeliveryGoodsCategory.setAdapter(new DeliveryGoodsCategoryAdapter(GetGoodsCategoryList(), getContext(), this));
        binding.recvDeliveryGoodsCategory.setLayoutManager(new LinearLayoutManager(getContext()));


        CommonConn conn = new CommonConn(getContext(), "store/list");
        conn.onExcute((isResult, data) -> {
            ArrayList<StoreVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<StoreVO>>() {}.getType());


            binding.recvDeliveryStoreCategory.setAdapter(new DeliveryStoreCategoryAdapter(list, getContext()));
            binding.recvDeliveryStoreCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        });




        return binding.getRoot();
    }


    public ArrayList<DeliveryTopCategoryDTO> GetTopCategoryList(){
        ArrayList<DeliveryTopCategoryDTO> list = new ArrayList<>();
        list.add(new DeliveryTopCategoryDTO(R.drawable.test));
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
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.top, R.drawable.outer , R.drawable.pants, R.drawable.onepeecs , "상의" , "아우터", "하의", "원피스"));
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.skirt, R.drawable.shoes , R.drawable.backpack, R.drawable.accessory , "스커트" , "신발", "가방", "악세사리"));
        list.add(new DeliveryGoodsCategoryDTO(R.drawable.socks, R.drawable.watch , R.drawable.cap, 0 , "양말" , "시계", "모자", ""));

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




    public void onClickCategory(String deliveryGoodsCategoryDTO){
        if(deliveryGoodsCategoryDTO.equals("상의")){
            selectedFragment(1);
        } else if (deliveryGoodsCategoryDTO.equals("아우터")) {
            selectedFragment(2);
        } else if (deliveryGoodsCategoryDTO.equals("하의")) {
            selectedFragment(3);
        }else if (deliveryGoodsCategoryDTO.equals("원피스")) {
            selectedFragment(4);
        }else if (deliveryGoodsCategoryDTO.equals("스커트")) {
            selectedFragment(5);
        }else if (deliveryGoodsCategoryDTO.equals("신발")) {
            selectedFragment(6);
        } else if (deliveryGoodsCategoryDTO.equals("가방")) {
            selectedFragment(7);
        }else if (deliveryGoodsCategoryDTO.equals("악세사리")) {
            selectedFragment(8);
        }else if (deliveryGoodsCategoryDTO.equals("양말")) {
            selectedFragment(9);
        }else if (deliveryGoodsCategoryDTO.equals("시계")) {
            selectedFragment(10);
        }else if (deliveryGoodsCategoryDTO.equals("모자")) {
            selectedFragment(11);

        }

    }



    public void selectedFragment(int i){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        GoodsListFragment goodsListFragment = new GoodsListFragment(i);
        transaction.replace(R.id.container, goodsListFragment);
        transaction.addToBackStack(null); // 백 스택에 추가
        transaction.commit();
    }


    // 이전 프래그먼트로 이동
    public void handleBackPressed() {
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.popBackStack();
    }

}