package com.example.ipdda.home;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemHomeCategoryRecvBinding;

import java.util.ArrayList;


public class HomeGoodsRecommendCategoryAdapter extends RecyclerView.Adapter<HomeGoodsRecommendCategoryAdapter.ViewHolder> {

        private TextView lastClickedMenu;

        Boolean connCheck = true;

        ArrayList<HomeGoodsRecommendCategoryDTO> list;

        Context context;
        HomeFragment homeFragment;

    public HomeGoodsRecommendCategoryAdapter(ArrayList<HomeGoodsRecommendCategoryDTO> list, Context context, HomeFragment homeFragment) {
        this.list = list;
        this.context = context;
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public HomeGoodsRecommendCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        ItemHomeCategoryRecvBinding binding = ItemHomeCategoryRecvBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeGoodsRecommendCategoryAdapter.ViewHolder h, int i) {

            if(connCheck == true){
                if(i == 0){
                    homeFragment.GetGoodsRecommendList(list.get(0));
                    changeTextColor(h.binding.tvCategory);
                }
            }

            h.binding.imgvCategory.setImageResource(list.get(i).getImgv_category());
            h.binding.tvCategory.setText(list.get(i).getTv_category());

            h.binding.imgvCategory.setOnClickListener(v -> {
                homeFragment.GetGoodsRecommendList(list.get(i));
                changeTextColor(h.binding.tvCategory);
            });
        connCheck = false;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemHomeCategoryRecvBinding binding;
        public ViewHolder(@NonNull ItemHomeCategoryRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    
}


    public void changeTextColor(TextView view) {
        if (lastClickedMenu != null) {
            lastClickedMenu.setTextColor(Color.WHITE);
            lastClickedMenu.setTextSize(14);
        }
        view.setTextSize(18);
        view.setTextColor(Color.rgb(2,254,178));
        lastClickedMenu = view;
    }




}
