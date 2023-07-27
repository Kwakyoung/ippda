package com.example.ipdda.delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemDeliveryStoreCategoryBinding;

import java.util.ArrayList;

public class DeliveryStoreCategoryAdapter extends RecyclerView.Adapter<DeliveryStoreCategoryAdapter.ViewHolder> {

    ItemDeliveryStoreCategoryBinding binding;

    ArrayList<DeliveryStoreCategoryDTO> list;

    Context context;

    public DeliveryStoreCategoryAdapter(ArrayList<DeliveryStoreCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveryStoreCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDeliveryStoreCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryStoreCategoryAdapter.ViewHolder h, int i) {
        h.binding.imgvMainStore.setImageResource(list.get(i).getImgResMain());
        h.binding.imgvSub1Store.setImageResource(list.get(i).getImgResSub1());
        h.binding.imgvSub2Store.setImageResource(list.get(i).getImgResSub2());
        h.binding.tvDeliveryTip.setText(list.get(i).getDelivery_tip()+"원");
        h.binding.tvStoreName.setText(list.get(i).getStore_name()+"");
        h.binding.tvReviewCnt.setText(list.get(i).getReview_cnt()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemDeliveryStoreCategoryBinding binding;


        public ViewHolder(@NonNull ItemDeliveryStoreCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
