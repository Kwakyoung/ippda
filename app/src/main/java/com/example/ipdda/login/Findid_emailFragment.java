package com.example.ipdda.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentFindidEmailBinding;

public class Findid_emailFragment extends Fragment {

    FindActivity activity;

    FragmentFindidEmailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFindidEmailBinding.inflate(inflater,container,false);

        binding.tvFindPw.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(1,new FindpwFragment());
        });

        binding.checkPhone.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(2, new FindidFragment());
        });

        binding.btnNext.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(7, new ResultFragment());
        });

        return binding.getRoot();
    }
}