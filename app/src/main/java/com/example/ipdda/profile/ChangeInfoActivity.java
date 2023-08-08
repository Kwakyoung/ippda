package com.example.ipdda.profile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.ipdda.databinding.ActivityChangeInfoBinding;
import com.example.ipdda.databinding.DialogCalBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChangeInfoActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    ActivityChangeInfoBinding binding;
    DialogCalBinding calBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.complete.setOnClickListener(v -> {
            Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show();
            finish();
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
    }
}