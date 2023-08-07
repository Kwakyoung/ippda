package com.example.ipdda.goodsboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemReviewBinding;

import java.util.ArrayList;

public class GoodsBoardReviewAdapter extends RecyclerView.Adapter<GoodsBoardReviewAdapter.ViewHolder> {

    ItemReviewBinding binding;

    ArrayList<GoodsBoardReviewDTO> list;

    Context context;

    public GoodsBoardReviewAdapter(ArrayList<GoodsBoardReviewDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemReviewBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
            h.binding.imgvProfile.setImageResource(list.get(i).getImgProfile());
            h.binding.imgvGoods.setImageResource(list.get(i).getImgProfile());
            h.binding.tvMemberNickname.setText(list.get(i).getMemberNickName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {

        ItemReviewBinding binding;

        public ViewHolder(@NonNull ItemReviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
