package com.example.ipdda.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.FragmentFindpwBinding;
import com.example.ipdda.member.MemberVO;
import com.google.gson.Gson;

import java.lang.reflect.Member;
import java.util.regex.Pattern;


public class FindpwFragment extends Fragment {
    FragmentFindpwBinding binding;
    String result;
    String TAG = "ippda";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFindpwBinding.inflate(inflater,container,false);

        // 아이디 찾기로 이동
        binding.tvFindId.setOnClickListener(v -> {
            FindActivity activity = (FindActivity) getActivity();
            activity.changeFragment(2,new FindidFragment());
        });


        // 이메일로 찾기로 이동
        binding.checkEmail.setOnClickListener(v -> {
            FindActivity activity = (FindActivity) getActivity();
            activity.changeFragment(6, new Findpw_emailFragment());
        });



        binding.btnPhonecheck.setOnClickListener(v -> {
            if(Pattern.matches("^01(?:0|1|[6-9])+(?:\\d{3}|\\d{4})+\\d{4}$", binding.edtPhonenum.getText().toString())){

                CommonConn conn = new CommonConn(getContext(), "member/sms");
                conn.addParamMap("phoneNum", binding.edtPhonenum.getText().toString());
                conn.onExcute((isResult, data) -> {
                    if(data.equals("실패")||data==null){
                        Toast.makeText(getContext(), "sms 문자 전송에 실패하였습니다\n다시 시도해주세요", Toast.LENGTH_SHORT).show();
                    }else {
                        result = data;
                        Toast.makeText(getContext(), "인증번호가 전송되었습니다.", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onCreate: "+data);
                        binding.btnPhonecheckLast.setEnabled(true);
                    }
                });
            }else{
                Toast.makeText(getContext(), "전화번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnPhonecheckLast.setOnClickListener(v -> {
            if (result.equals(binding.edtPhonenumCheck.getText().toString())){
                Toast.makeText(getContext(), "인증이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                binding.btnPhonecheckLast.setText("인증완료");
                binding.edtPhonenum.setEnabled(false);
                binding.edtPhonenumCheck.setEnabled(false);
                binding.btnPhonecheck.setEnabled(false);
                binding.btnPhonecheckLast.setEnabled(false);
            }else {
                Toast.makeText(getContext(), "인증번호가 맞지 않습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });



        binding.btnNext.setOnClickListener(v -> {
            CommonVar.loginInfo = new MemberVO();
            CommonVar.loginInfo.setMember_id(binding.edtId.getText().toString());
            CommonVar.loginInfo.setMember_name(binding.edtName.getText().toString());
            CommonVar.loginInfo.setMember_phone(binding.edtPhonenum.getText().toString());

            CommonConn conn = new CommonConn(getContext(), "member/check");
            conn.addParamMap("member_id", binding.edtId.getText().toString());
            conn.addParamMap("member_name",binding.edtName.getText().toString());
            conn.onExcute((isResult, data) -> {
                if (isResult) {
                    CommonVar.loginInfo = new Gson().fromJson(data, MemberVO.class);

                    if (binding.edtId.getText().toString().length() < 1) {
                        Toast.makeText(getContext(), "아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        binding.edtId.requestFocus(); // 이부분을 추가하여 커서를 해당 edt로 이동
                    } else if (binding.edtName.getText().toString().length() < 1) {
                        Toast.makeText(getContext(), "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        binding.edtName.requestFocus(); // 이부분을 추가하여 커서를 해당 edt로 이동
                    } else if (binding.edtPhonenum.getText().toString().length() < 1) {
                        Toast.makeText(getContext(), "휴대폰 번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        binding.edtPhonenum.requestFocus(); // 이부분을 추가하여 커서를 해당 edt로 이동
                    } else if (binding.btnPhonecheckLast.getText().equals("인증하기")) {
                        Toast.makeText(getContext(), "휴대폰 인증을 완료해주세요.", Toast.LENGTH_SHORT).show();
                    } else if (CommonVar.loginInfo == null) {
                        Toast.makeText(getContext(), "아이디 또는 이름을 확인해주세요.", Toast.LENGTH_SHORT).show();
                        binding.edtId.requestFocus();
                    } else if (binding.btnPhonecheckLast.getText().equals("인증완료")) {
                        Intent intent = new Intent(getActivity(), ResultPwActivity.class);
                        intent.putExtra("id", binding.edtId.getText().toString());
                        intent.putExtra("name", binding.edtName.getText().toString());
                        intent.putExtra("phone", binding.edtPhonenum.getText().toString());
                        startActivity(intent);
                    }
                }
            });



        });

        return binding.getRoot();
    }
}