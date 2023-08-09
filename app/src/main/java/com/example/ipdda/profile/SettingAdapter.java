package com.example.ipdda.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ItemSettingRecvBinding;
import com.example.ipdda.login.LoginActivity;

import java.util.ArrayList;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder> {

    ItemSettingRecvBinding binding;


    ArrayList<SettingDTO> list;

    Context context;
    public SettingAdapter(ArrayList<SettingDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SettingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemSettingRecvBinding.inflate(inflater,parent,false);
        return new SettingAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.ViewHolder h, int i) {
        h.binding.tvText.setText(list.get(i).getTv_text());

        if (h.binding.tvText.getText().equals("로그아웃")){
            h.binding.tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(v.getContext());
                }
            });
        }

        if (h.binding.tvText.getText().equals("팝업 알림 설정")) {
            h.binding.tvToggle.setVisibility(View.VISIBLE);
            h.binding.tvToggle.setOnClickListener(v -> {
                if(h.binding.tvToggle.getText().equals("ON")) {
                    h.binding.tvToggle.setText("OFF");
                }else if(h.binding.tvToggle.getText().equals("OFF")) {
                    h.binding.tvToggle.setText("ON");
                }

            });
        } else if(h.binding.tvText.getText().equals("SMS서비스 설정")){
            h.binding.tvToggle.setVisibility(View.VISIBLE);
            h.binding.tvToggle.setOnClickListener(v -> {
                if(h.binding.tvToggle.getText().equals("ON")) {
                    h.binding.tvToggle.setText("OFF");
                }else if(h.binding.tvToggle.getText().equals("OFF")) {
                    h.binding.tvToggle.setText("ON");
                }
            });
        } else if(h.binding.tvText.getText().equals("탈퇴하기")){
            h.binding.tvToggle.setVisibility(View.GONE);
            h.binding.tvText.setTextColor(Color.RED);
        }else {
                h.binding.tvToggle.setVisibility(View.GONE);
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemSettingRecvBinding binding;


        public ViewHolder(@NonNull ItemSettingRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private void showDialog(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("로그아웃 하시겠습니까?").setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, LoginActivity.class);
                ((SettingActivity)context).startActivity(intent);
                CommonVar.loginInfo=null;
            }
        })
        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .show();
    }
}

