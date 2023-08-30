package com.example.ipdda.like;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

    private long backKeyPressedTime = 0;
    public void handleBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(getContext(), "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2초 이내에 뒤로가기 버튼을 한번 더 클릭시 finish()(앱 종료)
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            if (getActivity() != null){
                getActivity().finish();
            }
            System.runFinalization();
            System.exit(0);
        }

    }
}