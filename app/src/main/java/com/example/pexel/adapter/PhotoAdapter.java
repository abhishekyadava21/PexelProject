package com.example.pexel.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pexel.R;
import com.example.pexel.listener.OnItemClick;
import com.example.pexel.model.Photos;


import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private Context context;
    ArrayList<Photos> photoList;
    private OnItemClick itemClick;

    public PhotoAdapter(Context context, ArrayList<Photos> articleArrayList) {
        this.context = context;
        this.photoList = articleArrayList;
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_photos,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder viewHolder, int i) {
        Photos article=photoList.get(i);
        viewHolder.tvTitle.setText(article.getPhotographer());
        Glide.with(context)
                .load(article.getSrc().getOriginal())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView imgViewCover;
        private final ImageView imgProfileCover;
        private final TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);

            imgViewCover= itemView.findViewById(R.id.imgViewCover);
            imgProfileCover= itemView.findViewById(R.id.img_profile);
            tvTitle= itemView.findViewById(R.id.tvTitle);
        }

        @Override
        public void onClick(View v) {
            if (itemClick != null) {
                itemClick.onItemClicked(getAdapterPosition());
            }
        }
    }
}

