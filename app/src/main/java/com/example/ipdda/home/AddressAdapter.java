package com.example.ipdda.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.MainActivity;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ItemAddressBinding;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    ItemAddressBinding binding;

    ArrayList<AddressVO> list;

    Context context;

    public AddressAdapter(ArrayList<AddressVO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemAddressBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvMainAddress.setText(list.get(i).getDelivery_address());
        h.binding.tvSubAddress.setText(list.get(i).getDelivery_sub_address());
        h.binding.lnAddress.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(context, "address/update");
            conn.addParamMap("member_address", list.get(i).getDelivery_address()+"");
            conn.addParamMap("member_sub_address", list.get(i).getDelivery_sub_address()+"");
            conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
            conn.onExcute((isResult, data) -> {
                Intent intent = new Intent(context , MainActivity.class);
                context.startActivity(intent);
            });
        });
        h.binding.btnAddressDelete.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(context, "address/delete");
            conn.addParamMap("");


        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemAddressBinding binding;


        public ViewHolder(@NonNull ItemAddressBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
