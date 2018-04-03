package com.hashcode.booker;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hashcode.booker.Constant.BASE_URL;

/**
 * Created by HashCode on 10:36 AM 03/04/2018.
 */

public class RetrofitBuilder {

    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
