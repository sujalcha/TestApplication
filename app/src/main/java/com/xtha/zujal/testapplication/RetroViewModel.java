package com.xtha.zujal.testapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.xtha.zujal.testapplication.Model.UserInfo;

import java.util.ArrayList;

public class RetroViewModel extends AndroidViewModel {

    private final LiveData<ArrayList<UserInfo>> retroObservable;
    WebServiceRepository webServiceRepository ;

    public RetroViewModel(Application application){
        super(application);
        webServiceRepository = new WebServiceRepository();
        retroObservable = webServiceRepository.providesWebService();
    }


    public LiveData<ArrayList<UserInfo>> getProjectRetroListObservable() {
        return retroObservable;
    }
}