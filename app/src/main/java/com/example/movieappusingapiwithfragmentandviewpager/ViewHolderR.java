package com.example.movieappusingapiwithfragmentandviewpager;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolderR extends RecyclerView.ViewHolder{
private ImageView mcv_iv_movie_poster;
private TextView mcv_movie_title , mcv_movie_release_date;
private LinearLayout  linearLayout;
    //private OnClickListener onClickListener;

    public ViewHolderR(@NonNull View itemView) {
        super(itemView);
        intitview(itemView);
    }

    private void intitview(View itemView) {
        mcv_iv_movie_poster = itemView.findViewById(R.id.cv_iv_movie_poster);
        mcv_movie_title =itemView.findViewById(R.id.cv_movie_title);
        mcv_movie_release_date = itemView.findViewById(R.id.cv_movie_release_date);
        linearLayout = itemView.findViewById(R.id.LinearLayout);

    }
    public void setData(NowShowingDTO model){
        Glide.with(mcv_iv_movie_poster).load(model.getPosterurl()).into(mcv_iv_movie_poster);
        mcv_movie_title.setText(model.getTitle());
        mcv_movie_release_date.setText(model.getReleaseDate());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      //          onClickListener.onClicked(model,getAdapterPosition());
            }
        });
    }
}
