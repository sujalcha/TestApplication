package com.xtha.zujal.testapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.xtha.zujal.testapplication.Model.AlbumInfo;

import java.util.ArrayList;

public class AlbumViewModel extends AndroidViewModel {

    Album album;
    private final LiveData<ArrayList<AlbumInfo>> retroObservable;
    AlbumRepository albumRepository ;

    public AlbumViewModel(Application application) {
        super(application);
        albumRepository = new AlbumRepository();

       // int sessionId = getIntent().getIntExtra("userid",0);

       // Log.d("sessionid",String.valueOf(album.sessionId));
        retroObservable = albumRepository.providealbumlist(5);
    }

    public LiveData<ArrayList<AlbumInfo>> getProjectRetroListObservable() {
        return retroObservable;
    }
}
