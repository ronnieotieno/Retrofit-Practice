package com.example.retrofitpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    JsonPlaceHolderApi jsonPlaceHolderApi;
    RecyclerView recyclerView;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);

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
        //createPost();
        //updatePosts();
       // deletePost();
    }

    public void getPosts() {

        Map<String, String> parameters = new HashMap<>();
        //parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "asc");


        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(parameters);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: getPosts" + response.code());
                } else {

                    List<Post> posts = response.body();

                    //posts.add(new Post(1, "yes", "no"));

                    if (posts != null) {

                        Adapter adapter = new Adapter(posts, getApplicationContext());
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(adapter);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    public void createPost() {

        Post post = new Post(1, "New Title", "New Text");

        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                Post posts = response.body();

                Log.d(TAG, "onResponse: NewPosts " + response.code());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }

    public void updatePosts () {

        Post post = new Post (1,"NewUpdate","NewUpdate");

        Call <Post> call = jsonPlaceHolderApi.putPost(2,post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                Log.d(TAG, "onResponse: update " + response.code());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public  void deletePost () {
        Call<Void> call  = jsonPlaceHolderApi.deletePost(4);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: Delete with " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
