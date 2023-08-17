package com.example.ipdda.order;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ItemOrderGoodsBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    ArrayList<OrderDTO> list ;
    ItemOrderGoodsBinding binding;

    public OrderAdapter(ArrayList<OrderDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemOrderGoodsBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.store.setText(list.get(position).getStore());
        holder.binding.imgvGoodsImg.setImageResource(list.get(position).getGoods_img());
        holder.binding.tvGoods.setText(list.get(position).getGoods());
        holder.binding.tvOption.setText(list.get(position).getOption());
        holder.binding.tvPrice.setText(list.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemOrderGoodsBinding binding;
        public ViewHolder(@NonNull ItemOrderGoodsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
