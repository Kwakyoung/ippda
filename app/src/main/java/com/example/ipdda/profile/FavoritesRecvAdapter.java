package com.example.ipdda.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemSubRecvBinding;

import java.util.ArrayList;

public class FavoritesRecvAdapter extends RecyclerView.Adapter<FavoritesRecvAdapter.ViewHolder> {

    ItemSubRecvBinding binding;

    ArrayList<SubDTO> list;
    String saveDate;

    Context context;
    public FavoritesRecvAdapter(ArrayList<SubDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoritesRecvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSubRecvBinding.inflate(inflater,parent,false);
        return new FavoritesRecvAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesRecvAdapter.ViewHolder h, int i) {
        h.binding.btnStar.setVisibility(View.VISIBLE);
        h.binding.btnHart.setVisibility(View.GONE);

        h.binding.insertDate.setText(list.get(i).getInsertDate());
        if(i==0){
            saveDate=list.get(i).getInsertDate();
            h.binding.insertDate.setVisibility(View.VISIBLE);
        }else{
            if(saveDate.equals(list.get(i).getInsertDate())){
                h.binding.insertDate.setVisibility(View.GONE);
            }else{
                saveDate=list.get(i).getInsertDate();
                h.binding.insertDate.setVisibility(View.VISIBLE);
            }
        }

        h.binding.imgGoodsList.setImageResource(list.get(i).getImgGoodsList());
        h.binding.goodsName.setText(list.get(i).getGoodsName());
        h.binding.goodsCnt.setVisibility(View.GONE);
        h.binding.choiceNum.setVisibility(View.GONE);

        if (list.get(i).getGoodsPrice()<=0){
            h.binding.goodsPrice.setText("매진");
            h.binding.goodsPrice.setTextColor(Color.parseColor("#FF0000"));
        }else{
            h.binding.goodsPrice.setText(list.get(i).getGoodsPrice()+"원");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSubRecvBinding binding;


        public ViewHolder(@NonNull ItemSubRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
