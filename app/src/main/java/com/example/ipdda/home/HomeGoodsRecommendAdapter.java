package com.example.ipdda.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemHomeRecommendRecvBinding;

import java.util.ArrayList;

public class HomeGoodsRecommendAdapter extends RecyclerView.Adapter<HomeGoodsRecommendAdapter.ViewHolder> {

    ItemHomeRecommendRecvBinding binding;

    ArrayList<HomeGoodsRecommendDTO> list;

    Context context;

    public HomeGoodsRecommendAdapter(ArrayList<HomeGoodsRecommendDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeGoodsRecommendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemHomeRecommendRecvBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeGoodsRecommendAdapter.ViewHolder h, int i) {
        h.binding.imgvGoodsTop.setImageResource(list.get(i).getImgv_goods_top());
        h.binding.imgvGoodsBottom.setImageResource(list.get(i).getImgv_goods_bottom());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemHomeRecommendRecvBinding binding;


        public ViewHolder(@NonNull ItemHomeRecommendRecvBinding binding) {
            super(binding.getRoot());
            this.binding  = binding;
        }
    }
}
