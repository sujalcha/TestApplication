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

    MainActivityViewModel mainActivityViewModel;
 //   @BindView(R.id.recylerview)
 //   RecyclerView photoRecylerview;
    ArrayList<UserInfo> User;
    UserAdapter adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetroViewModel retroViewModel;

        listview = findViewById(R.id.userlistview);
       // ButterKnife.bind(this);

//        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
//        model.getUsers().observe(this, users -> {
//            // update UI
//        });
        // photoRecylerview.setLayoutManager(new GridLayoutManager(this,3));


        /*mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        mainActivityViewModel.getUsers().observe(this, new Observer<ArrayList<UserInfo>>() {
            @Override
            public void onChanged(@Nullable ArrayList<UserInfo> User) {
                adapter = new UserAdapter(MainActivity.this, User);
                listview.setAdapter(adapter);
            }

        });*/

        retroViewModel = ViewModelProviders.of(this).get(RetroViewModel.class);
        retroViewModel.getProjectRetroListObservable().observe(this, new Observer<ArrayList<UserInfo>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<UserInfo> users) {
                // Update the cached copy of the words in the adapter.
                //adapter.setWords(users);
                adapter = new UserAdapter(MainActivity.this, users);
                listview.setAdapter(adapter);
            }
        });
    }



}
