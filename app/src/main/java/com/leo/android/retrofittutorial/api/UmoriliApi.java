package com.leo.android.retrofittutorial.api;

import com.leo.android.retrofittutorial.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leonidtiskevic on 06.07.17.
 */

public interface UmoriliApi {
    @GET("/api/get")
    Call<List<PostModel>> getData(@Query("name") String resourseName, @Query("num") int count);
}
