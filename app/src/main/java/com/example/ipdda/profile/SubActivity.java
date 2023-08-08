package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySubBinding;
import com.example.ipdda.like.LikeAdapter;
import com.example.ipdda.like.LikeDTO;

import java.util.ArrayList;

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
            if (toglerecv) {
                binding.recv.setVisibility(View.VISIBLE);
                binding.gridv.setVisibility(View.GONE);
                binding.recv.setAdapter(new BascketRecvAdapter(getSubList(),this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
            }else{
                binding.recv.setVisibility(View.GONE);
                binding.gridv.setVisibility(View.VISIBLE);

                binding.gridv.setAdapter(new LikeAdapter(getLayoutInflater(),getLikeList()));
            }

            binding.tvSee.setOnClickListener(v -> {
                toglerecv = !toglerecv;
                if (toglerecv) {
                    binding.recv.setVisibility(View.VISIBLE);
                    binding.gridv.setVisibility(View.GONE);

                } else {
                    binding.recv.setVisibility(View.GONE);
                    binding.gridv.setVisibility(View.VISIBLE);
                }
            });

        }else if(receivedValue==1){
            binding.tvTitle.setText("좋아요");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("좋아요 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);

            if (toglerecv) {
                binding.gridv.setVisibility(View.GONE);
                binding.recv.setVisibility(View.VISIBLE);
                binding.recv.setAdapter(new LikeRecvAdapter(getSubList(), this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            }else{
                binding.recv.setVisibility(View.GONE);
                binding.gridv.setVisibility(View.VISIBLE);
                binding.gridv.setAdapter(new LikeAdapter(getLayoutInflater(),getLikeList()));
            }
            binding.tvSee.setOnClickListener(v -> {
                toglerecv = !toglerecv; // 클릭할 때마다 상태를 토글 (보이기 <-> 숨기기)
                if (toglerecv) {
                    binding.recv.setVisibility(View.VISIBLE);
                    binding.gridv.setVisibility(View.GONE);

                } else {
                    binding.recv.setVisibility(View.GONE);
                    binding.gridv.setVisibility(View.VISIBLE);
                }
            });
        }else if(receivedValue==2){
            binding.tvTitle.setText("즐겨찾기");
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.tvNum.setText("즐겨찾기 1개");
            binding.tvNum.setVisibility(View.VISIBLE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.GONE);
            binding.layout.setVisibility(View.GONE);

            if (toglerecv) {
                binding.gridv.setVisibility(View.GONE);
                binding.recv.setVisibility(View.VISIBLE);
                binding.recv.setAdapter(new FavoritesRecvAdapter(getSubList(),this));
                binding.recv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL , false));
            }else{
                binding.recv.setVisibility(View.GONE);
                binding.gridv.setVisibility(View.VISIBLE);
                binding.gridv.setAdapter(new LikeAdapter(getLayoutInflater(),getLikeList()));
            }
            binding.tvSee.setOnClickListener(v -> {
                toglerecv = !toglerecv; // 클릭할 때마다 상태를 토글 (보이기 <-> 숨기기)
                if (toglerecv) {
                    binding.recv.setVisibility(View.VISIBLE);
                    binding.gridv.setVisibility(View.GONE);

                } else {
                    binding.recv.setVisibility(View.GONE);
                    binding.gridv.setVisibility(View.VISIBLE);
                }
            });


        }else if(receivedValue==3){
            binding.tvTitle.setText("리뷰");
            binding.layoutText.setVisibility(View.GONE);
            binding.tvSee.setVisibility(View.VISIBLE);
            binding.recvTransaction.setVisibility(View.GONE);
            binding.layoutReview.setVisibility(View.VISIBLE);
            binding.layout.setVisibility(View.GONE);


        }

        binding.btnBack.setOnClickListener(v -> this.finish());
    }
    ArrayList<SubDTO> getSubList(){
        ArrayList<SubDTO> list= new ArrayList<>();
        list.add(new SubDTO(R.drawable.ic_launcher_background, 3, 30000, "입다 화정점3", "입다 맨투맨3", 3, "2000-03-08"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 2, 20000, "입다 화정점2", "입다 맨투맨2", 2, "2000-03-08"));
        list.add(new SubDTO(R.drawable.ic_launcher_background,0, 0,  "입다 화정점1", "입다 맨투맨1", 1,"2000-03-10"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 4, 40000,  "입다 화정점4", "입다 맨투맨4", 4,"2000-03-11"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 5, 50000, "입다 화정점5", "입다 맨투맨5", 5, "2000-03-18"));

        return list;
    }

    ArrayList<LikeDTO> getLikeList(){
        ArrayList<LikeDTO> list = new ArrayList<>();
        list.add(new LikeDTO(R.drawable.clothes_top,R.drawable.ic_like_green,"화정점","16,000원"));
        return list;
    }

}