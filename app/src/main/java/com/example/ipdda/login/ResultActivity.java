package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityResultBinding;
import com.example.ipdda.member.MemberVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        CommonVar.loginInfo = new MemberVO();
        CommonVar.loginInfo.setMember_name(intent.getStringExtra("name"));
        CommonVar.loginInfo.setMember_phone(intent.getStringExtra("phone"));

        CommonConn conn = new CommonConn(this,"member/findid");
        conn.addParamMap("member_name", CommonVar.loginInfo.getMember_name());
        conn.addParamMap("member_phone", CommonVar.loginInfo.getMember_phone());
        conn.onExcute((isResult, data) -> {
            if (isResult) {
                CommonVar.loginInfo = new Gson().fromJson(data, MemberVO.class);
                if (CommonVar.loginInfo == null) {
                    binding.relInfo.setVisibility(View.GONE);
                    binding.tvNoinfo.setVisibility(View.VISIBLE);
                } else {
                    binding.tvMemberId.setText(CommonVar.loginInfo.getMember_id());
                    binding.tvCreate.setText(CommonVar.loginInfo.getMember_create());
                    Log.d("eeea", "onCreate: "+CommonVar.loginInfo.getMember_id());

                }
            }
        });

        binding.btnActivitylogin.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, LoginActivity.class);
            startActivity(intent1);
        });

        binding.tvFindPw.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, FindpwFragment.class);
            startActivity(intent1);
        });
    }
}