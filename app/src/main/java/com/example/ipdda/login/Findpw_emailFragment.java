package com.example.ipdda.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentFindidEmailBinding;
import com.example.ipdda.databinding.FragmentFindpwEmailBinding;


public class Findpw_emailFragment extends Fragment {
    FindActivity activity;
    FragmentFindpwEmailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFindpwEmailBinding.inflate(inflater,container,false);


        binding.checkPhone.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(1, new FindpwFragment());
        });

        binding.tvFindId.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(2, new FindidFragment());
        });
        return binding.getRoot();
    }
}