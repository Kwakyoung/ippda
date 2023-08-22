package com.example.ipdda.goodslist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.common.CommonConn;
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



        if( list.get(i).getGoods_sale_percent() != 0){
            int getGoodsPrice = list.get(i).getGoods_price()/(100/list.get(i).getGoods_sale_percent());
            h.binding.tvGoodsPrice1.setText(getGoodsPrice+"");
        }else{
            h.binding.tvGoodsPrice1.setText(list.get(i).getGoods_price()+"");
            h.binding.tvSalePercent1.setVisibility(View.GONE);
            h.binding.tvSale1.setVisibility(View.GONE);
        }





        h.binding.imgvGoods1.setOnClickListener(v -> {
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

        ItemGoodsListBinding binding;


        public ViewHolder(@NonNull ItemGoodsListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }



}
