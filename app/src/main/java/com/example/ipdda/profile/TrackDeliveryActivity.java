package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityTrackDeliveryBinding;

import java.util.ArrayList;

public class TrackDeliveryActivity extends AppCompatActivity {
    ActivityTrackDeliveryBinding binding;
    int receivedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackDeliveryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(v -> this.finish());
        receivedValue = getIntent().getIntExtra("key", 0);
        updateBackgroundTint(receivedValue);
        binding.imgvImg1.setOnClickListener(v -> {
            receivedValue=0;
            updateBackgroundTint(receivedValue);
        });

        binding.imgvImg2.setOnClickListener(v -> {
            receivedValue=1;
            updateBackgroundTint(receivedValue);
        });

        binding.imgvImg3.setOnClickListener(v -> {
            receivedValue=2;
            updateBackgroundTint(receivedValue);
        });

        binding.imgvImg4.setOnClickListener(v -> {
            receivedValue=3;
            updateBackgroundTint(receivedValue);
        });


    }
    private void updateBackgroundTint(int receivedValue) {
        if (receivedValue == 0) {
            binding.imgvImg1.setBackgroundTintList(getResources().getColorStateList(R.color.green));
            binding.imgvImg2.setBackgroundTintList(null);
            binding.imgvImg3.setBackgroundTintList(null);
            binding.imgvImg4.setBackgroundTintList(null);
            binding.recv.setAdapter(new TrackDeliveryListAdapter(getSubList(), this));
            binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        } else if (receivedValue == 1) {
            binding.imgvImg1.setBackgroundTintList(null);
            binding.imgvImg2.setBackgroundTintList(getResources().getColorStateList(R.color.green));
            binding.imgvImg3.setBackgroundTintList(null);
            binding.imgvImg4.setBackgroundTintList(null);
            binding.recv.setAdapter(new TrackDeliveryListAdapter(getSubList(), this));
            binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } else if (receivedValue == 2) {
            binding.imgvImg1.setBackgroundTintList(null);
            binding.imgvImg2.setBackgroundTintList(null);
            binding.imgvImg3.setBackgroundTintList(getResources().getColorStateList(R.color.green));
            binding.imgvImg4.setBackgroundTintList(null);
            binding.recv.setAdapter(new TrackDeliveryListAdapter(getSubList(), this));
            binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } else if (receivedValue == 3) {
            binding.imgvImg1.setBackgroundTintList(null);
            binding.imgvImg2.setBackgroundTintList(null);
            binding.imgvImg3.setBackgroundTintList(null);
            binding.imgvImg4.setBackgroundTintList(getResources().getColorStateList(R.color.green));
            binding.recv.setAdapter(new TrackDeliveryListAdapter(getSubList(), this));
            binding.recv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }
    }
    ArrayList<SubDTO> getSubList(){
        ArrayList<SubDTO> list= new ArrayList<>();
        list.add(new SubDTO(R.drawable.ic_launcher_background,  30000, "입다 화정점3", "입다 맨투맨3", 3, "2000-03-08"));
        list.add(new SubDTO(R.drawable.ic_launcher_background,  20000, "입다 화정점2", "입다 맨투맨2", 2, "2000-03-08"));
        list.add(new SubDTO(R.drawable.ic_launcher_background, 0,  "입다 화정점1", "입다 맨투맨1", 1,"2000-03-10"));
        list.add(new SubDTO(R.drawable.ic_launcher_background,  40000,  "입다 화정점4", "입다 맨투맨4", 4,"2000-03-11"));
        list.add(new SubDTO(R.drawable.ic_launcher_background,  50000, "입다 화정점5", "입다 맨투맨5", 5, "2000-03-18"));

        return list;
    }
}