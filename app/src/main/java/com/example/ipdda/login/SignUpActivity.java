package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.ipdda.databinding.ActivitySignUpBinding;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.feedback.setVisibility(View.GONE);
        binding.feedback2.setVisibility(View.GONE);
        binding.btnSignup.setOnClickListener(v -> {
            Toast.makeText(this, "회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });




        binding.tvBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR); // 년
                int pMonth = calendar.get(Calendar.MONTH); // 월
                int pDay = calendar.get(Calendar.DAY_OF_MONTH); // 일
                datePickerDialog = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month +1;
                        String date = year + "/" + month + "/" + dayOfMonth;

                        binding.tvBirthDate.setText(date);
                    }
                }, pYear , pMonth , pDay);
                datePickerDialog.show();
            }
        });

        binding.edtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.edtPw.length() == 0){
                    binding.feedback.setVisibility(View.GONE);
                } else if (binding.edtPw.length() != 0) {
                    binding.feedback.setVisibility(View.VISIBLE);
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
                if(binding.edtPwCheck.length() == 0){
                    binding.feedback2.setVisibility(View.GONE);
                } else if (binding.edtPwCheck.length() != 0) {
                    binding.feedback2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}