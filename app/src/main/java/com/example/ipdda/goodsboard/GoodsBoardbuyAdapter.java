package com.example.ipdda.goodsboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsboardRecvBinding;
import com.example.ipdda.inventory.InventoryVO;

import java.util.ArrayList;

public class GoodsBoardbuyAdapter extends RecyclerView.Adapter<GoodsBoardbuyAdapter.ViewHolder> {

    ItemGoodsboardRecvBinding binding;

    ArrayList<InventoryVO> list;
    Button btn;
    RecyclerView recv;

    public GoodsBoardbuyAdapter(ArrayList<InventoryVO> list, Button btn, RecyclerView recv) {
        this.list = list;
        this.btn = btn;
        this.recv=recv;
    }

    @NonNull
    @Override
    public GoodsBoardbuyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsboardRecvBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsBoardbuyAdapter.ViewHolder h, int i) {
        h.binding.btnOption.setText(list.get(i).getGoods_color());
        h.binding.btnOption.setOnClickListener(v -> {
            btn.setText(list.get(i).getGoods_color());
            recv.setVisibility(View.GONE);
        });


    }
    public void updateData(ArrayList<InventoryVO> newList) {
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsboardRecvBinding binding;

        public ViewHolder(@NonNull ItemGoodsboardRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
