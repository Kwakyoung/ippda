package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySubBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SubActivity extends AppCompatActivity {
    ActivitySubBinding binding;
    boolean toglerecv=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        int receivedValue = getIntent().getIntExtra("key", 0);
        if(receivedValue==0){
            binding.tvTitle.setText("장바구니");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);

            binding.recv.setAdapter(new BascketAdapter(getSubList(),this));
            binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));

        }else if(receivedValue==1){
            binding.tvTitle.setText("좋아요");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("좋아요 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);


        }else if(receivedValue==2){
            binding.tvTitle.setText("즐겨찾기");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("즐겨찾기 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);


        }else if(receivedValue==3){
            binding.tvTitle.setText("리뷰");
            binding.layoutText.setVisibility(View.GONE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.VISIBLE);
            binding.layout.setVisibility(View.GONE);


        }
        binding.tvSee.setOnClickListener(v -> {
            if (toglerecv) {
                toglerecv = false;
            } else {
                toglerecv = true;
            }
        });
        binding.btnBack.setOnClickListener(v -> this.finish());
    }
    ArrayList<SubDTO> getSubList(){
        ArrayList<SubDTO> list= new ArrayList<>();
        list.add(new SubDTO(R.drawable.ic_launcher_background, 2, 30000, "입다 화정점", "입다 맨투맨", 2, "2000-03-08"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 2, 30000, "입다 화정점", "입다 맨투맨", 2, "2000-03-08"));
        list.add(new SubDTO(R.drawable.ic_launcher_background,1, 0,  "입다 화정점", "입다 맨투맨", 2,"2000-03-10"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 0, 30000,  "입다 화정점", "입다 맨투맨", 2,"2000-03-11"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 5, 30000, "입다 화정점", "입다 맨투맨", 2, "2000-03-18"));

        return list;
    }


}