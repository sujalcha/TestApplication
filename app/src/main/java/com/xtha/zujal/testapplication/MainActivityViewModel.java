package com.xtha.zujal.testapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.xtha.zujal.testapplication.Model.UserInfo;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivityViewModel extends AndroidViewModel {


    private MutableLiveData<ArrayList<UserInfo>> users;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<UserInfo>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<ArrayList<UserInfo>>();
          //  loadUsers();
        }
        return users;
    }

//    private void loadUsers() {
//        // Do an asynchronous operation to fetch users.
//        return users;
//    }
//
//
//    PhotoRepository photoRepository;
//    PhotoDataSourceFactory photoDataSourceFactory;
//    MutableLiveData<PhotoDataSource> dataSourceMutableLiveData;
//    Executor executor;
//    LiveData<PagedList<Photos>> pagedListLiveData;
//
//    public MainActivityViewModel(@NonNull Application application) {
//        super(application);
//
//        photoDataSourceFactory = new PhotoDataSourceFactory();
//        dataSourceMutableLiveData = photoDataSourceFactory.getMutableLiveData();
//
//        PagedList.Config config = (new PagedList.Config.Builder())
//                .setEnablePlaceholders(true)
//                .setInitialLoadSizeHint(10)
//                .setPageSize(20)
//                .setPrefetchDistance(4)
//                .build();
//        executor = Executors.newFixedThreadPool(5);
//        pagedListLiveData = (new LivePagedListBuilder<Long,Photos>(photoDataSourceFactory,config))
//                .setFetchExecutor(executor)
//                .build();
//
//
//    }
//
//    public LiveData<PagedList<Photos>> getPagedListLiveData() {
//        return pagedListLiveData;
//    }
}