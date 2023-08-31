package com.example.ipdda.search;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.FragmentSearchBinding;
import com.example.ipdda.goodsboard.Goods_optionVO;
import com.example.ipdda.home.GoodsVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;


public class SearchFragment extends DialogFragment {
    FragmentSearchBinding binding;
    ArrayList<SearchHistoryDTO> list ;
    private SimpleDateFormat mFormat = new SimpleDateFormat("MM.dd");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater,container,false);




        binding.recvSearchCategory.setAdapter(new SearchCategoryAdapter(getcategory(),getContext()));
        binding.recvSearchCategory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        list = getlist();
        binding.grid.setAdapter(new SearchHotAdapter(getLayoutInflater()));


        binding.tvHistoryDelete.setOnClickListener(v -> {
            binding.recvSearchHistory.clearOnScrollListeners();
        });

        Date date = new Date();
        String date1 = mFormat.format(date);
        binding.date.setText(date1);

        binding.imvArrow.setOnClickListener(v -> {
            if(binding.recvSearchList.getVisibility()==View.GONE){
                binding.imvArrow.setImageResource(R.drawable.arrow_down);
                binding.recvSearchList.setVisibility(View.VISIBLE);
            }else{
                binding.imvArrow.setImageResource(R.drawable.arrow_up);
                binding.recvSearchList.setVisibility(View.GONE);
            }
        });
        binding.edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    // 엔터 키가 눌렸을 때 클릭 이벤트를 처리
                    CommonConn conn = new CommonConn(getContext(), "goods/search");
                    String search = binding.edtSearch.getText().toString().substring(0, binding.edtSearch.getText().toString().length() - 1);
                    Log.d("search", "onKey: "+search);
                    conn.addParamMap("keyword",search);
                    conn.onExcute((isResult, data) -> {
                        ArrayList<GoodsVO> searchlist = new Gson().fromJson(data , new TypeToken<ArrayList<GoodsVO>>(){}.getType());
                        binding.containerSearch.setVisibility(View.VISIBLE);
                        binding.recvSearchList.setLayoutManager(new LinearLayoutManager(getContext()));
                        binding.recvSearchList.setAdapter(new SearchListAdapter(searchlist, getContext()));
                    });

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
        list.add(new SearchCategoryDTO(R.drawable.outer,"아우터"));
        list.add(new SearchCategoryDTO(R.drawable.pants,"하의"));
        list.add(new SearchCategoryDTO(R.drawable.onepeecs,"원피스"));
        list.add(new SearchCategoryDTO(R.drawable.skirt,"스커트"));
        list.add(new SearchCategoryDTO(R.drawable.shoes,"신발"));
        list.add(new SearchCategoryDTO(R.drawable.backpack,"가방"));
        list.add(new SearchCategoryDTO(R.drawable.accessory,"악세서리"));
        list.add(new SearchCategoryDTO(R.drawable.socks,"양말"));
        list.add(new SearchCategoryDTO(R.drawable.watch,"시계"));
        list.add(new SearchCategoryDTO(R.drawable.cap,"모자"));


        return list;
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