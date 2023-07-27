package com.example.ipdda.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemCircleBinding;
import com.example.ipdda.databinding.ItemViewedBinding;

import java.util.ArrayList;

public class ViewedAdepter extends RecyclerView.Adapter<ViewedAdepter.ViewHolder>{
    ItemViewedBinding binding;
    ArrayList<ViewedDTO> list;
    Context context;

    public ViewedAdepter(ArrayList<ViewedDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        binding= ItemViewedBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewedAdepter.ViewHolder h, int i) {
        h.binding.imgvImg.setImageResource(list.get(i).getImgv_img());
        h.binding.tvText.setText(list.get(i).getTv_text());
        h.binding.imgvImg1.setImageResource(list.get(i).getImgv_img());
        h.binding.tvText1.setText(list.get(i).getTv_text());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemViewedBinding binding;

        public ViewHolder(@NonNull ItemViewedBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
