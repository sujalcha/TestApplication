package com.xtha.zujal.testapplication.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.xtha.zujal.testapplication.Model.UserInfo;
import com.xtha.zujal.testapplication.Repositories.UserRepository;

import java.util.ArrayList;

public class UserViewModel extends AndroidViewModel {

    private final LiveData<ArrayList<UserInfo>> retroObservable;
    UserRepository webServiceRepository ;

    public UserViewModel(Application application){
        super(application);
        webServiceRepository = new UserRepository();
        retroObservable = webServiceRepository.providesWebService();
    }


    public LiveData<ArrayList<UserInfo>> getProjectRetroListObservable() {
        return retroObservable;
    }
}