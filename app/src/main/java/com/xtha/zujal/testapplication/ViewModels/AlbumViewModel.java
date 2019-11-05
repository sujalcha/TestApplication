package com.xtha.zujal.testapplication.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.xtha.zujal.testapplication.Model.AlbumInfo;
import com.xtha.zujal.testapplication.Repositories.AlbumRepository;
import com.xtha.zujal.testapplication.Views.Album;

import java.util.ArrayList;

public class AlbumViewModel extends AndroidViewModel {

    Album album;
    private final LiveData<ArrayList<AlbumInfo>> retroObservable;
    AlbumRepository albumRepository ;

    public AlbumViewModel(Application application) {
        super(application);
        albumRepository = new AlbumRepository();

       // int sessionId = getIntent().getIntExtra("userid",0);

        Log.d("sessionid",String.valueOf(album.sessionId));
        retroObservable = albumRepository.providealbumlist(album.sessionId);
    }

    public LiveData<ArrayList<AlbumInfo>> getProjectRetroListObservable() {
        return retroObservable;
    }
}
