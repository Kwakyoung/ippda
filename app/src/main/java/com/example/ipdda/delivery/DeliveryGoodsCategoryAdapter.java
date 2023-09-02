package com.example.ipdda.delivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemDeliveryGoodsCategoryBinding;


import java.util.ArrayList;

public class DeliveryGoodsCategoryAdapter extends RecyclerView.Adapter<DeliveryGoodsCategoryAdapter.ViewHolder>{
    Bundle bundle;

    ItemDeliveryGoodsCategoryBinding binding;

    ArrayList<DeliveryGoodsCategoryDTO> list;

    Context context;

    DeliveryFragment deliveryFragment;

    public DeliveryGoodsCategoryAdapter(ArrayList<DeliveryGoodsCategoryDTO> list, Context context, DeliveryFragment deliveryFragment) {
        this.list = list;
        this.context = context;
        this.deliveryFragment = deliveryFragment;
    }

    @NonNull
    @Override
    public DeliveryGoodsCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDeliveryGoodsCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryGoodsCategoryAdapter.ViewHolder h, int i) {


        //list 이미지가 없어 0으로 처리할 때 안보이게
        if(list.get(i).getImgRes1() == 0){
            h.binding.imgvGoodsCategory1.setVisibility(View.GONE);
        }else if (list.get(i).getImgRes2() == 0){
            h.binding.imgvGoodsCategory2.setVisibility(View.GONE);
        }else if (list.get(i).getImgRes3() == 0){
            h.binding.imgvGoodsCategory3.setVisibility(View.GONE);
        }else if (list.get(i).getImgRes4() == 0){
            h.binding.imgvGoodsCategory4.setVisibility(View.GONE);
        }

        h.binding.imgvGoodsCategory1.setImageResource(list.get(i).getImgRes1());
        h.binding.imgvGoodsCategory2.setImageResource(list.get(i).getImgRes2());
        h.binding.imgvGoodsCategory3.setImageResource(list.get(i).getImgRes3());
        h.binding.imgvGoodsCategory4.setImageResource(list.get(i).getImgRes4());


        h.binding.tvGoodsCategory1.setText(list.get(i).getCategoryName1()+"");
        h.binding.tvGoodsCategory2.setText(list.get(i).getCategoryName2()+"");
        h.binding.tvGoodsCategory3.setText(list.get(i).getCategoryName3()+"");
        h.binding.tvGoodsCategory4.setText(list.get(i).getCategoryName4()+"");


        h.binding.imgvGoodsCategory1.setOnClickListener(v -> {
            deliveryFragment.onClickCategory(list.get(i).getCategoryName1()+"");
        });

        h.binding.imgvGoodsCategory2.setOnClickListener(v -> {
            deliveryFragment.onClickCategory(list.get(i).getCategoryName2()+"");
        });

        h.binding.imgvGoodsCategory3.setOnClickListener(v -> {
            deliveryFragment.onClickCategory(list.get(i).getCategoryName3()+"");
        });

        h.binding.imgvGoodsCategory4.setOnClickListener(v -> {
            deliveryFragment.onClickCategory(list.get(i).getCategoryName4()+"");
        });





    }

    @Override
    public int getItemCount() {
        
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemDeliveryGoodsCategoryBinding binding;


        public ViewHolder(@NonNull ItemDeliveryGoodsCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }




}
