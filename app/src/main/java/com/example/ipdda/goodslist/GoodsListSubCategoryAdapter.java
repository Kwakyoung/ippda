package com.example.ipdda.goodslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsSubCategoryBinding;

import java.util.ArrayList;

public class GoodsListSubCategoryAdapter extends RecyclerView.Adapter<GoodsListSubCategoryAdapter.ViewHolder> {

    ItemGoodsSubCategoryBinding binding;

    ArrayList<GoodsListSubCategoryDTO> list;

    Context context;

    public GoodsListSubCategoryAdapter(ArrayList<GoodsListSubCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GoodsListSubCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsSubCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsListSubCategoryAdapter.ViewHolder h, int i) {
        h.binding.tvSubCategory.setText(list.get(i).getGoodsSubCategory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsSubCategoryBinding binding;


        public ViewHolder(@NonNull ItemGoodsSubCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }



}
