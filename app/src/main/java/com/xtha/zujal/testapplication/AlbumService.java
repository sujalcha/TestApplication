package com.xtha.zujal.testapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumService {
    @GET("/photos")
    Call<String> makeRequest();
}