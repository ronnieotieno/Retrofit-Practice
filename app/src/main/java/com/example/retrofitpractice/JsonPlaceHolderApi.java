package com.example.retrofitpractice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @Headers("Content-Type: application/json")
    @GET("data/2.5/find")
    Call<WeatherList> getPosts(@Query("lat") String lat,
                               @Query("lon") String lon,
                               @Query("cnt") int count,
                               @Query("appid") String api);


    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
