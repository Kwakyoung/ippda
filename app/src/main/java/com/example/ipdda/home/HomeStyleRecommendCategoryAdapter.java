package com.example.ipdda.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemHomeCategoryRecvBinding;

import java.util.ArrayList;

public class HomeStyleRecommendCategoryAdapter extends RecyclerView.Adapter<HomeStyleRecommendCategoryAdapter.ViewHolder> {

    ItemHomeCategoryRecvBinding binding;

    ArrayList<HomeGoodsRecommendCategoryDTO> list;

    Context context;

    public HomeStyleRecommendCategoryAdapter(ArrayList<HomeGoodsRecommendCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeStyleRecommendCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemHomeCategoryRecvBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeStyleRecommendCategoryAdapter.ViewHolder h, int i) {
        h.binding.imgvCategory.setImageResource(list.get(i).getImgv_category());
        h.binding.tvCategory.setText(list.get(i).getTv_category());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        ItemHomeCategoryRecvBinding binding;

        public ViewHolder(@NonNull ItemHomeCategoryRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
