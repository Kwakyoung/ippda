package com.example.ipdda.search;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemSearchHistoryBinding;
import com.example.ipdda.databinding.ItemSearchListBinding;
import com.example.ipdda.databinding.ItemSubRecvBinding;
import com.example.ipdda.goodsboard.GoodsBoardActivity;
import com.example.ipdda.home.GoodsVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchListAdapter  extends RecyclerView.Adapter<SearchListAdapter.ViewHolder>{

    ArrayList<GoodsVO> list;
    Context context;

    public SearchListAdapter(ArrayList<GoodsVO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchListBinding binding  = ItemSearchListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new SearchListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapter.ViewHolder h, int i) {
        Picasso.get()
                .load(list.get(i).getGoods_main_image())
                .into(h.binding.imgGoods);
        h.binding.storeName.setText(list.get(i).getStore_name());
        h.binding.goodsName.setText(list.get(i).getGoods_name());
        if (list.get(i).getGoods_sale_percent() != 0) {
            h.binding.price.setText(list.get(i).getGoods_sale_price()+"");
            h.binding.goodsSale.setText(list.get(i).getGoods_sale_percent()+"% 할인");
        }else{
            h.binding.price.setText(list.get(i).getGoods_price()+"");
            h.binding.goodsSale.setVisibility(View.GONE);
        }
        h.binding.container.setOnClickListener(v -> {
            Intent intent = new Intent(context, GoodsBoardActivity.class);
            intent.putExtra("goods_no", list.get(i).getGoods_no());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSearchListBinding binding;

        public ViewHolder(@NonNull ItemSearchListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

