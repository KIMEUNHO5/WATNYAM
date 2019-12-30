package com.forif.watnyam.recyclerviewadapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.forif.watnyam.R;
import com.forif.watnyam.database.LikedPost;

import java.util.ArrayList;

public class LikedPostRvAdapter extends RecyclerView.Adapter<LikedPostRvAdapter.LikedPostViewHolder> {

    private static final String TAG = "LikedPostRvAdapter";

    private Context context;
    private ArrayList<LikedPost> likedPostArrayList;
    View emptyListView;
    View occupiedListView;
    LikedPostViewHolder viewHolder;

    public LikedPostRvAdapter(Context context, ArrayList<LikedPost> likedPostArrayList) {
        this.context = context;
        this.likedPostArrayList = likedPostArrayList;
    }

    @NonNull
    @Override
    public LikedPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        emptyListView = LayoutInflater.from(context).inflate(R.layout.fragment_favorites_empty, parent, false);
        occupiedListView = LayoutInflater.from(context).inflate(R.layout.view_holder_favorites, parent, false);

        Log.d(TAG, "onCreateViewHolder: liked posts = " + likedPostArrayList.size());

        if(likedPostArrayList.size() == 0){
            viewHolder = new LikedPostViewHolder(emptyListView);
        }
        viewHolder = new LikedPostViewHolder(occupiedListView);

        Log.d(TAG, "onCreateViewHolder: View Holder = " + viewHolder);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull LikedPostViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: ViewHolder = " + holder.getItemView());
        if(holder.getItemView() == occupiedListView) {

            Log.d(TAG, "onBindViewHolder: ViewHolder Occupied True");

            String title = likedPostArrayList.get(position).getPostTitle();
            String link = likedPostArrayList.get(position).getPostLink();
            String thumbnail = likedPostArrayList.get(position).getPostThumbnail();

            if (title != null) {
                holder.tvTitle.setText(title);
            }
            if (thumbnail != null) {
                Glide.with(context).load(Uri.parse(thumbnail)).placeholder(R.color.colorWhite).into(holder.imageView);
            }
        }

    }

    @Override
    public int getItemCount() {
        return likedPostArrayList != null ? likedPostArrayList.size() : 0;
    }

    class LikedPostViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvTitle;

        View itemView;

        public LikedPostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            if(itemView == occupiedListView) {
                Log.d(TAG, "LikedPostViewHolder: Running...");
                imageView = itemView.findViewById(R.id.img_vh_liked_posts);
                tvTitle = itemView.findViewById(R.id.tv_vh_liked_posts_content);
            }
        }

        public View getItemView() {
            return itemView;
        }
    }
}
