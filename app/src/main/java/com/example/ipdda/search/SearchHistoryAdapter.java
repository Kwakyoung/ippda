package com.example.ipdda.search;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.ItemSearchHistoryBinding;
import com.example.ipdda.home.GoodsVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>{

    ItemSearchHistoryBinding binding;
    ArrayList<SearchHistoryDTO> list;
    Context context;
    SearchFragment fragment;

    public SearchHistoryAdapter(ArrayList<SearchHistoryDTO> list, Context context, SearchFragment fragment) {
        this.list = list;
        this.context = context;
        this.fragment=fragment;
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
        holder.binding.tvHistory.setOnClickListener(v -> {
            String key=list.get(position).getTxt();
                CommonConn conn = new CommonConn(fragment.getContext(), "goods/search");
                    conn.addParamMap("keyword",key);
                    conn.onExcute((isResult, data) -> {
                        ArrayList<GoodsVO> searchlist = new Gson().fromJson(data , new TypeToken<ArrayList<GoodsVO>>(){}.getType());
                        if (searchlist.size()==0){
                            fragment.binding.tvSearchNothing.setVisibility(View.VISIBLE);
                            fragment.binding.imvArrow.setVisibility(View.GONE);
                        }else{
                            fragment.binding.tvSearchNothing.setVisibility(View.GONE);
                            fragment.binding.imvArrow.setVisibility(View.VISIBLE);
                            fragment.binding.recvSearchList.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
                            fragment.binding.recvSearchList.setAdapter(new SearchListAdapter(searchlist, fragment.getContext()));
                        }
                    });

        });
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


