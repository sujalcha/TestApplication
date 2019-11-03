package com.xtha.zujal.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        String imagetitle = getIntent().getStringExtra("imagetitle");
        String imageurl = getIntent().getStringExtra("imageurl");
        String imagealbumid = getIntent().getStringExtra("imagealbumid");
        String imagephotoid = getIntent().getStringExtra("imagephotoid");

        TextView imagetext  = findViewById(R.id.imagetext);
        ImageView image  = findViewById(R.id.imageView);
        TextView albumid  = findViewById(R.id.imagealbumid);
        TextView photoid  = findViewById(R.id.imagephotoid);

        new ImageTask(image,this).execute(imageurl);
        albumid.setText(imagealbumid);
        photoid.setText(imagephotoid);
        imagetext.setText(imagetitle);
    }
}
