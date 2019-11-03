package com.xtha.zujal.testapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.xtha.zujal.testapplication.Model.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WebServiceRepository {

    Application application;
    private static OkHttpClient providesOkHttpClientBuilder(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }

    ArrayList<UserInfo> webserviceResponseList = new ArrayList<>();
    public LiveData<ArrayList<UserInfo>> providesWebService() {
        final MutableLiveData<ArrayList<UserInfo>> data = new MutableLiveData<>();

        String response = "";
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIUrl.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(providesOkHttpClientBuilder())
                    .build();

            Log.i("APIUrl.BASE_URL",APIUrl.BASE_URL);
            //Defining retrofit api service
            APIService service = retrofit.create(APIService.class);
            Log.d("Service",service.toString());
            //  response = service.makeRequest().execute().body();
            service.makeRequest().enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("Repository","Response::::"+response.body());
                    webserviceResponseList = parseJson(response.body());
                    data.setValue(webserviceResponseList);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Repository","Failed:::");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return  data;

    }


    private ArrayList<UserInfo> parseJson(String response) {

        ArrayList<UserInfo> apiResults = new ArrayList<>();
        JSONArray jsonArray;

        try {
            jsonArray = new JSONArray(response);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                UserInfo userInfo = new UserInfo();
                //mMovieModel.setId(object.getString("id"));
                userInfo.setUserid(Integer.parseInt(object.getString("id")));
                userInfo.setUsername(object.getString("name"));
                userInfo.setUsernumber(object.getString("phone"));
                userInfo.setUseremail(object.getString("email"));

                apiResults.add(userInfo);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i(getClass().getSimpleName(), String.valueOf(apiResults.size()));
        return apiResults;

    }
}