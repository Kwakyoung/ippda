package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityOrderSearchBinding;

import java.util.ArrayList;

public class OrderSearchActivity extends AppCompatActivity {
    ActivityOrderSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityOrderSearchBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.recvTrackDelivery.setAdapter(new TrackDeliveryAdepter(getTrackDeliveryList(),this));
        binding.recvTrackDelivery.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL , false));
    }
    ArrayList<RecvCircleDTO> getTrackDeliveryList(){
        ArrayList<RecvCircleDTO> list= new ArrayList<>();
        list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"입금/결제"));
        list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"배송 준비중"));
        list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"배송중"));
        list.add(new RecvCircleDTO(R.drawable.ic_launcher_background, "취소,교환,환불"));
        return list;
    }
}