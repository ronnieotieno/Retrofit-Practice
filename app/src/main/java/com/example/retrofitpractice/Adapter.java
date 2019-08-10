package com.example.retrofitpractice;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.retrofitpractice.databinding.ActivityAdapterBinding;

import java.text.DecimalFormat;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private List<Post> mPost;
    private Context context;

    public Adapter(List<Post> mPost, Context context) {
        this.mPost = mPost;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityAdapterBinding activityAdapterBinding = DataBindingUtil.inflate(LayoutInflater
                .from(viewGroup.getContext()), R.layout.activity_adapter, viewGroup, false);

        return new AdapterViewHolder(activityAdapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {

        Post post = mPost.get(i);
        String tempK = post.getMain().getTemp();
        //ConvertTemp(tempK);
        String city = (String.format("City: %s", post.getName()));
        String id = (String.format("ID: %s", post.getId()));
        String des = (String.format("Description: %s", post.getWeatherMains().get(0).getDescription()));
        String temp = (String.format("Temperature: %s", ConvertTemp(tempK)));

        PostDisplay postDisplay = new PostDisplay();
        postDisplay.setCity(city);
        postDisplay.setDesc(des);
        postDisplay.setId(id);
        postDisplay.setTemp(temp);
        Log.d("Adapter", "Ronnie " + postDisplay.getDesc());
        postDisplay.setImage(R.drawable.ic_grain);


        adapterViewHolder.activityAdapterBinding.setPostDisplay(postDisplay);

    }

    private String ConvertTemp(String tempK) {
        Double TempC = Double.parseDouble(tempK) - 273.15;
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        return decimalFormat.format(TempC);
    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }


    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        ActivityAdapterBinding activityAdapterBinding;

        public AdapterViewHolder(ActivityAdapterBinding itemView) {
            super(itemView.getRoot());
            activityAdapterBinding = itemView;

        }
    }

}
