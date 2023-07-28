package com.example.ipdda.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityChangeInfoBinding;
import com.example.ipdda.databinding.FragmentHomeBinding;
import com.example.ipdda.databinding.FragmentProfileBinding;
import com.example.ipdda.goodslist.GoodsListDTO;
import com.example.ipdda.home.HomeGoodsRecommendDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.recvTrackDelivery.setAdapter(new TrackDeliveryAdepter(getTrackDeliveryList(),getContext()));
        binding.recvTrackDelivery.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL , false));

        binding.recvUserActions.setAdapter(new UserActionAdepter(getUserAction(),getContext()));
        binding.recvUserActions.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL , false));

        binding.gridvViewed.setAdapter(new ViewedAdepter(GoodsList(),getContext()));
        binding.gridvViewed.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.editInfo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ChangeInfoActivity.class);
            startActivity(intent);
        });


        binding.btnInquiry.setOnClickListener(v -> {
            Intent intent =new Intent(requireContext(), InquiryActivity.class);
            startActivity(intent);
        });
        binding.btnQna.setOnClickListener(v -> {
            Intent intent =new Intent(requireContext(), QnAActivity.class);
            startActivity(intent);
        });
        binding.btnSetting.setOnClickListener(v -> {
            Intent intent =new Intent(requireContext(), SettingActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }

    ArrayList<RecvCircleDTO> getTrackDeliveryList(){
        ArrayList<RecvCircleDTO> list= new ArrayList<>();
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"입금/결제"));
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"배송 준비중"));
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"배송중"));
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background, "취소,교환,환불"));
        return list;
    }
    ArrayList<RecvCircleDTO> getUserAction(){
        ArrayList<RecvCircleDTO> list= new ArrayList<>();
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"장바구니"));
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"좋아요"));
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background,"즐겨찾기"));
            list.add(new RecvCircleDTO(R.drawable.ic_launcher_background, "리뷰"));
        return list;
    }

    ArrayList<GoodsListDTO> GoodsList(){
        ArrayList<GoodsListDTO> list = new ArrayList<>();
        list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000,50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
        list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000,50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
        list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000,50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
        return list;
    }
}