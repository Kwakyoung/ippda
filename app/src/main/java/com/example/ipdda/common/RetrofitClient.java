package com.example.ipdda.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    public Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/cloude/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }
}
