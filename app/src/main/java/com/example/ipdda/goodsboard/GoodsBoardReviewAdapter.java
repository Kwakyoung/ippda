package com.example.ipdda.goodsboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemReviewBinding;
import com.example.ipdda.review.ReviewVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GoodsBoardReviewAdapter extends RecyclerView.Adapter<GoodsBoardReviewAdapter.ViewHolder> {

    ItemReviewBinding binding;

    ArrayList<ReviewVO> list;

    Context context;

    public GoodsBoardReviewAdapter(ArrayList<ReviewVO> list, Context context) {
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



            h.binding.rbRating.setRating(list.get(i).getRating());

            h.binding.tvMemberNickname.setText(list.get(i).getMember_nickname());
            h.binding.tvStarCnt.setText(list.get(i).getRating()+"");
            h.binding.tvGender.setText(list.get(i).getMember_gender());
            h.binding.tvReviewContext.setText(list.get(i).getContent());


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
