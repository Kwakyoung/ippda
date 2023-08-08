package com.example.ipdda.like;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentLikeBinding;
import com.example.ipdda.search.SearchFragment;

import java.util.ArrayList;


public class LikeFragment extends Fragment {

    FragmentLikeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLikeBinding.inflate(inflater,container,false);

        ArrayList<LikeDTO> list = new ArrayList<>();
        list.add(new LikeDTO(R.drawable.clothes_top,R.drawable.ic_like_green,"광주화정점","50,000원"));
        list.add(new LikeDTO(R.drawable.test,R.drawable.ic_like_green,"목포점","70,000원"));
        list.add(new LikeDTO(R.drawable.test,R.drawable.ic_like_green,"목포점","70,000원"));

        binding.imgvSearch.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            transaction.replace(R.id.container , searchFragment);
            transaction.commit();
        });

        binding.grid.setAdapter(new LikeAdapter(inflater,list));
        binding.tvLikeCount.setText(list.size()+"");


        return binding.getRoot();
    }
}