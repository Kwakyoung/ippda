package com.example.ipdda.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemHomeRecommendRecvBinding;

import java.util.ArrayList;

public class HomeGoodsRecommendAdapter extends RecyclerView.Adapter<HomeGoodsRecommendAdapter.ViewHolder> {

    ItemHomeRecommendRecvBinding binding;

    ArrayList<GoodsVO> list;

    Context context;

    public HomeGoodsRecommendAdapter(ArrayList<GoodsVO> list, Context context) {
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
        h.binding.tvRecommendStore1.setText(list.get(i).getStore_name()+"");

        h.binding.tvRecommendGoods1.setText(list.get(i).getGoods_name()+"");

        h.binding.tvRecommendPrice1.setText(list.get(i).getGoods_price()+"");



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
