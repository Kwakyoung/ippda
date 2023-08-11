package com.example.ipdda.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.databinding.FragmentFindpwBinding;


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

        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ResultPwActivity.class);
            intent.putExtra("id",binding.edtId.getText().toString());
            startActivity(intent);
        });

        return binding.getRoot();
    }
}