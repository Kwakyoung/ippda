package com.example.ipdda.goodslist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsListBinding;
import com.example.ipdda.databinding.ItemGoodsSubCategoryBinding;
import com.example.ipdda.databinding.ItemHomeRecommendRecvBinding;
import com.example.ipdda.goodsboard.GoodsBoardActivity;
import com.example.ipdda.home.GoodsVO;

import java.util.ArrayList;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.ViewHolder> {

    int key;

    ItemGoodsListBinding binding;

    ArrayList<GoodsVO> list;

    Context context;

    GoodsListFragment goodsListFragment;

    public GoodsListAdapter(ArrayList<GoodsVO> list, Context context) {
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

        h.binding.tvStoreName1.setText(list.get(i).getStore_name()+"");
        h.binding.tvGoodsPrice1.setText(list.get(i).getGoods_price()+"");

        h.binding.tvStoreName2.setText(list.get(i).getStore_name()+"");
        h.binding.tvGoodsPrice2.setText(list.get(i).getGoods_price()+"");

        h.binding.imgvGoods1.setOnClickListener(v -> {

        });


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
