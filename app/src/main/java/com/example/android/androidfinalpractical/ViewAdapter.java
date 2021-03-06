package com.example.android.androidfinalpractical;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C4Q on 2/25/18.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{

    static final String URL_KEY = "url";
    List<String> images = new ArrayList<>();

    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.ViewAdapterHolder, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewAdapter.ViewHolder holder, int position) {
        final String url = images.get(position);
        Picasso.with(holder.imageView.getContext()).load(url).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.imageView.getContext();
                Intent intent = new Intent(context, PhotoActivity.class);
                intent.putExtra(URL_KEY, url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setData(List<String> images) {
        this.images = images;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}