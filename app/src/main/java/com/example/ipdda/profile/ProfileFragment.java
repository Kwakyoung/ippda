package com.example.ipdda.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentHomeBinding;
import com.example.ipdda.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

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
}