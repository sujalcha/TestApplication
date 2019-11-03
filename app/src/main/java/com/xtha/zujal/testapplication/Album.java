package com.xtha.zujal.testapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.xtha.zujal.testapplication.Model.AlbumInfo;
import com.xtha.zujal.testapplication.Model.UserInfo;

import java.util.ArrayList;

public class Album extends AppCompatActivity {

    private AlbumAdapter adapter;
    public AlbumViewModel albumViewModel;
    ListView listview;
    public int sessionId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        sessionId = getIntent().getIntExtra("userid",0);

        listview = findViewById(R.id.albumlist);
        final TextView albumid = findViewById(R.id.albumid);


        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        albumViewModel.getProjectRetroListObservable().observe(this, new Observer<ArrayList<AlbumInfo>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<AlbumInfo> albumlist) {

                adapter= new AlbumAdapter(Album.this,albumlist);
                listview.setAdapter(adapter);
              //  albumid.setText(albumlist);
            }
        });

    }
}
