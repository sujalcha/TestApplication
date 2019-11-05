package com.xtha.zujal.testapplication.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.xtha.zujal.testapplication.URLS.APIUrl;
import com.xtha.zujal.testapplication.URLS.AlbumService;
import com.xtha.zujal.testapplication.Model.AlbumInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AlbumRepository {


    Application application;
    private static OkHttpClient providesOkHttpClientBuilder(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }

    ArrayList<AlbumInfo> webserviceResponseList = new ArrayList<>();

    public LiveData<ArrayList<AlbumInfo>> providealbumlist(final int userid) {
        final MutableLiveData<ArrayList<AlbumInfo>> data = new MutableLiveData<>();

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
            AlbumService service = retrofit.create(AlbumService.class);
            Log.d("Service",service.toString());
            //  response = service.makeRequest().execute().body();
            service.makeRequest().enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
               //     Log.d("Repository","Response::::"+response.body());
                    webserviceResponseList = parseJson(response.body(),userid);
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


    private ArrayList<AlbumInfo> parseJson(String response, int userid) {

        ArrayList<AlbumInfo> apiResults = new ArrayList<>();
        JSONArray jsonArray;

        try {
            jsonArray = new JSONArray(response);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                AlbumInfo albumInfo = new AlbumInfo();
                albumInfo.setAlbumid(Integer.parseInt(object.getString("albumId")));
                albumInfo.setId(Integer.parseInt(object.getString("id")));
                albumInfo.setTitle(object.getString("title"));
                albumInfo.setUrl(object.getString("url"));
                albumInfo.setThumbnailUrl(object.getString("thumbnailUrl"));

                if (albumInfo.getAlbumid()==userid)
                {
                    apiResults.add(albumInfo);
                  //  album_id.setText(String.valueOf(albumid));
                }


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i(getClass().getSimpleName(), String.valueOf(apiResults.size()));
        return apiResults;

    }
}

