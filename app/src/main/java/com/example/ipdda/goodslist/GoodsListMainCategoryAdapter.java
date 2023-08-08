package com.example.ipdda.goodslist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemGoodsMainCategoryBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GoodsListMainCategoryAdapter extends RecyclerView.Adapter<GoodsListMainCategoryAdapter.ViewHolder> {


    Boolean connCheck = false;
    int key;

    TextView lastClickedMenu;

    ItemGoodsMainCategoryBinding binding;

    ArrayList<GoodsListMainCategoryDTO> list;

    Context context;

    GoodsListFragment goodsListFragment;


    public GoodsListMainCategoryAdapter(ArrayList<GoodsListMainCategoryDTO> list, Context context, GoodsListFragment goodsListFragment, int key) {
        this.list = list;
        this.context = context;
        this.goodsListFragment = goodsListFragment;
        this.key = key;
    }


    @NonNull
    @Override
    public GoodsListMainCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsMainCategoryBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsListMainCategoryAdapter.ViewHolder h, int i) {

        h.binding.tvGoodsMainCategory.setText(list.get(i).getGoodsMainCategory());

        if (connCheck == false && key == i+1){
                goodsListFragment.onClickCategory(key);
                changeTextColor(h.binding.tvGoodsMainCategory);
                goodsListFragment.GetGoodsSubCateogry(list.get(i));
                connCheck = true;
        }


        h.binding.tvGoodsMainCategory.setOnClickListener(v -> {
            goodsListFragment.onClickCategory(i+1);
            changeTextColor(h.binding.tvGoodsMainCategory);
            goodsListFragment.GetGoodsSubCateogry(list.get(i));
        });




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

        ItemGoodsMainCategoryBinding binding;


        public ViewHolder(@NonNull ItemGoodsMainCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public void changeTextColor(View view) {
        if (lastClickedMenu != null) {
            lastClickedMenu.setTextColor(Color.WHITE);
            lastClickedMenu.setTextSize(18);
        }
        TextView textView = (TextView) view;
        textView.setTextSize(20);
        textView.setTextColor(Color.rgb(2,254,178));
        lastClickedMenu = textView;
    }


}
