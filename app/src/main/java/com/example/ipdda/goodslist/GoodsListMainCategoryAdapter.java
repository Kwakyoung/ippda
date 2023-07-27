package com.example.ipdda.goodslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsMainCategoryBinding;
import com.example.ipdda.delivery.DeliveryStoreCategoryAdapter;

import java.util.ArrayList;

public class GoodsListMainCategoryAdapter extends RecyclerView.Adapter<GoodsListMainCategoryAdapter.ViewHolder> {

    ItemGoodsMainCategoryBinding binding;

    ArrayList<GoodsListMainCategoryDTO> list;

    Context context;

    public GoodsListMainCategoryAdapter(ArrayList<GoodsListMainCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
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
}
