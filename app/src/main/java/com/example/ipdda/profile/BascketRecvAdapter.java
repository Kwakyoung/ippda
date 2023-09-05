package com.example.ipdda.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemSubRecvBinding;
import com.example.ipdda.home.GoodsVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BascketRecvAdapter extends RecyclerView.Adapter<BascketRecvAdapter.ViewHolder> {

    ItemSubRecvBinding binding;

    ArrayList<GoodsVO> list;
    String saveDate;

    Context context;
    public BascketRecvAdapter(ArrayList<GoodsVO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSubRecvBinding.inflate(inflater,parent,false);
        return new BascketRecvAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BascketRecvAdapter.ViewHolder h, int i) {
        h.binding.btnStar.setVisibility(View.GONE);
        h.binding.btnHart.setVisibility(View.GONE);
        h.binding.insertDate.setVisibility(View.GONE);
        Picasso.get()
                .load(list.get(i).getGoods_main_image())
                .into(h.binding.imgGoodsList);
        h.binding.goodsName.setText(list.get(i).getGoods_name());
        if (list.get(i).getGoods_price()<=0){
            h.binding.goodsPrice.setText("매진");
            h.binding.goodsPrice.setTextColor(Color.parseColor("#FF0000"));
        }else{
            h.binding.goodsPrice.setText(list.get(i).getGoods_sale_price()+"원");
        }
        if(list.get(i).getGoods_cnt()!=0){
            h.binding.goodsCnt.setText(list.get(i).getGoods_cnt()+"개 남음");
            h.binding.goodsCnt.setVisibility(View.VISIBLE);
        }else{
            h.binding.goodsCnt.setVisibility(View.GONE);
        }
            h.binding.choiceNum.setVisibility(View.VISIBLE);
            h.binding.choiceNum.setText("");

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
