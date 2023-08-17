package com.example.ipdda.login;

import android.content.Intent;
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
import com.example.ipdda.databinding.FragmentFindidBinding;

import java.util.regex.Pattern;


public class FindidFragment extends Fragment {
    FragmentFindidBinding binding;

    FindActivity activity;
    String result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFindidBinding.inflate(inflater,container,false);





        binding.tvFindPw.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(1, new FindpwFragment());
        });

        binding.checkEmail.setOnClickListener(v -> {
            activity = (FindActivity) getActivity();
            activity.changeFragment(3, new Findid_emailFragment());
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
                        Log.d("TAG", "onCreate: "+data);
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
            }
        });


        binding.btnNext.setOnClickListener(v -> {
            if (binding.btnPhonecheckLast.getText().equals("인증완료")){
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra("name",binding.edtName.getText().toString());
                intent.putExtra("phone",binding.edtPhonenum.getText().toString());

                startActivity(intent);
            }else if (binding.edtName.getText().toString().length()<1){
                Toast.makeText(getContext(), "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                binding.edtName.requestFocus(); // 이부분을 추가하여 커서를 해당 edt로 이동
            }else {
                Toast.makeText(getContext(), "휴대폰 인증을 해주세요.", Toast.LENGTH_SHORT).show();
                binding.edtPhonenum.requestFocus(); // 이부분을 추가하여 커서를 해당 edt로 이동
            }

        });






        return binding.getRoot();
    }
}