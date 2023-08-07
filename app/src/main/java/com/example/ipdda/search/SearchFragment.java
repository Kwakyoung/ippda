package com.example.ipdda.search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentSearchBinding;

import java.util.ArrayList;


public class SearchFragment extends Fragment {
    FragmentSearchBinding binding;
    ArrayList<SearchHistoryDTO> list ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater,container,false);



        binding.recvSearchCategory.setAdapter(new SearchCategoryAdapter(getcategory(),getContext()));
        binding.recvSearchCategory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        list = getlist();
        binding.grid.setAdapter(new SearchHotAdapter(getLayoutInflater()));

        binding.edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    // 엔터 키가 눌렸을 때 클릭 이벤트를 처리
                        v.performClick();
                        if(!binding.edtSearch.getText().toString().trim().isEmpty()) {
                            list.add(new SearchHistoryDTO(binding.edtSearch.getText().toString()));
                            binding.recvSearchHistory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                            binding.recvSearchHistory.setAdapter(new SearchHistoryAdapter(list, getContext()));
                            binding.edtSearch.setText("");
                        }
                    return true;
                }
                return false;
            }
        });



        return binding.getRoot();
    }

    ArrayList<SearchHistoryDTO> getlist(){
        ArrayList<SearchHistoryDTO> list = new ArrayList<>();
        if(binding.edtSearch.getText().toString().contains("")){
            //split  <-  문자열을 배열로 받음.
            //trim(); <- 공백제거
        binding.edtSearch.setText(binding.edtSearch.getText().toString().trim());
        }

        return list;
    }

    ArrayList<SearchCategoryDTO> getcategory(){
        ArrayList<SearchCategoryDTO> list = new ArrayList<>();
        list.add(new SearchCategoryDTO(R.drawable.top,"상의"));
        list.add(new SearchCategoryDTO(R.drawable.pants,"하의"));
        list.add(new SearchCategoryDTO(R.drawable.shoes,"신발"));
        list.add(new SearchCategoryDTO(R.drawable.accessory,"악세서리"));

        return list;
    }

}