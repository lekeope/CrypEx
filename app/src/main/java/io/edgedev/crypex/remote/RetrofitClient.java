package io.edgedev.crypex.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/27/2017.
 */

public class RetrofitClient {
    private static Retrofit mRetrofit = null;

    private RetrofitClient(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

   public static Retrofit getClient(String baseURL){
       if (mRetrofit == null)
           mRetrofit = new Retrofit.Builder().baseUrl(baseURL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       return mRetrofit;
   }
}
