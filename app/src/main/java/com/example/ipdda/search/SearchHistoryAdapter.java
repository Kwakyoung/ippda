package com.example.ipdda.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.FragmentSearchBinding;
import com.example.ipdda.databinding.ItemSearchHistoryBinding;

import java.util.ArrayList;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>{

    ItemSearchHistoryBinding binding;
    ArrayList<SearchHistoryDTO> list;
    Context context;

    public SearchHistoryAdapter(ArrayList<SearchHistoryDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSearchHistoryBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvHistory.setText(list.get(position).getTxt().trim());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSearchHistoryBinding binding;

        public ViewHolder(@NonNull ItemSearchHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }

}


