package com.example.ipdda.goodsboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ActivityGoodsboardBuyBinding;
import com.example.ipdda.databinding.ItemGoodsboardRecvBinding;
import com.example.ipdda.inventory.InventoryVO;

import java.util.ArrayList;

public class GoodsBoardbuyAdapter extends RecyclerView.Adapter<GoodsBoardbuyAdapter.ViewHolder> {

    ItemGoodsboardRecvBinding binding;

    ArrayList<InventoryVO> list;
    ActivityGoodsboardBuyBinding dialogBinding;
    GoodsBoardActivity activity;
    ArrayList<GoodsBoardBuyCheckDTO> getBuyCheck;



    int goods_price;
    public GoodsBoardbuyAdapter(GoodsBoardActivity activity , ArrayList<InventoryVO> list, ActivityGoodsboardBuyBinding dialogBinding, ArrayList<GoodsBoardBuyCheckDTO> getBuyCheck,int goods_price) {
        this.list = list;
        this.dialogBinding = dialogBinding;
        this.getBuyCheck=getBuyCheck;
        this.goods_price=goods_price;
        this.activity=activity;
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
            dialogBinding.recvColor.setVisibility(View.GONE);
            getBuyCheck.add(new GoodsBoardBuyCheckDTO(list.get(i).getGoods_color()+ "/" +
                    GoodsBoardActivity.select_size,1,goods_price));
            dialogBinding.recvBuyCheck.setAdapter(new GoodsBuyCheckAdapter(activity , getBuyCheck,list.get(i).getGoods_color(),dialogBinding.btnSelectSize.getText().toString()));
            dialogBinding.recvBuyCheck.setLayoutManager(new LinearLayoutManager(dialogBinding.getRoot().getContext()));
            activity.calcTotalPrice(getBuyCheck,"+");
            dialogBinding.btnSelectSize.setText("사이즈");
            dialogBinding.btnSelectColor.setText("색상");
            notifyDataSetChanged();
        });

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
