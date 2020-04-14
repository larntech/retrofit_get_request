package net.larntech.retrofit;

import net.larntech.retrofit.service.UserInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    private static Retrofit getClient(){


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }


    public static UserInterface getService(){
       UserInterface userInterface  = getClient().create(UserInterface.class);

       return userInterface;
    }

}
