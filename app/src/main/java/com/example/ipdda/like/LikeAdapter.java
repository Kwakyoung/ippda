package com.example.ipdda.like;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ItemLikeGridBinding;

import java.util.ArrayList;

public class LikeAdapter extends BaseAdapter {


    LayoutInflater inflater;
    ItemLikeGridBinding binding;
    ArrayList<LikeDTO> list ;

    public LikeAdapter(LayoutInflater inflater, ArrayList<LikeDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_like_grid, parent , false);
        ImageView imgv_img, imgv_like;
        TextView tv_shop, tv_price;

        imgv_img = v.findViewById(R.id.imgv_img);
        imgv_img.setImageResource(list.get(position).getImgv_img());

        imgv_like = v.findViewById(R.id.imgv_like);
        imgv_like.setImageResource(list.get(position).getImgv_like());

        tv_shop = v.findViewById(R.id.tv_shop);
        tv_shop.setText(list.get(position).getTv_shop());

        tv_price = v.findViewById(R.id.tv_price);
        tv_price.setText(list.get(position).getTv_price());

//        binding.imgvImg.setImageResource(list.get(position).getImgv_img());
//        binding.imgvLike.setImageResource(list.get(position).getImgv_like());
//        binding.tvShop.setText(list.get(position).getTv_shop());
//        binding.tvPrice.setText(list.get(position).getTv_price());
        return v;
    }

}
