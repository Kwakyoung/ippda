package com.example.ipdda.like;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.FragmentLikeBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.profile.coupon.CouponAdapter;
import com.example.ipdda.profile.coupon.CouponVO;
import com.example.ipdda.search.SearchFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class LikeFragment extends Fragment {

    FragmentLikeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLikeBinding.inflate(inflater,container,false);

        CommonConn conn = new CommonConn(getContext(), "goods_like/alllist");
        conn.addParamMap("member_no" , CommonVar.loginInfo.getMember_no());
        conn.onExcute((isResult, data) -> {
            ArrayList<GoodsVO> list = new Gson().fromJson(data , new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            if (list.size()!=0) {
                binding.grid.setAdapter(new LikeAdapter(inflater, list,getContext(),binding));

            }
            binding.tvLikeCount.setText(list.size() + "");

        });




        binding.imgvSearch.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment = new SearchFragment();
            transaction.replace(R.id.container , searchFragment);
            transaction.commit();
        });




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