package com.example.ipdda.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivitySignUpBinding;
import com.example.ipdda.databinding.DialogCalBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.member.MemberVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
//    DatePickerDialog datePickerDialog;
    DialogCalBinding calBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//
//        binding.feedback.setVisibility(View.GONE);
//        binding.feedback2.setVisibility(View.GONE);

//        if(binding.edtId.getText().toString().length()<1) {
//            binding.edtId.setBackgroundResource(R.drawable.bg_stroke_red);
//            binding.tvIdFeedback.setText("입력해주세요.");
//            binding.tvIdFeedback.setTextColor(Color.RED);
//        } else




            binding.btnSignup.setOnClickListener(v -> {
                int selectRadio = binding.radioGender.getCheckedRadioButtonId();

            if(binding.edtId.getText().toString().length()<1) {
                binding.tvIdFeedback.setText("빈칸을 입력해주세요. 5~15자 이내");
            } else if(binding.tvIdFeedback.getText().toString().equals("중복확인을 해주세요")){
                Toast.makeText(this, "아이디 중복확인 후 진행해주세요.", Toast.LENGTH_SHORT).show();
            } else if (binding.edtNickname.getText().toString().length()<1) {
                binding.edtNickname.setBackgroundResource(R.drawable.bg_stroke_red);
                Toast.makeText(this, "빈칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else if (binding.edtPw.getText().toString().length()<1) {
                binding.tvPwFeedback.setText("입력해주세요.");
                binding.edtPw.setBackgroundResource(R.drawable.bg_stroke_red);
            } else if (binding.edtPwCheck.getText().toString().length()<1) {
                binding.edtPw.setBackgroundResource(R.drawable.bg_stroke_red);
                binding.tvPwCheck.setText("입력해주세요.");
                binding.tvPwCheck.setTextColor(Color.RED);
            } else if (binding.edtEmail.getText().toString().length()<1
                    || binding.tvBirthDate.getText().toString().length()<1) {
                Toast.makeText(this, "빈칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else if (selectRadio == -1 && selectRadio == -1) {
                Toast.makeText(this, "성별을 골라주세요", Toast.LENGTH_SHORT).show();
            } else if (binding.tvIdFeedback.getText().equals("사용가능한 아이디 입니다.") && binding.edtPw.getText().toString().equals(binding.edtPwCheck.getText().toString())){

                    CommonVar.loginInfo = new MemberVO();
                    CommonVar.loginInfo.setMember_id(binding.edtId.getText().toString());
                    CommonVar.loginInfo.setMember_nickname(binding.edtNickname.getText().toString());
                    CommonVar.loginInfo.setMember_pw(binding.edtPw.getText().toString());
                    CommonVar.loginInfo.setMember_email(binding.edtEmail.getText().toString());
                    CommonVar.loginInfo.setMember_birthday(binding.tvBirthDate.getText().toString());

                        if (binding.checkMan.isChecked()){
                            CommonVar.loginInfo.setMember_gender("남");
                        }else {
                            CommonVar.loginInfo.setMember_gender("여");
                        }

                    CommonConn conn = new CommonConn(this,"member/insert");
                        conn.addParamMap("member_no", 1235);
                    conn.addParamMap("member_id", CommonVar.loginInfo.getMember_id()+"");
                    conn.addParamMap("member_nickname", CommonVar.loginInfo.getMember_nickname()+"");
                    conn.addParamMap("member_pw", CommonVar.loginInfo.getMember_pw()+"");
                    conn.addParamMap("member_email", CommonVar.loginInfo.getMember_email()+"");
                    conn.addParamMap("member_gender", CommonVar.loginInfo.getMember_gender()+"");


                    conn.onExcute((isResult, data) -> {
                        if (isResult) {

                            Toast.makeText(this, "회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this, LoginActivity.class);
                            startActivity(intent);
                        }else {
                                Toast.makeText(this, "멈춤", Toast.LENGTH_SHORT).show();
                            }

                    });


                }
            });





            binding.btnIdCheck.setOnClickListener(v -> {
                if (binding.edtId.getText().toString().length() < 1) {
                    binding.tvIdFeedback.setText("입력하고 눌러주세요");
                    return;
                } else if (binding.edtId.getText().toString().length()<5 || binding.edtId.getText().toString().length()>15) {
                    binding.edtId.setText("");
                    return;
                }
                CommonConn conn = new CommonConn(this, "member/idcheck");
                conn.addParamMap("member_id", binding.edtId.getText().toString());
                conn.onExcute((isResult, data) -> {
                    if (isResult) {
                        CommonVar.loginInfo = new Gson().fromJson(data, MemberVO.class);

                        if (CommonVar.loginInfo == null) {
                            binding.tvIdFeedback.setText("사용가능한 아이디 입니다.");
                            binding.tvIdFeedback.setTextColor(Color.GREEN);
                        } else {
                            binding.edtId.setText("");
                            binding.tvIdFeedback.setText("이미 존재하는 아이디 입니다.");
                            binding.tvIdFeedback.setTextColor(Color.RED);
                        }
                    }
                });
            });



        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 현재연도
        int month = calendar.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 1을 더해줌)
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 현재 일

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date(System.currentTimeMillis());
        String formattdDate = format.format(date);



        binding.tvBirthDate.setOnClickListener(v -> {
                    calBinding = DialogCalBinding.inflate(getLayoutInflater());
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setView(calBinding.getRoot());
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    calBinding.btnCancel.setOnClickListener(v1 -> {
                        dialog.dismiss();
                    });

                    calBinding.btnGet.setOnClickListener(v1 -> {
                        calendar.set(calBinding.dpDate.getYear(), calBinding.dpDate.getMonth(), calBinding.dpDate.getDayOfMonth());
                        String formattedDate1;
                        formattedDate1 = calBinding.dpDate.getYear()+"";
                        if ((calBinding.dpDate.getMonth() + 1)<10) {
                            formattedDate1 += ".0" + (calBinding.dpDate.getMonth() + 1);
                        }else {
                            formattedDate1 += "." + (calBinding.dpDate.getMonth() + 1);
                        }

                        if ((calBinding.dpDate.getDayOfMonth())<10) {
                            formattedDate1 += ".0" + calBinding.dpDate.getDayOfMonth();
                        }else {
                            formattedDate1 += "." + calBinding.dpDate.getDayOfMonth();
                        }



                        StringBuilder strBuilder = new StringBuilder();
                        strBuilder.append("Selected Date: ");
                        strBuilder.append(formattedDate1);
                        binding.tvBirthDate.setText(formattedDate1);

                        dialog.dismiss();
                    });

                });








        binding.edtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.edtId.length() < 5 || binding.edtId.length()>15) {
                    binding.tvIdFeedback.setText("5~15자 이내 아이디를 입력해주세요.");
                    binding.tvIdFeedback.setTextColor(Color.RED);

                } else if (binding.edtId.length() >=5 && binding.edtId.length()<=20) {
                    binding.tvIdFeedback.setText("중복확인을 해주세요");
                    binding.tvIdFeedback.setTextColor(Color.GREEN);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

            binding.edtPw.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (binding.edtPw.length() < 5 || binding.edtId.length()>15) {
                        binding.tvPwFeedback.setText("5~15자 이내 아이디를 입력해주세요.");
                        binding.tvPwFeedback.setTextColor(Color.RED);

                    } else if (binding.edtPw.length() >=5 && binding.edtId.length()<=20) {
                        binding.tvPwFeedback.setText("사용 가능합니다.");
                        binding.tvPwFeedback.setTextColor(Color.GREEN);
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
