package com.example.ipdda.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentFindpwBinding;
import com.example.ipdda.databinding.FragmentFindpwEmailBinding;


public class FindpwFragment extends Fragment {
    FragmentFindpwBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFindpwBinding.inflate(inflater,container,false);

        binding.tvFindId.setOnClickListener(v -> {
            FindActivity activity = (FindActivity) getActivity();
            activity.changeFragment(2,new FindidFragment());
        });

        binding.checkEmail.setOnClickListener(v -> {
            FindActivity activity = (FindActivity) getActivity();
            activity.changeFragment(6, new Findpw_emailFragment());
        });


        return binding.getRoot();
    }
}