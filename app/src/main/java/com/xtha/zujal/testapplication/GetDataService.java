package com.xtha.zujal.testapplication;

import com.xtha.zujal.testapplication.Model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/users")
    Call<List<UserInfo>> getAllPosts();
}