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
import com.forif.watnyam.model.GoogleData;

import java.util.ArrayList;

public class GoogleRvAdapter extends RecyclerView .Adapter<GoogleRvAdapter.GoogleViewHolder>{

    Context context;
    ArrayList<GoogleData> googleDataArrayList;

    public GoogleRvAdapter(Context context, ArrayList<GoogleData> googleDataArrayList) {
        this.context = context;
        this.googleDataArrayList = googleDataArrayList;
    }

    @NonNull
    @Override
    public GoogleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_google, parent, false);
        return new GoogleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoogleViewHolder holder, int position) {

        holder.textView.setText(googleDataArrayList.get(position).getTitle());
        holder.textView2.setText(googleDataArrayList.get(position).getSnippet());
        if(googleDataArrayList.get(position).getThumbnail() != null){
            Glide.with(context).load(Uri.parse(googleDataArrayList.get(position).getThumbnail()))
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return googleDataArrayList.size();
    }

    class GoogleViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView2;

        public GoogleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_google_img);
            textView = itemView.findViewById(R.id.tv_vh_google_title);
            textView2 = itemView.findViewById(R.id.tv_vh_google_description);
        }
    }
}
