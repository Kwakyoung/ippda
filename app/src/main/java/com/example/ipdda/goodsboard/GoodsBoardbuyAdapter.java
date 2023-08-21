package com.example.ipdda.goodsboard;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.MainActivity;
import com.example.ipdda.databinding.ActivityGoodsboardBuyBinding;
import com.example.ipdda.databinding.ItemGoodsboardRecvBinding;
import com.example.ipdda.databinding.ItemReviewBinding;

import java.util.ArrayList;

public class GoodsBoardbuyAdapter extends RecyclerView.Adapter<GoodsBoardbuyAdapter.ViewHolder> {

    ItemGoodsboardRecvBinding binding;

    ArrayList<String> list;

    Context context;

    public GoodsBoardbuyAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public GoodsBoardbuyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsboardRecvBinding.inflate(inflater,parent,false);
        return new GoodsBoardbuyAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsBoardbuyAdapter.ViewHolder h, int i) {
        h.binding.btnOption.setText(list.get(i));
        Intent intent = new Intent(context, GoodsBoardActivity.class);
        h.binding.btnOption.setOnClickListener(v -> {
            if(list.get(list.size() - 1).equals("사이즈")) {
                GoodsBoardActivity.select_size= list.get(i);

            } else if (list.get(list.size() - 1).equals("색상")) {
                GoodsBoardActivity.select_color= list.get(i);
            }

        });


    }

    @Override
    public int getItemCount() {
        return list.size()-1;
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsboardRecvBinding binding;

        public ViewHolder(@NonNull ItemGoodsboardRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
