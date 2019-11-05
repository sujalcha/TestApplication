package com.xtha.zujal.testapplication.Views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.xtha.zujal.testapplication.Adapters.UserAdapter;
import com.xtha.zujal.testapplication.Model.UserInfo;
import com.xtha.zujal.testapplication.R;
import com.xtha.zujal.testapplication.ViewModels.UserViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserInfo> User;
    UserAdapter adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserViewModel retroViewModel;

        listview = findViewById(R.id.userlistview);

        retroViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        retroViewModel.getProjectRetroListObservable().observe(this, new Observer<ArrayList<UserInfo>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<UserInfo> users) {

                adapter = new UserAdapter(MainActivity.this, users);
                listview.setAdapter(adapter);
            }
        });
    }



}
