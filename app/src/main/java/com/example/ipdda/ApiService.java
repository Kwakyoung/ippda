package com.example.ipdda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("posts")
    Call<List<POST>> getData(@Query("userid") String id);

}

