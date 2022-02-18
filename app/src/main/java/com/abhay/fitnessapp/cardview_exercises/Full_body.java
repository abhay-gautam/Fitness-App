package com.abhay.fitnessapp.cardview_exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

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

public class  Full_body extends AppCompatActivity {
    private static final String TAG = "Full Body";
    FitnessInterface fitnessInterface;
    ImageView imageView;


    private static final String urlfull_body= "https://fitness777.000webhostapp.com/api/images/";


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
                .baseUrl(urlfull_body)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        fitnessInterface = retrofit.create(FitnessInterface.class);

        getsfull_body();

    }

    private void getsfull_body() {
        Call<Example> call = fitnessInterface.getlegs();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                Log.d(TAG, "this is your responce" + response);
                progressBar.setVisibility(View.GONE);
                ArrayList<Example.Record> record = new ArrayList<>(response.body().getRecords());
                adapter = new Adapter(Full_body.this,record);
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