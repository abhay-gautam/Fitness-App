package com.abhay.fitnessapp.cardview_exercises;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhay.fitnessapp.Adapter;
import com.abhay.fitnessapp.Example;
import com.abhay.fitnessapp.FitnessInterface;
import com.abhay.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  Lower_body extends AppCompatActivity {
    private static final String TAG = "Lower_body";
    FitnessInterface fitnessInterface;
    ImageView imageView;


    private static final String urlLower_body= "https://fitness777.000webhostapp.com/api/images/";


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Adapter adapter;
    private List<Example.Record> user_list;
    private ProgressBar progressBar;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.VISIBLE);
        connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlLower_body)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        fitnessInterface = retrofit.create(FitnessInterface.class);

        getLower_body();

    }

    private void getLower_body() {
        Call<Example> call = fitnessInterface.getlegs();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                Log.d(TAG, "this is your responce" + response);
                progressBar.setVisibility(View.GONE);
                ArrayList<Example.Record> record = new ArrayList<>(response.body().getRecords());
                adapter = new Adapter(Lower_body.this,record);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d("Error", "you get  the error");
            }
        });
    }
}