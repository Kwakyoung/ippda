package com.example.ipdda.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.databinding.FragmentFindidBinding;


public class FindidFragment extends Fragment {
    FragmentFindidBinding binding;

    FindActivity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFindidBinding.inflate(inflater,container,false);

        binding.tvFindPw.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(1, new FindpwFragment());
        });

        binding.checkEmail.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(3, new Findid_emailFragment());
        });

        binding.btnNext.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(7, new ResultFragment());
        });
        return binding.getRoot();
    }
}