package com.example.ipdda.goodslist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsSubCategoryBinding;

import java.util.ArrayList;

public class GoodsListSubCategoryAdapter extends RecyclerView.Adapter<GoodsListSubCategoryAdapter.ViewHolder> {

    int localkey;
    Boolean connCheck = true;
    ImageView lastClickedMenu;
    ItemGoodsSubCategoryBinding binding;

    ArrayList<GoodsListSubCategoryDTO> list;

    Context context;

    GoodsListFragment goodsListFragment;

    public GoodsListSubCategoryAdapter(ArrayList<GoodsListSubCategoryDTO> list, Context context, GoodsListFragment goodsListFragment, int localkey) {
        this.list = list;
        this.context = context;
        this.goodsListFragment = goodsListFragment;
        this.localkey = localkey;
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

        //sub카테고리 클릭시 조회되는 로직
        h.binding.imgvGoodsSubCategory.setOnClickListener(v -> {
            changeImgColor(h.binding.imgvGoodsSubCategory);
            goodsListFragment.SubCategoryConn(i);

            //sub카테고리 전체 조회 로직
            if(localkey==1 && i==0){
                goodsListFragment.CategoryConn(1);
            } else if (localkey==2 && i==0 ) {
                goodsListFragment.CategoryConn(2);
            } else if (localkey==3 && i==0) {
                goodsListFragment.CategoryConn(3);
            } else if (localkey==4 && i ==0) {
                goodsListFragment.CategoryConn(4);
            } else if (localkey==5 && i==0) {
                goodsListFragment.CategoryConn(5);
            }else if (localkey==6 && i==0) {
                goodsListFragment.CategoryConn(6);
            }else if (localkey==7 && i==0) {
                goodsListFragment.CategoryConn(7);
            }else if (localkey==8 && i==0) {
                goodsListFragment.CategoryConn(8);
            }else if (localkey==9 && i==0) {
                goodsListFragment.CategoryConn(9);
            }else if (localkey==10 && i==0) {
                goodsListFragment.CategoryConn(10);
            }else if (localkey==11 && i==0) {
                goodsListFragment.CategoryConn(11);
            }else if (localkey==12 && i==0) {
                goodsListFragment.CategoryConn(12);
            }

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
