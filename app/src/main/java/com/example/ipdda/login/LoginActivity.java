package com.example.ipdda.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.ipdda.MainActivity;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityLoginBinding;
import com.example.ipdda.member.MemberVO;
import com.example.ipdda.order.OrderActivity;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
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
            if(binding.edtId.getText().toString().length() < 1
                    || binding.edtPw.getText().toString().length() < 1){
                Toast.makeText(this, "아이디 또는 패스워드를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
            }


            CommonConn conn = new CommonConn(this,"member/login");
            conn.addParamMap("member_id",binding.edtId.getText().toString());
            conn.addParamMap("member_pw",binding.edtPw.getText().toString());


            conn.onExcute(((isResult, data) -> {
                if (isResult) {
                    CommonVar.loginInfo = new Gson().fromJson(data, MemberVO.class);
                    if (CommonVar.loginInfo == null) {                                       // CommonVar.loginInfo = vo;
                        Toast.makeText(this, "아이디 또는 비밀번호를 확인", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Intent intent1 = new Intent(LoginActivity.this, OrderActivity.class);
                        intent1.putExtra("id",binding.edtId.getText().toString());
                        intent1.putExtra("pw",binding.edtPw.getText().toString());
                        startActivity(intent);
                    }
                }
            }));

        });


        getHashKey();
//        binding.kakaoLogin.setOnClickListener(v -> {
//            kakaoLogin(this);
//        });



        binding.tvFind.setOnClickListener(v -> {
            Intent intent = new Intent(this, FindActivity.class);
            startActivity(intent);
        });

        binding.tvSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpFirstActivity.class);
            startActivity(intent);
        });

    }

    private long backKeyPressedTime = 0;
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();

            return;
        }

        // 2초 이내에 뒤로가기 버튼을 한번 더 클릭시 finish()(앱 종료)
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            //finish();
            finishAffinity();
            System.runFinalization();
            System.exit(0);
        }

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