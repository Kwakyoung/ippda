package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.ipdda.databinding.ActivitySettingBinding;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    ActivitySettingBinding binding;

    @Override   
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.recvSettingRecv.setAdapter(new SettingAdapter(getSetting(), this));
        binding.recvSettingRecv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        binding.btnBack.setOnClickListener(v -> this.finish());
    }
    ArrayList<SettingDTO> getSetting(){
        ArrayList<SettingDTO> list= new ArrayList<>();
        list.add(new SettingDTO("공지사항",false));
        list.add(new SettingDTO("서비스 이용약관",false));
        list.add(new SettingDTO("개인정보 처리방침",false));
        list.add(new SettingDTO("개인정보 제공 내용",false));
        list.add(new SettingDTO("팝업 알림 설정",true));
        list.add(new SettingDTO("SMS서비스 설정",true));
        list.add(new SettingDTO("로그아웃",false));
        list.add(new SettingDTO("탈퇴하기",false));

        return list;
    }
}