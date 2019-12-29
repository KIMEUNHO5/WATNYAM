package com.forif.watnyam.recyclerviewadapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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
import com.forif.watnyam.model.NaverImageData;

import java.util.ArrayList;

public class NaverImageRvAdapter extends RecyclerView.Adapter<NaverImageRvAdapter.NaverImageViewHolder>{

    Context context;
    ArrayList<NaverImageData> naverImageDataArrayList;

    public NaverImageRvAdapter(Context context, ArrayList<NaverImageData> naverImageDataArrayList) {
        this.context = context;
        this.naverImageDataArrayList = naverImageDataArrayList;
    }

    @NonNull
    @Override
    public NaverImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_naver_image, parent, false);
        return new NaverImageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NaverImageViewHolder holder, int position) {
        holder.textView.setText(naverImageDataArrayList.get(position).getTitle());

        Glide.with(context).load(Uri.parse(naverImageDataArrayList.get(position).getThumbnail()))
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(naverImageDataArrayList.get(position).getLink()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return naverImageDataArrayList.size();
    }

    class NaverImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        FrameLayout frameLayout;

        public NaverImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_naver);
            textView = itemView.findViewById(R.id.tv_vh_naver_image_title);
            frameLayout = itemView.findViewById(R.id.vh_naver_image_frame);

        }
    }
}
