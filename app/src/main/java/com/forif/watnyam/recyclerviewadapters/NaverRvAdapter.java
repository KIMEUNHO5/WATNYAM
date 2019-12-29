package com.forif.watnyam.recyclerviewadapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forif.watnyam.R;
import com.forif.watnyam.model.NaverData;

import java.util.ArrayList;
import java.util.List;

public class NaverRvAdapter extends RecyclerView.Adapter<NaverRvAdapter.NaverBlogViewHolder>{

    Context context;
    ArrayList<NaverData> naverDataArrayList;

    public NaverRvAdapter(Context context, ArrayList<NaverData> naverDataArrayList) {
        this.context = context;
        this.naverDataArrayList = naverDataArrayList;
    }

    @NonNull
    @Override
    public NaverBlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_naver_blog, parent, false);
        return new NaverBlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NaverBlogViewHolder holder, int position) {

        String title = naverDataArrayList.get(position).getTitle();
        String description = naverDataArrayList.get(position).getDescription();
        holder.textView.setText(Html.fromHtml(title));
        holder.textView2.setText(Html.fromHtml(description));
    }

    @Override
    public int getItemCount() {
        return naverDataArrayList.size();
    }

    class NaverBlogViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView textView2;

        public NaverBlogViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_vh_naver_blog_title);
            textView2 = itemView.findViewById(R.id.tv_vh_naver_blog_description);
        }
    }
}
