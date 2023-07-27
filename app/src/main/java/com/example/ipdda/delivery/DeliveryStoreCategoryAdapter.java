package com.example.ipdda.delivery;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemDeliveryStoreCategoryBinding;

import java.util.ArrayList;

public class DeliveryStoreCategoryAdapter extends RecyclerView.Adapter<DeliveryStoreCategoryAdapter.ViewHolder> {

    ItemDeliveryStoreCategoryBinding binding;




    @NonNull
    @Override
    public DeliveryStoreCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryStoreCategoryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
