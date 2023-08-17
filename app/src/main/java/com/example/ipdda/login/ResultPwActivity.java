package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityResultPwBinding;

import java.util.regex.Pattern;

public class ResultPwActivity extends AppCompatActivity {
    ActivityResultPwBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPwBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent1 = getIntent();
        binding.tvMemberId.setText(intent1.getStringExtra("id"));


        binding.btnActivitylogin.setOnClickListener(v -> {
            if(binding.tvPwCheck.getText().toString().equals("비밀번호와 일치합니다.") && binding.tvPwFeedback.getText().toString().equals("사용 가능합니다.")){
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
            }

        });

        binding.edtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtPw.length() < 6 || binding.edtPw.length()>16) {
                    binding.tvPwFeedback.setText("영문, 숫자, 특수문자 6~16자리를 입력해주세요.");
                    binding.tvPwFeedback.setTextColor(Color.RED);
                }else if(!Pattern.compile("[0-9]").matcher(binding.edtPw.getText().toString()).find()){
                    binding.tvPwFeedback.setVisibility(View.VISIBLE);
                    binding.tvPwFeedback.setText("숫자 1자 이상 넣어주세요.");
                    binding.tvPwFeedback.setTextColor(Color.RED);
                }else if(!Pattern.compile("[a-z]").matcher(binding.edtPw.getText().toString()).find()){
                    binding.tvPwFeedback.setVisibility(View.VISIBLE);
                    binding.tvPwFeedback.setText("영문 1자 이상 넣어주세요.");
                    binding.tvPwFeedback.setTextColor(Color.RED);
                }else if(!Pattern.compile("[A-Z$@$!%*#?&]").matcher(binding.edtPw.getText().toString()).find()) {
                    binding.tvPwFeedback.setVisibility(View.VISIBLE);
                    binding.tvPwFeedback.setText("특수문자 1자 이상 넣어주세요.");
                    binding.tvPwFeedback.setTextColor(Color.RED);
                } else {
                    binding.tvPwFeedback.setText("사용 가능합니다.");
                    binding.tvPwFeedback.setTextColor(Color.GREEN);
                    binding.edtPw.setBackgroundResource(R.drawable.radius);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        binding.edtPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtPwCheck.getText().toString().equals(binding.edtPw.getText().toString())) {
                    binding.tvPwCheck.setText("비밀번호와 일치합니다.");
                    binding.tvPwCheck.setTextColor(Color.GREEN);
                } else {
                    binding.tvPwCheck.setText("비밀번호와 일치하지 않습니다.");
                    binding.tvPwCheck.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}