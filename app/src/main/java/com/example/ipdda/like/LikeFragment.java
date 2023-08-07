package com.example.ipdda.like;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentLikeBinding;

import java.util.ArrayList;


public class LikeFragment extends Fragment {

    FragmentLikeBinding binding;
    ArrayList<LikeDTO> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        ArrayList<LikeDTO> list = new ArrayList<>();
        list.add(new LikeDTO(R.drawable.clothes_top,R.drawable.ic_like_green,"광주화정점","50,000원"));
        list.add(new LikeDTO(R.drawable.test,R.drawable.ic_like_green,"광주화정점","70,000원"));
        binding = FragmentLikeBinding.inflate(inflater,container,false);
        binding.grid.setAdapter(new LikeAdapter(inflater));


        return binding.getRoot();
    }
}