package com.example.retrofitpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    List<Post>mPost;
    Context context;

    public Adapter(List<Post> mPost, Context context) {
        this.mPost = mPost;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_adapter, viewGroup, false);

        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {

        Post post = mPost.get(i);
        adapterViewHolder.text.setText(post.getText());
        adapterViewHolder.email.setText(post.getTitle());
        adapterViewHolder.id.setText(String.valueOf(post.getId()));
        adapterViewHolder.userid.setText(String.valueOf(post.getUserId()));

    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        TextView id, userid, email, text;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            userid = itemView.findViewById(R.id.userid);
            email = itemView.findViewById(R.id.email);
            text = itemView.findViewById(R.id.text);

        }
    }
}
