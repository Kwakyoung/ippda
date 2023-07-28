package com.example.ipdda.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemCouponBinding;

import java.util.ArrayList;

public class DeadlineCouponAdapter extends RecyclerView.Adapter<DeadlineCouponAdapter.ViewHolder> {

    ItemCouponBinding binding;

    ArrayList<CouponDTO> list;
    String saveDate;

    Context context;
    public DeadlineCouponAdapter(ArrayList<CouponDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeadlineCouponAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemCouponBinding.inflate(inflater,parent,false);
        return new DeadlineCouponAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeadlineCouponAdapter.ViewHolder h, int i) {
        binding.couponImg.setImageResource(list.get(i).getCoupon_img());
        binding.couponTitle.setText(list.get(i).getCoupon_title());
        binding.couponDeadlineDate.setTextColor(Color.RED);
        binding.couponDeadlineDate.setText("~"+list.get(i).getDeadline_date() +"기간 만료");

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
