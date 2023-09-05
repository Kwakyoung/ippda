package com.example.ipdda.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    public static String ip="http://192.168.0.116:8080";
    public Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ip+"/cloude/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        return retrofit;
    }

    public Retrofit getKakao(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kapi.kakao.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }

    public Retrofit getToss(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pay.toss.im/api/v2/payments")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }

}
