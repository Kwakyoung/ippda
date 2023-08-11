package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.ActivitySignUpFirstBinding;

import java.util.regex.Pattern;

public class SignUpFirstActivity extends AppCompatActivity {
    ActivitySignUpFirstBinding binding;
    String result;

    final String APIKEY = "NCSETJIO9APTNGCU";
    final String APISECRET = "FYUXODBO43RFL0WA0JLVPLJRG3XUBQ2C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.btnPhonecheck.setOnClickListener(v -> {
//            CommonConn conn = new CommonConn(this, "member/sms");
//            conn.addParamMap("phoneNumber", binding.edtPhonenum.getText().toString());
//            conn.onExcute((isResult, data) -> {
//                if(data.equals("실패")||data==null){
//                    Toast.makeText(this, "sms 문자 전송에 실패하였습니다\n다시 시도해주세요", Toast.LENGTH_SHORT).show();
//                }else {
//                    result = data;
////                        binding.edtNumber.setText(data);
////                    binding.tvMessage.setVisibility(View.VISIBLE);
////                    binding.rlMessage.setVisibility(View.VISIBLE);
////                    setTimer();
//                }
//        });
//    });




        binding.btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            intent.putExtra("name",binding.edtName.getText().toString());
            intent.putExtra("phone",binding.edtPhonenum.getText().toString());
            startActivity(intent);
        });
    }
}