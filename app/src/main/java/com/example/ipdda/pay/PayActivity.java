package com.example.ipdda.pay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.PayConn;
import com.example.ipdda.common.RetrofitClient;
import com.example.ipdda.common.RetrofitInterface;
import com.example.ipdda.home.GoodsVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class PayActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        PayConn payConn = new PayConn(this, "KakaoAK 1317a7eddae1a3be8fffc9c38ee21fac", "application/x-www-form-urlencoded;charset=utf-8");
        payConn.addParamMap("cid", "TC0ONETIME");
        payConn.addParamMap("partner_order_id", "1");
        payConn.addParamMap("partner_user_id", "test123");
        payConn.addParamMap("item_name", "바나나");
        payConn.addParamMap("item_code", "1");
        payConn.addParamMap("quantity", 1);
        payConn.addParamMap("total_amount", 20000);
        payConn.addParamMap("tax_free_amount", 0);
        payConn.addParamMap("approval_url", "www.naver.com");
        payConn.addParamMap("cancel_url", "www.naver.com");
        payConn.addParamMap("fail_url", "www.naver.com");

        payConn.onExcute((isResult, data) -> {
            Log.d("aa", "onCreate: ");
        });





}




}