package com.xtha.zujal.testapplication.URLS;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("/users")
    Call<String> makeRequest();
}