package com.abhay.fitnessapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FitnessInterface {

    @GET("read.php")
    Call<Example>getrecord();

    @GET("chest.php")
    Call<Example>getchest();

    @GET("Arms.php")
    Call<Example>getArms();


    @GET("legs.php")
    Call<Example>getlegs();

    @GET("shoulders.php")
    Call<Example>getshoulders();

    @GET("full_body.php")
    Call<Example>getfull_body();

    @GET("lower_body.php")
    Call<Example>getlower_body();

    @GET("Abs.php")
    Call<Example>getAbs();

}
