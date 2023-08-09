package com.example.ipdda.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.databinding.ItemSearchCategoryBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.goodslist.GoodsListFragment;
import com.example.ipdda.profile.TrackDeliveryActivity;

import java.util.ArrayList;

public class SearchCategoryAdapter extends RecyclerView.Adapter<SearchCategoryAdapter.ViewHolder>{

    ItemSearchCategoryBinding binding;
    ArrayList<SearchCategoryDTO> list;
    Context context;

    public SearchCategoryAdapter(ArrayList<SearchCategoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSearchCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.binding.imgvTop.setImageResource(list.get(position).getImgv());
    holder.binding.tvTop.setText(list.get(position).getCategory());
        holder.binding.fl.setOnClickListener(v -> {
            FragmentTransaction transaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
            GoodsListFragment goodsListFragment = new GoodsListFragment(position+1);
            transaction.replace(R.id.container, goodsListFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSearchCategoryBinding binding;

        public ViewHolder(@NonNull ItemSearchCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
