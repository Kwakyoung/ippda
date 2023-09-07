package com.example.ipdda.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.common.RetrofitClient;
import com.example.ipdda.databinding.FragmentProfileBinding;
import com.example.ipdda.goodslist.GoodsListDTO;
import com.example.ipdda.member.MemberVO;
import com.example.ipdda.profile.coupon.CouponActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.recvTrackDelivery.setAdapter(new TrackDeliveryAdepter(getTrackDeliveryList(),getContext()));
        binding.recvTrackDelivery.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL , false));

        binding.recvUserActions.setAdapter(new UserActionAdepter(getUserAction(),getContext()));
        binding.recvUserActions.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL , false));

//        binding.gridvViewed.setAdapter(new ViewedAdepter(GoodsList(),getContext()));
//        binding.recvUserActions.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL , false));

        binding.user.setText(CommonVar.loginInfo.getMember_nickname());
        binding.userEmail.setText(CommonVar.loginInfo.getMember_email());
        CommonConn conn = new CommonConn(getContext(),"coupon/count");
        conn.addParamMap("coupon_status","보유");
        conn.addParamMap("member_no",CommonVar.loginInfo.getMember_no());
        conn.onExcute(((isResult, data) -> {
            binding.tvCoupon.setText("쿠폰\n"+Integer.parseInt(data));
        }));

        binding.editInfo.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ChangeInfoActivity.class);
            startActivity(intent);
        });


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

        binding.tvCoupon.setOnClickListener(v -> {
            Intent intent =new Intent(requireContext(), CouponActivity.class);
            startActivity(intent);
        });
        binding.btnWeb.setOnClickListener(v -> {
            String websiteUrl = RetrofitClient.ip+"/ippda/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            startActivity(intent);
        });

        return binding.getRoot();
    }

    ArrayList<RecvCircleDTO> getTrackDeliveryList(){
        ArrayList<RecvCircleDTO> list= new ArrayList<>();
            list.add(new RecvCircleDTO(R.drawable.monitor,"입금/결제"));
            list.add(new RecvCircleDTO(R.drawable.ready,"배송 준비중"));
            list.add(new RecvCircleDTO(R.drawable.shopping,"배송중"));
            list.add(new RecvCircleDTO(R.drawable.home,"배송완료"));
            //list.add(new RecvCircleDTO(R.drawable.ic_launcher_background, "취소,교환,환불"));
        return list;
    }
    ArrayList<RecvCircleDTO> getUserAction(){
        ArrayList<RecvCircleDTO> list= new ArrayList<>();
            list.add(new RecvCircleDTO(R.drawable.cart,"장바구니"));
            list.add(new RecvCircleDTO(R.drawable.ic_like_blank,"좋아요"));
            list.add(new RecvCircleDTO(R.drawable.star,"즐겨찾기"));
            list.add(new RecvCircleDTO(R.drawable.chat, "리뷰"));
        return list;
    }

    ArrayList<GoodsListDTO> GoodsList(){
        ArrayList<GoodsListDTO> list = new ArrayList<>();
        list.add(new GoodsListDTO(0,2000,"후드","입다"));

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