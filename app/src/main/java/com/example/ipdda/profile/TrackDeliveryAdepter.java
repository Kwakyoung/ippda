package com.example.ipdda.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemCircleBinding;

import java.util.ArrayList;

public class TrackDeliveryAdepter extends RecyclerView.Adapter<TrackDeliveryAdepter.ViewHolder>{
    ItemCircleBinding binding;
    ArrayList<RecvCircleDTO> list;
    Context context;

    public TrackDeliveryAdepter(ArrayList<RecvCircleDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        binding=ItemCircleBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackDeliveryAdepter.ViewHolder h, int i) {
        h.binding.imgvImg.setImageResource(list.get(i).getImgv_img());
        h.binding.tvText.setText(list.get(i).getTv_text());

    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemCircleBinding binding;

        public ViewHolder(@NonNull ItemCircleBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
