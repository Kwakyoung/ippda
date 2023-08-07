package com.example.ipdda.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemSubRecvBinding;

import java.util.ArrayList;

public class TrackDeliveryListAdapter  extends RecyclerView.Adapter<TrackDeliveryListAdapter.ViewHolder>{
    ItemSubRecvBinding binding;
    ArrayList<SubDTO> list;
    Context context;
    String saveDate;
    public TrackDeliveryListAdapter(ArrayList<SubDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public TrackDeliveryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        binding= ItemSubRecvBinding.inflate(inflater,parent,false);
        return new TrackDeliveryListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackDeliveryListAdapter.ViewHolder h, int i) {
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
        h.binding.goodsCnt.setVisibility(View.GONE);
        h.binding.choiceNum.setVisibility(View.GONE);
            h.binding.goodsPrice.setText(list.get(i).getGoodsPrice()+"원");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemSubRecvBinding binding;

        public ViewHolder(@NonNull ItemSubRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
