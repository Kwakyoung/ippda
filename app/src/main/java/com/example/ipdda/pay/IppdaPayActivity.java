package com.example.ipdda.pay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityIppdaPayBinding;
import com.example.ipdda.order.OrderActivity;

public class IppdaPayActivity extends AppCompatActivity {

    ActivityIppdaPayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIppdaPayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCharge.setOnClickListener(v -> {
            String inputText = binding.edtChargemoney.getText()+"";
            
            try {
                int member_money = Integer.parseInt(inputText); // 문자열을 숫자로 변환
                
                if(member_money <= 0){
                    Toast.makeText(this, "0보다 큰 금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (isValidAmount(member_money) == false) {
                    Toast.makeText(this, "금액 단위로 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if(member_money > 0 && isValidAmount(member_money)){
                    CommonConn conn = new CommonConn(this ,"member/charge");
                    conn.addParamMap("member_money", member_money);
                    conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                    conn.onExcute((isResult, data) -> {
                        finish();
                    });
                }


            } catch (NumberFormatException e) {
                // 숫자로 입력안했을 때 변환할 수 없는 경우 처리
                Toast.makeText(this, "숫자만 입력해주세요", Toast.LENGTH_SHORT).show();
            }



        });


    }

    // 입력된 내용이 유효한 10원 단위 금액인지 검사하는 함수
    private boolean isValidAmount(int amount) {
        // 10원 단위로 입력 검사
        return amount % 10 == 0;
    }

}