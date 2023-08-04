package com.example.ipdda.delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemDeliveryTopCategoryBinding;
import com.example.ipdda.databinding.ItemHomeRecommendRecvBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeliveryTopCategoryAdapter extends RecyclerView.Adapter<DeliveryTopCategoryAdapter.ViewHolder> {

    ItemDeliveryTopCategoryBinding binding;

    ArrayList<DeliveryTopCategoryDTO> list;

    Context context;


    public DeliveryTopCategoryAdapter(ArrayList<DeliveryTopCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveryTopCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDeliveryTopCategoryBinding.inflate(inflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryTopCategoryAdapter.ViewHolder h, int i) {
        h.binding.imgvTopCategory.setImageResource(list.get(i).getImgRes());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemDeliveryTopCategoryBinding binding;


        public ViewHolder(@NonNull ItemDeliveryTopCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
