package com.example.ipdda.goodslist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ItemDeliveryGoodsCategoryBinding;
import com.example.ipdda.databinding.ItemGoodsSubCategoryBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GoodsListSubCategoryAdapter extends RecyclerView.Adapter<GoodsListSubCategoryAdapter.ViewHolder> {


    Boolean connCheck = true;
    ImageView lastClickedMenu;
    ItemGoodsSubCategoryBinding binding;

    ArrayList<GoodsListSubCategoryDTO> list;

    Context context;

    GoodsListFragment goodsListFragment;

    public GoodsListSubCategoryAdapter(ArrayList<GoodsListSubCategoryDTO> list, Context context, GoodsListFragment goodsListFragment) {
        this.list = list;
        this.context = context;
        this.goodsListFragment = goodsListFragment;
    }

    @NonNull
    @Override
    public GoodsListSubCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsSubCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsListSubCategoryAdapter.ViewHolder h, int i) {
        h.binding.tvSubCategory.setText(list.get(i).getGoodsSubCategory());

        if(connCheck == true){
            if(i == 0){
                changeImgColor(h.binding.imgvGoodsSubCategory);
            }
        }

        h.binding.imgvGoodsSubCategory.setOnClickListener(v -> {
            changeImgColor(h.binding.imgvGoodsSubCategory);
            goodsListFragment.SubCategoryConn(i+1);
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
    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsSubCategoryBinding binding;


        public ViewHolder(@NonNull ItemGoodsSubCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void changeImgColor(ImageView v) {
        if (lastClickedMenu != null) {
            lastClickedMenu.setBackgroundColor(Color.parseColor("#02FEB2"));
        }
            ImageView imageView = (ImageView) v;
            v.setBackgroundColor(Color.parseColor("#EE8FFE"));

        lastClickedMenu = imageView;

    }


}
