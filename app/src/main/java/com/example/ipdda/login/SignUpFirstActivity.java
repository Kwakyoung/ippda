package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.databinding.ActivitySignUpFirstBinding;

import java.util.regex.Pattern;

public class SignUpFirstActivity extends AppCompatActivity {
    ActivitySignUpFirstBinding binding;
    String result;
    String TAG = "ippda";

    final String APIKEY = "NCSCTZA8YMURWIAC";
    final String APISECRET = "CKZVCPVIKL1I6BSISLDIH9BLTCVR7UNO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPhonecheck.setOnClickListener(v -> {
            if(Pattern.matches("^01(?:0|1|[6-9])+(?:\\d{3}|\\d{4})+\\d{4}$", binding.edtPhonenum.getText().toString())){

            CommonConn conn = new CommonConn(this, "member/sms");
            conn.addParamMap("phoneNum", binding.edtPhonenum.getText().toString());
            conn.onExcute((isResult, data) -> {
                if(data.equals("실패")||data==null){
                    Toast.makeText(this, "sms 문자 전송에 실패하였습니다\n다시 시도해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    result = data;
                    Toast.makeText(this, "인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onCreate: "+data);
                }
             });
             }else{
                Toast.makeText(this, "전화번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
         });

        binding.btnPhonecheckLast.setOnClickListener(v -> {
            if (result.equals(binding.edtCheck.getText().toString())){
                Toast.makeText(this, "인증이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                binding.btnPhonecheckLast.setText("인증완료");
                binding.edtPhonenum.setEnabled(false);
                binding.edtCheck.setEnabled(false);
                binding.btnPhonecheck.setEnabled(false);
                binding.btnPhonecheckLast.setEnabled(false);
            }else {
                Toast.makeText(this, "인증번호가 맞지 않습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });


        binding.btnNext.setOnClickListener(v -> {
            if (binding.btnPhonecheckLast.getText().equals("인증완료")){
                Intent intent = new Intent(this, SignUpActivity.class);
                intent.putExtra("name",binding.edtName.getText().toString());
                intent.putExtra("phone",binding.edtPhonenum.getText().toString());
                startActivity(intent);
            }else if (binding.edtName.getText().toString().length()<1){
                Toast.makeText(this, "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                binding.edtName.setBackgroundResource(R.drawable.bg_stroke_red);
            }else {
                Toast.makeText(this, "휴대폰 인증을 해주세요.", Toast.LENGTH_SHORT).show();
            }

        });
    }
}