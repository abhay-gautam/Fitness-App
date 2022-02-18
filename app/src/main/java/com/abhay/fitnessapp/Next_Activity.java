package com.abhay.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Next_Activity extends AppCompatActivity {
    TextView title,description;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        imageView=findViewById(R.id.imagenext);
        title=findViewById(R.id.titlenext);
        description=findViewById(R.id.descriptionnext);


        Intent iin= getIntent();

        Bundle b = iin.getExtras();
        String imagesurl=b.getString("my images");
        String titles=b.getString("my date");
        String desc=b.getString("my time");

        Glide.with(this).load(imagesurl).centerCrop().placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
        title.setText(titles);
        description.setText(desc);


    }
}