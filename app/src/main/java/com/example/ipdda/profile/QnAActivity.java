package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityQnaBinding;

import java.util.ArrayList;

public class QnAActivity extends AppCompatActivity {

    ActivityQnaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityQnaBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.recvOptenQuestion.setAdapter(new OptenQuestionAdapter(textList(), this));
        binding.recvOptenQuestion.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        binding.btnBack.setOnClickListener(v -> this.finish());
    }

    ArrayList<String> textList(){
        ArrayList<String> textList= new ArrayList<>();
        textList.add("판매자가 사기를 쳤을때 복수 방법");
        textList.add("바가지를 씌웠을때 대처 방법");
        textList.add("판매자가 탈북인인 상황에서의 대처방법 알려주세요");
        textList.add("키우는 애완동물이 모르고 구매하기를 눌렀을때는 어떻게 해야하나요?");
        textList.add("구매한 옷이 5년간 도착하지 않았을때는 어떻게 해야하나요?");

        return textList;
    }
}