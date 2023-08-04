package com.example.ipdda.like;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentLikeBinding;


public class LikeFragment extends Fragment {

    FragmentLikeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLikeBinding.inflate(inflater,container,false);
        binding.grid.setAdapter(new LikeAdapter(inflater));
        return binding.getRoot();

    }
}