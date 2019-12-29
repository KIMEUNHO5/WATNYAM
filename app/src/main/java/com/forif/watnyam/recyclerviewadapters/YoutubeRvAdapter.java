package com.forif.watnyam.recyclerviewadapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forif.watnyam.R;
import com.forif.watnyam.model.YoutubeData;

import java.util.ArrayList;

public class YoutubeRvAdapter extends RecyclerView.Adapter<YoutubeRvAdapter.YoutubeViewHolder> {

    Context context;
    ArrayList<YoutubeData> youtubeDataArrayList;

    public YoutubeRvAdapter(Context context, ArrayList<YoutubeData> youtubeDataArrayList) {
        this.context = context;
        this.youtubeDataArrayList = youtubeDataArrayList;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_youtube, parent, false);
        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {
        holder.textView.setText(youtubeDataArrayList.get(position).getTitle());

        if(youtubeDataArrayList.get(position).getThumbnail() != null){
            Glide.with(context).load(Uri.parse(youtubeDataArrayList.get(position).getThumbnail()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return youtubeDataArrayList.size();
    }

    class YoutubeViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public YoutubeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_youtube);
            textView = itemView.findViewById(R.id.tv_vh_youtube_title);
        }
    }
}
