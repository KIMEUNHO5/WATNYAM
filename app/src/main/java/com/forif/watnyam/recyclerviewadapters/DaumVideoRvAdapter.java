package com.forif.watnyam.recyclerviewadapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forif.watnyam.R;
import com.forif.watnyam.model.DaumVideoData;

import java.util.ArrayList;

public class DaumVideoRvAdapter extends RecyclerView.Adapter<DaumVideoRvAdapter.DaumVideoViewHolder>{

    private Context context;
    private ArrayList<DaumVideoData> daumVideoDataArrayList;

    public DaumVideoRvAdapter(Context context, ArrayList<DaumVideoData> daumVideoDataArrayList) {
        this.context = context;
        this.daumVideoDataArrayList = daumVideoDataArrayList;
    }

    @NonNull
    @Override
    public DaumVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_daum_video, parent, false);
        return new DaumVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaumVideoViewHolder holder, int position) {

        if(daumVideoDataArrayList.get(position).getThumbnail() != null){
            Glide.with(context)
                    .load(Uri.parse(
                            daumVideoDataArrayList.get(position).getThumbnail()
                    )).into(holder.imageView);
        }
        holder.textView.setText(daumVideoDataArrayList.get(position).getTitle());

        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(daumVideoDataArrayList.get(position).getUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return daumVideoDataArrayList.size();
    }

    class DaumVideoViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        FrameLayout frameLayout;

        public DaumVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_daum_video);
            textView = itemView.findViewById(R.id.tv_vh_daum_video_title);
            frameLayout = itemView.findViewById(R.id.vh_duam_video_frame);
        }
    }
}
