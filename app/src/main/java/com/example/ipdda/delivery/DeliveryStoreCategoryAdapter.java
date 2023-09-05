package com.example.ipdda.delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemDeliveryStoreCategoryBinding;
import com.example.ipdda.store.StoreVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DeliveryStoreCategoryAdapter extends RecyclerView.Adapter<DeliveryStoreCategoryAdapter.ViewHolder> {

    ItemDeliveryStoreCategoryBinding binding;

    ArrayList<StoreVO> list;

    Context context;

    public DeliveryStoreCategoryAdapter(ArrayList<StoreVO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveryStoreCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemDeliveryStoreCategoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding); 
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryStoreCategoryAdapter.ViewHolder h, int i) {




        h.binding.tvStoreName.setText(list.get(i).getSTORE_NAME());
        h.binding.tvDeliveryTip.setText(list.get(i).getSTORE_DELIVERY_TIP()+"원");


        String mainImageUrl = list.get(i).getSTORE_MAIN_IMAGE();
        Picasso.get()
                .load(mainImageUrl)
                .into(h.binding.imgvMainStore);


        String subImageUrl = list.get(i).getSTORE_SUB_IMAGE();
        Picasso.get()
                .load(subImageUrl)
                .into(h.binding.imgvMainStore);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemDeliveryStoreCategoryBinding binding;


        public ViewHolder(@NonNull ItemDeliveryStoreCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
