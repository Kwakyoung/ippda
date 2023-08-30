package com.example.ipdda.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ItemOrderGoodsBinding;
import com.example.ipdda.home.GoodsVO;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

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
            String goodsPriceStr = NumberFormat.getNumberInstance(Locale.getDefault()).format(list.get(i).getGoods_price());
            h.binding.tvOrginalPrice.setText(goodsPriceStr);
            h.binding.tvSalePrice.setVisibility(View.GONE);
            h.binding.tvPayPrice.setVisibility(View.GONE);
        }else {
        int goodsSalePrice = goodsPrice/(100/SalePercent);

            String formattedGoodsPrice = NumberFormat.getNumberInstance(Locale.getDefault()).format(goodsSalePrice);
            String goodsName = list.get(i).getGoods_name();
            String goodsPriceStr = NumberFormat.getNumberInstance(Locale.getDefault()).format(list.get(i).getGoods_price());

            h.binding.tvGoods.setText(goodsName);
            h.binding.tvOrginalPrice.setText(goodsPriceStr);
            h.binding.tvPayPrice.setText(formattedGoodsPrice);

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
