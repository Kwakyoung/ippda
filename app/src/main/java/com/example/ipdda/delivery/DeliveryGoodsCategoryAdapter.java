package com.example.ipdda.delivery;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.databinding.ItemDeliveryGoodsCategoryBinding;
import com.example.ipdda.databinding.ItemDeliveryStoreCategoryBinding;
import com.example.ipdda.goodsboard.GoodsBoardActivity;
import com.example.ipdda.goodslist.GoodsListActivity;
import com.example.ipdda.goodslist.GoodsListFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeliveryGoodsCategoryAdapter extends RecyclerView.Adapter<DeliveryGoodsCategoryAdapter.ViewHolder>{


    ItemDeliveryGoodsCategoryBinding binding;

    ArrayList<DeliveryGoodsCategoryDTO> list;

    Context context;


    public DeliveryGoodsCategoryAdapter(ArrayList<DeliveryGoodsCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveryGoodsCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDeliveryGoodsCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryGoodsCategoryAdapter.ViewHolder h, int i) {
        h.binding.imgvGoodsCategory1.setImageResource(list.get(i).getImgRes1());
        h.binding.imgvGoodsCategory2.setImageResource(list.get(i).getImgRes2());
        h.binding.imgvGoodsCategory3.setImageResource(list.get(i).getImgRes3());
        h.binding.imgvGoodsCategory4.setImageResource(list.get(i).getImgRes4());


        h.binding.imgvGoodsCategory1.setOnClickListener(v -> {
            Intent intent = new Intent(context , GoodsListActivity.class);
            context.startActivity(intent);
        });

        h.binding.tvGoodsCategory1.setText(list.get(i).getCategoryName1());
        h.binding.tvGoodsCategory2.setText(list.get(i).getCategoryName2());
        h.binding.tvGoodsCategory3.setText(list.get(i).getCategoryName3());
        h.binding.tvGoodsCategory4.setText(list.get(i).getCategoryName4());



    }

    @Override
    public int getItemCount() {
        
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemDeliveryGoodsCategoryBinding binding;


        public ViewHolder(@NonNull ItemDeliveryGoodsCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }




}
