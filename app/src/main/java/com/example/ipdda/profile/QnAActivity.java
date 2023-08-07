package com.example.ipdda.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityQnaBinding;
import com.example.ipdda.databinding.ActivityWriteDialogBinding;

import java.util.ArrayList;

public class QnAActivity extends AppCompatActivity {
    Dialog write_dialog;
    ActivityQnaBinding binding;
    ActivityWriteDialogBinding dialogBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityQnaBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        write_dialog = new Dialog(this);       // Dialog 초기화
        write_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        write_dialog.setContentView(R.layout.activity_write_dialog);             // xml 레이아웃 파일과 연결
        write_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        binding.recvOptenQuestion.setAdapter(new OptenQuestionAdapter(textList(), this));
        binding.recvOptenQuestion.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        binding.fab.setOnClickListener(v -> {
            showDialog();
        });

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
    public void showDialog(){
        write_dialog.show(); // 다이얼로그 띄우기
        dialogBinding = ActivityWriteDialogBinding.inflate(write_dialog.getLayoutInflater());
        write_dialog.setContentView(dialogBinding.getRoot());

        dialogBinding.btnCancle.setOnClickListener(v -> {
            write_dialog.dismiss();
        });
        dialogBinding.btnComplete.setOnClickListener(v -> {
            //db에 저장하는 코드 작성
            write_dialog.dismiss();
        });

        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        // 위젯 연결 방식은 각자 취향대로~
        // '아래 아니오 버튼'처럼 일반적인 방법대로 연결하면 재사용에 용이하고,
        // '아래 네 버튼'처럼 바로 연결하면 일회성으로 사용하기 편함.
        // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

    }
}