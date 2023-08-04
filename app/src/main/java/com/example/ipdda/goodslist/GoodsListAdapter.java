package com.example.ipdda.goodslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsListBinding;
import com.example.ipdda.databinding.ItemGoodsSubCategoryBinding;

import java.util.ArrayList;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.ViewHolder> {

    int key;

    ItemGoodsListBinding binding;

    ArrayList<GoodsListDTO> list;

    Context context;

    public GoodsListAdapter(ArrayList<GoodsListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GoodsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsListBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsListAdapter.ViewHolder h, int i) {
        h.binding.imgvGoods1.setImageResource(list.get(i).getImgGoodsList1());
        h.binding.imgvGoods2.setImageResource(list.get(i).getImgGoodsList2());



        h.binding.tvStoreName1.setText(list.get(i).getStoreName1());
        h.binding.tvStoreName2.setText(list.get(i).getStoreName2());
        h.binding.tvGoodsName1.setText(list.get(i).getGoodsName1());
        h.binding.tvGoodsName2.setText(list.get(i).getGoodsName2());
        h.binding.tvGoodsPrice1.setText(list.get(i).getGoodsPrice1()+"원");
        h.binding.tvGoodsPrice2.setText(list.get(i).getGoodsPrice1()+"원");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsListBinding binding;


        public ViewHolder(@NonNull ItemGoodsListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }



}
