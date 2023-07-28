package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityChangeInfoBinding;
import com.example.ipdda.login.SignUpActivity;

import java.util.Calendar;

public class ChangeInfoActivity extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    ActivityChangeInfoBinding binding;
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

        binding.tvBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR); // 년
                int pMonth = calendar.get(Calendar.MONTH); // 월
                int pDay = calendar.get(Calendar.DAY_OF_MONTH); // 일
                datePickerDialog = new DatePickerDialog(ChangeInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
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

    }
}