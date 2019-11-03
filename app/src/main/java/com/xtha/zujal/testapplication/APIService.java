package com.xtha.zujal.testapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/users")
    Call<String> makeRequest();
}