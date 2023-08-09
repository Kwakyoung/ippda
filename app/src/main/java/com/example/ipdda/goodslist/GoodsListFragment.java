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
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.FragmentGoodsListBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.profile.SubActivity;
import com.example.ipdda.search.SearchFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class GoodsListFragment extends Fragment {

    int localkey;
    int key;
    FragmentGoodsListBinding binding;



    public GoodsListFragment(int key) {

        this.key = key;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentGoodsListBinding.inflate(inflater, container, false);

        binding.recvMainCategory.setAdapter(new GoodsListMainCategoryAdapter(GetGoodsMainCateogry(), getContext(), this, key));
        binding.recvMainCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));




        //goods_list에서 클릭한 값으로 첫화면 조회
        CommonConn conn = new CommonConn(getContext(), "goods/categorylist");
        conn.addParamMap("GOODS_MIDDLE_CATEGORY", key);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            GoodsListAdapter adapter = new GoodsListAdapter(list, getContext());

            binding.recvGoodsList.setAdapter(adapter);
            binding.recvGoodsList.setLayoutManager(new LinearLayoutManager(getContext()));


        });





        //로고 눌렀을 때 뒤로가기
        binding.imgvLogo.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            DeliveryFragment deliveryFragment = new DeliveryFragment();
            transaction.replace(R.id.container, deliveryFragment);
            transaction.commit();
        });


        //검색 버튼 눌렀을 때 SearchFragment로 이동
        binding.imgvSearch.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            transaction.replace(R.id.container, searchFragment);
            transaction.commit();
        });

        //장바구니 버튼 눌렀을 때 LikeFragment로 이동
        binding.imgvMybag.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SubActivity.class);
            intent.putExtra("key", 0);
            startActivity(intent);
        });


        return binding.getRoot();
    }


    public ArrayList<GoodsListMainCategoryDTO> GetGoodsMainCateogry() {
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
        list.add(new GoodsListMainCategoryDTO("모자"));



        return list;
    }

    public ArrayList<GoodsListSubCategoryDTO> GetGoodsSubCateogry(GoodsListMainCategoryDTO goodsListMainCategoryDTO) {
        ArrayList<GoodsListSubCategoryDTO> list = new ArrayList<>();
        if(goodsListMainCategoryDTO.getGoodsMainCategory().equals("상의")){
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
        } else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("아우터")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("후드 집업"));
            list.add(new GoodsListSubCategoryDTO("블루종/MA-1"));
            list.add(new GoodsListSubCategoryDTO("레더/라이더스 재킷"));
            list.add(new GoodsListSubCategoryDTO("무스탕/퍼"));
            list.add(new GoodsListSubCategoryDTO("트러커 재킷"));
            list.add(new GoodsListSubCategoryDTO("슈트/블레이저 재킷"));
            list.add(new GoodsListSubCategoryDTO("카디건"));
            list.add(new GoodsListSubCategoryDTO("아노락 재킷"));
            list.add(new GoodsListSubCategoryDTO("플리스/뽀글이"));
            list.add(new GoodsListSubCategoryDTO("트레이닝 재킷"));
            list.add(new GoodsListSubCategoryDTO("환절기 코트"));
            list.add(new GoodsListSubCategoryDTO("트레이닝 재킷"));
            list.add(new GoodsListSubCategoryDTO("겨울 싱글 코트"));
            list.add(new GoodsListSubCategoryDTO("겨울 더블 코트"));
            list.add(new GoodsListSubCategoryDTO("겨울 기타 코트"));
            list.add(new GoodsListSubCategoryDTO("롱패딩/롱헤비 아우터"));
            list.add(new GoodsListSubCategoryDTO("숏패딩/숏헤비 아우터"));
            list.add(new GoodsListSubCategoryDTO("패딩 베스트"));
            list.add(new GoodsListSubCategoryDTO("베스트"));
            list.add(new GoodsListSubCategoryDTO("사파리/헌팅 재킷"));
            list.add(new GoodsListSubCategoryDTO("나일론/코치 재킷"));
            list.add(new GoodsListSubCategoryDTO("기타 아우터"));
        } else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("하의")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("데님 팬츠"));
            list.add(new GoodsListSubCategoryDTO("코튼 팬츠"));
            list.add(new GoodsListSubCategoryDTO("슈트 팬츠/슬랙스"));
            list.add(new GoodsListSubCategoryDTO("트레이닝/조거 팬츠"));
            list.add(new GoodsListSubCategoryDTO("숏 팬츠"));
            list.add(new GoodsListSubCategoryDTO("레깅스"));
            list.add(new GoodsListSubCategoryDTO("점프 슈트/오버올"));
            list.add(new GoodsListSubCategoryDTO("스포츠 하의"));
            list.add(new GoodsListSubCategoryDTO("기타 바지"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("원피스")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("미니 원피스"));
            list.add(new GoodsListSubCategoryDTO("미디 원피스"));
            list.add(new GoodsListSubCategoryDTO("맥시 원피스"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("스커트")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("미니스커트"));
            list.add(new GoodsListSubCategoryDTO("미디스커트"));
            list.add(new GoodsListSubCategoryDTO("롱스커트"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("신발")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("구두"));
            list.add(new GoodsListSubCategoryDTO("로퍼"));
            list.add(new GoodsListSubCategoryDTO("힐/펌프스"));
            list.add(new GoodsListSubCategoryDTO("플랫 슈즈"));
            list.add(new GoodsListSubCategoryDTO("블로퍼"));
            list.add(new GoodsListSubCategoryDTO("샌들"));
            list.add(new GoodsListSubCategoryDTO("슬리퍼"));
            list.add(new GoodsListSubCategoryDTO("기타 신발"));
            list.add(new GoodsListSubCategoryDTO("모카신/보트 슈즈"));
            list.add(new GoodsListSubCategoryDTO("신발 용품"));
            list.add(new GoodsListSubCategoryDTO("캔버스/단화"));
            list.add(new GoodsListSubCategoryDTO("패션스니커즈화"));
            list.add(new GoodsListSubCategoryDTO("스포츠 스니커즈"));
            list.add(new GoodsListSubCategoryDTO("기타 스니커즈"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("가방")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("백팩"));
            list.add(new GoodsListSubCategoryDTO("메신저/크로스 백"));
            list.add(new GoodsListSubCategoryDTO("숄더백"));
            list.add(new GoodsListSubCategoryDTO("토트백"));
            list.add(new GoodsListSubCategoryDTO("에코백"));
            list.add(new GoodsListSubCategoryDTO("보스턴/드럼/더플백"));
            list.add(new GoodsListSubCategoryDTO("웨이스트 백"));
            list.add(new GoodsListSubCategoryDTO("파우치 백"));
            list.add(new GoodsListSubCategoryDTO("모카신/보트 슈즈"));
            list.add(new GoodsListSubCategoryDTO("브리프케이스"));
            list.add(new GoodsListSubCategoryDTO("캐리어"));
            list.add(new GoodsListSubCategoryDTO("가방 소품"));
            list.add(new GoodsListSubCategoryDTO("지갑/머니클립"));
            list.add(new GoodsListSubCategoryDTO("클러치 백"));
            list.add(new GoodsListSubCategoryDTO("기타 가방"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("악세사리")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("팔찌"));
            list.add(new GoodsListSubCategoryDTO("반지"));
            list.add(new GoodsListSubCategoryDTO("목걸이/펜던트"));
            list.add(new GoodsListSubCategoryDTO("귀걸이"));
            list.add(new GoodsListSubCategoryDTO("발찌"));
            list.add(new GoodsListSubCategoryDTO("브로치/배지"));
            list.add(new GoodsListSubCategoryDTO("헤어 악세사리"));
            list.add(new GoodsListSubCategoryDTO("기타 악세사리"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("악세사리")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("팔찌"));
            list.add(new GoodsListSubCategoryDTO("반지"));
            list.add(new GoodsListSubCategoryDTO("목걸이/펜던트"));
            list.add(new GoodsListSubCategoryDTO("귀걸이"));
            list.add(new GoodsListSubCategoryDTO("발찌"));
            list.add(new GoodsListSubCategoryDTO("브로치/배지"));
            list.add(new GoodsListSubCategoryDTO("헤어 악세사리"));
            list.add(new GoodsListSubCategoryDTO("기타 악세사리"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("양말")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("양말"));
            list.add(new GoodsListSubCategoryDTO("스타킹"));
            list.add(new GoodsListSubCategoryDTO("기타 양말"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("시계")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("디지털"));
            list.add(new GoodsListSubCategoryDTO("쿼츠 아날로그"));
            list.add(new GoodsListSubCategoryDTO("오토매틱 아날로그"));
            list.add(new GoodsListSubCategoryDTO("시계 용품"));
            list.add(new GoodsListSubCategoryDTO("기타 시계"));
        }else if (goodsListMainCategoryDTO.getGoodsMainCategory().equals("모자")) {
            list.add(new GoodsListSubCategoryDTO("전체"));
            list.add(new GoodsListSubCategoryDTO("캡/야구 모자"));
            list.add(new GoodsListSubCategoryDTO("헌팅캡/베레모"));
            list.add(new GoodsListSubCategoryDTO("페도라"));
            list.add(new GoodsListSubCategoryDTO("버킷/사파리햇"));
            list.add(new GoodsListSubCategoryDTO("비니"));
            list.add(new GoodsListSubCategoryDTO("트루퍼"));
            list.add(new GoodsListSubCategoryDTO("기타 모자"));
        }




        GoodsListSubCategoryAdapter adapter = new GoodsListSubCategoryAdapter(list, getContext(), this, localkey);
        binding.recvSubCategory.setAdapter(adapter);
        binding.recvSubCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return list;
        }





    public void onClickCategory(int localKey) {
        CategoryConn(localKey);
        localkey =localKey;
    }


    //main카테고리 클릭시 조회
    public void CategoryConn(int localkey) {
        CommonConn conn = new CommonConn(getContext(), "goods/categorylist");
        conn.addParamMap("GOODS_MIDDLE_CATEGORY", localkey);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>() {}.getType());
            GoodsListAdapter adapter = new GoodsListAdapter(list, getContext());
            binding.recvGoodsList.setAdapter(adapter);
            binding.recvGoodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }



    //sub카테고리 클릭시 조회
    public void SubCategoryConn(int subCategoryKey){
        CommonConn conn = new CommonConn(getContext(), "goods/subcategorylist");
        conn.addParamMap("GOODS_MIDDLE_CATEGORY", localkey);
        conn.addParamMap("GOODS_SUB_CATEGORY", subCategoryKey);
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<GoodsVO>>() {}.getType());
            GoodsListAdapter adapter = new GoodsListAdapter(list, getContext());

            binding.recvGoodsList.setAdapter(adapter);
            binding.recvGoodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }






}
