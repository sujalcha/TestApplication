package com.xtha.zujal.testapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.xtha.zujal.testapplication.Model.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserInfo> User;
    UserAdapter adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetroViewModel retroViewModel;

        listview = findViewById(R.id.userlistview);

        retroViewModel = ViewModelProviders.of(this).get(RetroViewModel.class);
        retroViewModel.getProjectRetroListObservable().observe(this, new Observer<ArrayList<UserInfo>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<UserInfo> users) {

                adapter = new UserAdapter(MainActivity.this, users);
                listview.setAdapter(adapter);
            }
        });
    }



}
