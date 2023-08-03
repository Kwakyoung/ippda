package com.example.ipdda.delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemDeliveryGoodsCategoryBinding;

import java.util.ArrayList;

public class DeliveryGoodsCategoryAdapter extends RecyclerView.Adapter<DeliveryGoodsCategoryAdapter.ViewHolder>{


    ItemDeliveryGoodsCategoryBinding binding;

    ArrayList<DeliveryGoodsCategoryDTO> list;

    Context context;


    public DeliveryGoodsCategoryAdapter(ArrayList<DeliveryGoodsCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveryGoodsCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDeliveryGoodsCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryGoodsCategoryAdapter.ViewHolder h, int i) {
        h.binding.imgvGoodsCategory1.setImageResource(list.get(i).getImgRes1());
        h.binding.imgvGoodsCategory2.setImageResource(list.get(i).getImgRes2());
        h.binding.imgvGoodsCategory3.setImageResource(list.get(i).getImgRes3());
        h.binding.imgvGoodsCategory4.setImageResource(list.get(i).getImgRes4());

        h.binding.tvGoodsCategory1.setText(list.get(i).getCategoryName1());
        h.binding.tvGoodsCategory2.setText(list.get(i).getCategoryName2());
        h.binding.tvGoodsCategory3.setText(list.get(i).getCategoryName3());
        h.binding.tvGoodsCategory4.setText(list.get(i).getCategoryName4());



    }

    @Override
    public int getItemCount() {
        
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemDeliveryGoodsCategoryBinding binding;


        public ViewHolder(@NonNull ItemDeliveryGoodsCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }




}
