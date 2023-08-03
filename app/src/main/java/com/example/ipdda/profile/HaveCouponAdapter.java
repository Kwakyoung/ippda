package com.example.ipdda.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemCouponBinding;

import java.util.ArrayList;

public class HaveCouponAdapter extends RecyclerView.Adapter<HaveCouponAdapter.ViewHolder> {

    ItemCouponBinding binding;

    ArrayList<CouponDTO> list;

    Context context;
    public HaveCouponAdapter(ArrayList<CouponDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HaveCouponAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemCouponBinding.inflate(inflater,parent,false);
        return new HaveCouponAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HaveCouponAdapter.ViewHolder h, int i) {
        binding.couponImg.setImageResource(list.get(i).getCoupon_img());
        binding.couponTitle.setText(list.get(i).getCoupon_title());
        binding.couponDeadlineDate.setTextColor(Color.WHITE);
        binding.couponDeadlineDate.setText("~"+list.get(i).getDeadline_date());

        binding.layout.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemCouponBinding binding;


        public ViewHolder(@NonNull ItemCouponBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
