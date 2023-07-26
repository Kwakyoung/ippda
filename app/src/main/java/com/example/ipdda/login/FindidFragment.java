package com.example.ipdda.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentFindidBinding;


public class FindidFragment extends Fragment {
    FragmentFindidBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFindidBinding.inflate(inflater,container,false);

        binding.tvFindPw.setOnClickListener(v -> {
            FindActivity activity = (FindActivity) getActivity();
            activity.changeFragment(1, new FindpwFragment());
        });
        return binding.getRoot();
    }
}