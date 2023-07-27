package com.example.ipdda.profile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ItemCircleBinding;

import java.util.ArrayList;

public class UserActionAdepter  extends RecyclerView.Adapter<UserActionAdepter.ViewHolder>{
    ItemCircleBinding binding;
    ArrayList<RecvCircleDTO> list;
    Context context;

    public UserActionAdepter(ArrayList<RecvCircleDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public UserActionAdepter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        binding=ItemCircleBinding.inflate(inflater,parent,false);
        return new UserActionAdepter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserActionAdepter.ViewHolder h, int i) {
        h.binding.imgvImg.setImageResource(list.get(i).getImgv_img());
        h.binding.imgvImg.setOnClickListener(v -> {
            Intent intent = new Intent(context,SubActivity.class);
            intent.putExtra("key", i);
            context.startActivity(intent);
        });

        h.binding.tvText.setText(list.get(i).getTv_text());
        h.binding.tvText.setTextColor(R.color.black);
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemCircleBinding binding;

        public ViewHolder(@NonNull ItemCircleBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
