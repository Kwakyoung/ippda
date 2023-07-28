package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;

import com.example.ipdda.MainActivity;
import com.example.ipdda.databinding.ActivityLoginBinding;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApi;
import com.kakao.sdk.user.UserApiClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentManager manager = getSupportFragmentManager();

        KakaoSdk.init(this,"82a7553c2a37ccca54dd1db8c4809c71");

        UserApiClient.getInstance().unlink(new Function1<Throwable, Unit>() {
            @Override
            public Unit invoke(Throwable throwable) {
                return null;
            }
        });


        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        });


        getHashKey();
        binding.kakaoLogin.setOnClickListener(v -> {
            kakaoLogin(this);
        });



        binding.tvFind.setOnClickListener(v -> {
            Intent intent = new Intent(this, FindActivity.class);
            startActivity(intent);
        });

        binding.tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpFirstActivity.class);
            startActivity(intent);
        });

    }



    public void kakaoLogin(Context context){
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인 ( 웹뷰 )
        // Kotlin은 경우에 따라서 생성자 대신에 메소드로 객체를 return받음. UserApiClient name = new ... x => UserApiClient. { static UserApiClient.method )

        // ↓ 간단하게 처리한 코드
        Function2<OAuthToken, Throwable, Unit> callback = (token, error) -> {
            if(error != null){
                Log.d("카카오 로그인 에러", "invoke: "+ error.getMessage());
            }else {
                Log.d("카카오 로그인 성공", "invoke: "+ token.toString());
                getKakaoProfile();
            }
            return null;
        };

        if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(context)) {
            Log.d("카카오", "isKakaoTalkLoginAvailable: true ");
            UserApiClient.getInstance().loginWithKakaoTalk(context,callback);
        }else{
            Log.d("카카오", "isKakaoTalkLoginAvailable: false ");
            UserApiClient.getInstance().loginWithKakaoAccount(context, callback);
        }

    }
    public void getKakaoProfile(){
        UserApiClient.getInstance().me((user, error) -> {
            if(error == null){
                Log.d("카카오", "getKakaoProfile: "+user.toString());
                Log.d("카카오", "getKakaoProfile: "+user.getKakaoAccount().getEmail());
                Log.d("카카오", "getKakaoProfile: "+user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "getKakaoProfile: "+user.getKakaoAccount().getProfile().getThumbnailImageUrl());

            }
            return null;
        });
    }
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }
}