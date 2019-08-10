package com.example.retrofitpractice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.retrofitpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    List<Post> posts;
    private Adapter adapter;
    int i;
    //String h;
    public static final String BASE_URL = "http://api.openweathermap.org/";
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        posts = new ArrayList<>();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getPosts();
        // setUpAdapter();

        //adapter = new Adapter(null, this);
        //createPost();
        //updatePosts();
        //deletePost();
    }

    public void getPosts() {

        Call<WeatherList> call = jsonPlaceHolderApi.getPosts("37.0902", "-95.7129", 50, "efbcfd06753e965bb0bc8f0850aa6c7c");
        call.enqueue(new Callback<WeatherList>() {
            @Override
            public void onResponse(Call<WeatherList> call, Response<WeatherList> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getPosts " + response.code());
                }
                //ArrayList<Post> user_array;

                Log.d(TAG, "GOT THEM " + response.code());

                posts = response.body().getWeather();

                if (posts != null) {
                    setUpAdapter();
                }

            }

            @Override
            public void onFailure(Call<WeatherList> call, Throwable t) {

                Log.d(TAG, "GOT THEM " + t.getMessage());

            }
        });
    }


    private void setUpAdapter() {
        adapter = new Adapter(posts, MainActivity.this);
        activityMainBinding.rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        activityMainBinding.rv.setHasFixedSize(true);
        activityMainBinding.rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public String Hey() {
        i = 5 + 5;
        return "Coffeyville";
    }

}
