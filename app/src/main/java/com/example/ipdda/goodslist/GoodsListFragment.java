package com.example.ipdda.goodslist;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ipdda.R;
import com.example.ipdda.databinding.FragmentGoodsListBinding;
import com.example.ipdda.profile.SubActivity;
import com.example.ipdda.search.SearchFragment;

import java.util.ArrayList;


public class GoodsListFragment extends Fragment {

    int key;
    FragmentGoodsListBinding binding;

    GoodsListFragment goodsListFragment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentGoodsListBinding.inflate(inflater, container, false);

        binding.recvMainCategory.setAdapter(new GoodsListMainCategoryAdapter(GetGoodsMainCateogry(),getContext(), this));
        binding.recvMainCategory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));

        binding.recvSubCategory.setAdapter(new GoodsListSubCategoryAdapter(GetGoodsSubCateogry(),getContext()));
        binding.recvSubCategory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));



        //검색 버튼 눌렀을 때 SearchFragment로 이동
        binding.imgvSearch.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            transaction.replace(R.id.container , searchFragment);

            transaction.commit();
        });

        //장바구니 버튼 눌렀을 때 LikeFragment로 이동
        binding.imgvMybag.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity() ,SubActivity.class);
            intent.putExtra("key", 0);
            startActivity(intent);
        });


        return binding.getRoot();
    }


    public ArrayList<GoodsListMainCategoryDTO> GetGoodsMainCateogry(){
        ArrayList<GoodsListMainCategoryDTO> list = new ArrayList<>();
        list.add(new GoodsListMainCategoryDTO("상의"));
        list.add(new GoodsListMainCategoryDTO("아우터"));
        list.add(new GoodsListMainCategoryDTO("하의"));
        list.add(new GoodsListMainCategoryDTO("원피스"));
        list.add(new GoodsListMainCategoryDTO("스커트"));
        list.add(new GoodsListMainCategoryDTO("신발"));
        list.add(new GoodsListMainCategoryDTO("가방"));
        list.add(new GoodsListMainCategoryDTO("악세사리"));
        list.add(new GoodsListMainCategoryDTO("양말"));
        list.add(new GoodsListMainCategoryDTO("시계"));

        return list;
    }

    public ArrayList<GoodsListSubCategoryDTO> GetGoodsSubCateogry(){
        ArrayList<GoodsListSubCategoryDTO> list = new ArrayList<>();
        list.add(new GoodsListSubCategoryDTO("전체"));
        list.add(new GoodsListSubCategoryDTO("니트/스웨터"));
        list.add(new GoodsListSubCategoryDTO("후드 티셔츠"));
        list.add(new GoodsListSubCategoryDTO("맨투맨/스웨트셔츠"));
        list.add(new GoodsListSubCategoryDTO("긴소매 티셔츠"));
        list.add(new GoodsListSubCategoryDTO("셔츠/블라우스"));
        list.add(new GoodsListSubCategoryDTO("피케/카라티셔츠"));
        list.add(new GoodsListSubCategoryDTO("반소매 티셔츠"));
        list.add(new GoodsListSubCategoryDTO("민소매 티셔츠"));
        list.add(new GoodsListSubCategoryDTO("기타 상의"));

        return list;
    }

    public ArrayList<GoodsListDTO> GetGoodsListCateogry(GoodsListMainCategoryDTO goodsListMainCategoryDTO){
        ArrayList<GoodsListDTO> list = new ArrayList<>();
        if(goodsListMainCategoryDTO.getGoodsMainCategory().equals("상의")) {
            list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
            list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
            list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
            list.add(new GoodsListDTO(R.drawable.ic_home, R.drawable.ic_home, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
        } else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("아우터")) {
            list.add(new GoodsListDTO(R.drawable.ic_alarm, R.drawable.ic_alarm, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
            list.add(new GoodsListDTO(R.drawable.ic_alarm, R.drawable.ic_alarm, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
            list.add(new GoodsListDTO(R.drawable.ic_alarm, R.drawable.ic_alarm, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
            list.add(new GoodsListDTO(R.drawable.ic_alarm, R.drawable.ic_alarm, 49000, 50000, "입다 화정점", "입다 맨투맨", "입다 농성점", "입다 니트"));
        }





        return list;
    }

    public void onClickGoodsList(GoodsListMainCategoryDTO goodsListMainCategoryDTO){
        ArrayList<GoodsListDTO> list = GetGoodsListCateogry(goodsListMainCategoryDTO);
        binding.recvGoodsList.setAdapter(new GoodsListAdapter(list ,getContext()));
        binding.recvGoodsList.setLayoutManager(new LinearLayoutManager(getContext()));
    }



}