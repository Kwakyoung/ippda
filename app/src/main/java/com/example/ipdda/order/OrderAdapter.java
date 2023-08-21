package com.example.ipdda.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ItemOrderGoodsBinding;
import com.example.ipdda.home.GoodsVO;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    ArrayList<GoodsVO> list ;
    ItemOrderGoodsBinding binding;

    public OrderAdapter(ArrayList<GoodsVO> list) {
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
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        int goodsPrice = list.get(i).getGoods_price();
        int SalePercent = list.get(i).getGoods_sale_percent();


        if(SalePercent == 0){
            h.binding.tvPayPrice.setText(list.get(i).getGoods_price()+"원");
            h.binding.tvOrginalPrice.setVisibility(View.GONE);
        }else {
        int goodsSalePrice = goodsPrice/(100/SalePercent);
            h.binding.tvGoods.setText(list.get(i).getGoods_name()+"");
            h.binding.tvOrginalPrice.setText(list.get(i).getGoods_price()+"");
            h.binding.tvPayPrice.setText(goodsSalePrice+"");
        }

        h.binding.tvStore.setText(list.get(i).getStore_name()+"");
        h.binding.tvGoods.setText(list.get(i).getGoods_name()+"");



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
