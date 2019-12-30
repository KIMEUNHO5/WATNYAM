package com.forif.watnyam.recyclerviewadapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forif.watnyam.R;
import com.forif.watnyam.database.LikedPost;
import com.forif.watnyam.database.MyRoomRepo;
import com.forif.watnyam.database.MyRoomViewModel;
import com.forif.watnyam.model.DaumVideoData;

import java.util.ArrayList;

public class DaumVideoRvAdapter extends RecyclerView.Adapter<DaumVideoRvAdapter.DaumVideoViewHolder>{

    private Context context;
    private ArrayList<DaumVideoData> daumVideoDataArrayList;
    private MyRoomRepo myRoomRepo;

    public DaumVideoRvAdapter(Context context, ArrayList<DaumVideoData> daumVideoDataArrayList, MyRoomRepo myRoomRepo) {
        this.context = context;
        this.daumVideoDataArrayList = daumVideoDataArrayList;
        this.myRoomRepo = myRoomRepo;
    }

    @NonNull
    @Override
    public DaumVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_daum_video, parent, false);
        return new DaumVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaumVideoViewHolder holder, int position) {

        String thumbnail = daumVideoDataArrayList.get(position).getThumbnail();
        String title = daumVideoDataArrayList.get(position).getTitle();
        String url = daumVideoDataArrayList.get(position).getUrl();

        //set image
        if(thumbnail != null){
            Glide.with(context)
                    .load(Uri.parse(thumbnail)).into(holder.imageView);
        }

        //set title
        if(title != null){
            holder.textView.setText(title);
        }

        //click frame navigates to web link
        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
            }
        });

        //click image button inserts info into the database
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert DB
                holder.imageButton.setImageDrawable(context.getDrawable(R.drawable.ic_favorite_black_24dp));
                myRoomRepo.insertLikedPost(new LikedPost(title, url, thumbnail));


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

        ImageButton imageButton;

        public DaumVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_daum_video);
            textView = itemView.findViewById(R.id.tv_vh_daum_video_title);
            frameLayout = itemView.findViewById(R.id.vh_duam_video_frame);

            imageButton = itemView.findViewById(R.id.img_btn_like);
        }
    }
}
