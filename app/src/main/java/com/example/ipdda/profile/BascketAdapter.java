package com.example.ipdda.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySubBinding;
import com.example.ipdda.databinding.ItemGoodsListBinding;
import com.example.ipdda.databinding.ItemSubBinding;
import com.example.ipdda.goodslist.GoodsListAdapter;
import com.example.ipdda.goodslist.GoodsListDTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BascketAdapter extends RecyclerView.Adapter<BascketAdapter.ViewHolder> {

    ItemSubBinding binding;

    ArrayList<SubDTO> list;
    String saveDate;

    Context context;
    public BascketAdapter(ArrayList<SubDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSubBinding.inflate(inflater,parent,false);
        return new BascketAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BascketAdapter.ViewHolder h, int i) {
        h.binding.btnStar.setVisibility(View.GONE);
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
        if (list.get(i).getGoodsPrice()<=0){
            h.binding.goodsPrice.setText("매진");
            h.binding.goodsPrice.setTextColor(Color.parseColor("#FF0000"));
        }else{
            h.binding.goodsPrice.setText(list.get(i).getGoodsPrice()+"원");
        }
        if(list.get(i).getGoodsCnt()!=0){
            h.binding.goodsCnt.setText(list.get(i).getGoodsCnt()+"개 남음");
        }
        if(list.get(i).getChoiceNum()!=0){
            h.binding.goodsCnt.setText(list.get(i).getGoodsCnt()+"개");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSubBinding binding;


        public ViewHolder(@NonNull ItemSubBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
