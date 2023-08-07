package com.example.ipdda.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ItemQuestionBinding;

import java.util.ArrayList;

public class OptenQuestionAdapter extends RecyclerView.Adapter<OptenQuestionAdapter.ViewHolder> {

    ItemQuestionBinding binding;

    ArrayList<String> list;

    Context context;
    public OptenQuestionAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OptenQuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemQuestionBinding.inflate(inflater,parent,false);
        return new OptenQuestionAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OptenQuestionAdapter.ViewHolder h, int i) {
        h.binding.text.setText(list.get(i));
        if (i==list.size()-1){
            h.binding.line.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemQuestionBinding binding;


        public ViewHolder(@NonNull ItemQuestionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

