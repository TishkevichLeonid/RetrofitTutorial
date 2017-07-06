package com.leo.android.retrofittutorial;

import android.app.Application;

import com.leo.android.retrofittutorial.api.UmoriliApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leonidtiskevic on 06.07.17.
 */

public class App extends Application {

    private static UmoriliApi sUmoriliApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://www.umori.li/") // базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) // Конвертер, необходимый для
                // преобразования JSON'а в объекты

                .build();

        sUmoriliApi = mRetrofit.create(UmoriliApi.class); //Создаем объект,
        // при помощи которого будем выполнять запросы
    }

    public static UmoriliApi getUmoriliApi(){
        return sUmoriliApi;
    }
}
