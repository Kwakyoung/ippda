package com.example.ipdda.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsListBinding;
import com.example.ipdda.goodslist.GoodsListDTO;

import java.util.ArrayList;

public class ViewedAdepter extends RecyclerView.Adapter<ViewedAdepter.ViewHolder>{
    ItemGoodsListBinding binding;
    ArrayList<GoodsListDTO> list;
    Context context;

    public ViewedAdepter(ArrayList<GoodsListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        binding= ItemGoodsListBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewedAdepter.ViewHolder h, int i) {
        h.binding.imgvGoods1.setImageResource(list.get(i).getGOODS_MAIN_IMAGE());
        h.binding.imgvGoods2.setImageResource(list.get(i).getGOODS_MAIN_IMAGE());

        h.binding.tvGoodsName1.setText(list.get(i).getGOODS_NAME()+"");
        h.binding.tvGoodsName2.setText(list.get(i).getGOODS_NAME()+"");

        h.binding.tvGoodsPrice1.setText(list.get(i).getGOODS_PRICE()+"원");
        h.binding.tvGoodsPrice2.setText(list.get(i).getGOODS_PRICE()+"원");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemGoodsListBinding binding;

        public ViewHolder(@NonNull ItemGoodsListBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
