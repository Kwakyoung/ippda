package com.example.ipdda.goodslist;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsMainCategoryBinding;
import com.example.ipdda.delivery.DeliveryStoreCategoryAdapter;

import java.util.ArrayList;

public class GoodsListMainCategoryAdapter extends RecyclerView.Adapter<GoodsListMainCategoryAdapter.ViewHolder> {


    TextView lastClickedMenu;

    ItemGoodsMainCategoryBinding binding;

    ArrayList<GoodsListMainCategoryDTO> list;

    Context context;

    GoodsListFragment goodsListFragment;

    public GoodsListMainCategoryAdapter(ArrayList<GoodsListMainCategoryDTO> list, Context context, GoodsListFragment goodsListFragment) {
        this.list = list;
        this.context = context;
        this.goodsListFragment = goodsListFragment;
    }


    @NonNull
    @Override
    public GoodsListMainCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsMainCategoryBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsListMainCategoryAdapter.ViewHolder h, int i) {
        h.binding.tvGoodsMainCategory.setText(list.get(i).getGoodsMainCategory());

            if(i == 0){
                goodsListFragment.onClickGoodsList(list.get(0));
            }

        h.binding.tvGoodsMainCategory.setOnClickListener(v -> {
            changeTextColor(h.binding.tvGoodsMainCategory);
            goodsListFragment.onClickGoodsList(list.get(i));

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsMainCategoryBinding binding;


        public ViewHolder(@NonNull ItemGoodsMainCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public void changeTextColor(View view) {
        if (lastClickedMenu != null) {
            lastClickedMenu.setTextColor(Color.WHITE);
            lastClickedMenu.setTextSize(18);
        }
        TextView textView = (TextView) view;
        textView.setTextSize(20);
        textView.setTextColor(Color.rgb(2,254,178));
        lastClickedMenu = textView;
    }


}
