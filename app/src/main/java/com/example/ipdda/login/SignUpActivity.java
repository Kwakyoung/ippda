package com.example.ipdda.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivitySignUpBinding;
import com.example.ipdda.databinding.DialogCalBinding;

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
        binding.btnSignup.setOnClickListener(v -> {
            Toast.makeText(this, "회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 현재연도
        int month = calendar.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 1을 더해줌)
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 현재 일

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date(System.currentTimeMillis());
        String formattdDate = format.format(date);

        binding.tvBirthDate.setText(formattdDate);

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

//        binding.tvBirthDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar calendar = Calendar.getInstance();
//                int pYear = calendar.get(Calendar.YEAR); // 년
//                int pMonth = calendar.get(Calendar.MONTH); // 월
//                int pDay = calendar.get(Calendar.DAY_OF_MONTH); // 일
//                datePickerDialog = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        month = month +1;
//                        String date = year + "/" + month + "/" + dayOfMonth;
//
//                        binding.tvBirthDate.setText(date);
//                    }
//                }, pYear , pMonth , pDay);
//                datePickerDialog.show();
//            }
//        });

        // 남, 여 선택
        RadioGroup radioGender = findViewById(R.id.radio_gender);

//            binding.edtPw.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    if (binding.edtPw.length() == 0) {
//                        binding.feedback.setVisibility(View.GONE);
//                    } else if (binding.edtPw.length() != 0) {
//                        binding.feedback.setVisibility(View.VISIBLE);
//                    }
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                }
//            });
//
//            binding.edtPwCheck.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    if (binding.edtPwCheck.length() == 0) {
//                        binding.feedback2.setVisibility(View.GONE);
//                    } else if (binding.edtPwCheck.length() != 0) {
//                        binding.feedback2.setVisibility(View.VISIBLE);
//                    }
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                }
//            });


        }
}
