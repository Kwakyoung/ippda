package com.example.ipdda.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ActivityOrderBinding;
import com.example.ipdda.databinding.ItemOrderGoodsBinding;
import com.example.ipdda.goodsboard.GoodsBoardBuyCheckDTO;
import com.example.ipdda.home.GoodsVO;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    ArrayList<GoodsBoardBuyCheckDTO> list ;
    ArrayList<GoodsVO> arrayList ;

    ItemOrderGoodsBinding binding;

    public OrderAdapter( ArrayList<GoodsVO> arrayList,ArrayList<GoodsBoardBuyCheckDTO> list) {
        this.list = list;
        this.arrayList = arrayList;
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
        int goodsPrice = arrayList.get(0).getGoods_price();
        int SalePercent = arrayList.get(0).getGoods_sale_percent();


        if(SalePercent == 0){
            h.binding.tvOriginalPrice.setText(""+arrayList.get(0).getGoods_price()*list.get(i).getCheck_goods_cnt());
            h.binding.tvSalePrice.setVisibility(View.GONE);
            h.binding.tvPayPrice.setVisibility(View.GONE);
        }else {
        int goodsSalePrice = goodsPrice/(100/SalePercent);

            String formattedGoodsPrice = NumberFormat.getNumberInstance(Locale.getDefault()).format(goodsSalePrice);

            h.binding.tvGoods.setText(arrayList.get(0).getGoods_name());
            h.binding.tvOriginalPrice.setText(arrayList.get(0).getGoods_price()*list.get(i).getCheck_goods_cnt());
            h.binding.tvPayPrice.setText(arrayList.get(0).getGoods_price()*(100-arrayList.get(0).getGoods_sale_price())/100);

        }

        h.binding.tvStore.setText(arrayList.get(0).getStore_name()+"");
        h.binding.tvGoods.setText(arrayList.get(0).getGoods_name()+"");
        h.binding.tvOption.setText("옵션("+list.get(i).getCheck_goods_size()+","+list.get(i).getCheck_goods_color()+") x "+list.get(i).getCheck_goods_cnt());



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
