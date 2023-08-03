package com.example.ipdda.profile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemCouponBinding;
import com.example.ipdda.databinding.ItemSettingRecvBinding;

import java.util.ArrayList;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder> {

    ItemSettingRecvBinding binding;

    ArrayList<SettingDTO> list;

    Context context;
    public SettingAdapter(ArrayList<SettingDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SettingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSettingRecvBinding.inflate(inflater,parent,false);
        return new SettingAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.ViewHolder h, int i) {
        h.binding.tvText.setText(list.get(i).getTv_text());

        if (h.binding.tvText.getText().equals("팝업 알림 설정")) {
            h.binding.tvToggle.setVisibility(View.VISIBLE);
            h.binding.tvToggle.setOnClickListener(v -> {
                if(h.binding.tvToggle.getText().equals("ON")) {
                    h.binding.tvToggle.setText("OFF");
                }else if(h.binding.tvToggle.getText().equals("OFF")) {
                    h.binding.tvToggle.setText("ON");
                }

            });
        } else if(h.binding.tvText.getText().equals("SMS서비스 설정")){
            h.binding.tvToggle.setVisibility(View.VISIBLE);
            h.binding.tvToggle.setOnClickListener(v -> {
                if(h.binding.tvToggle.getText().equals("ON")) {
                    h.binding.tvToggle.setText("OFF");
                }else if(h.binding.tvToggle.getText().equals("OFF")) {
                    h.binding.tvToggle.setText("ON");
                }
            });
        } else if(h.binding.tvText.getText().equals("탈퇴하기")){
            h.binding.tvToggle.setVisibility(View.GONE);
            h.binding.tvText.setTextColor(Color.RED);
        }else {
                h.binding.tvToggle.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSettingRecvBinding binding;


        public ViewHolder(@NonNull ItemSettingRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

