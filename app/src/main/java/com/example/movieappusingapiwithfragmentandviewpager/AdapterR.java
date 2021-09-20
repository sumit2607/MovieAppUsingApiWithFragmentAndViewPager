package com.example.movieappusingapiwithfragmentandviewpager;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterR extends RecyclerView.Adapter<ViewHolderR> {
    List<NowShowingDTO> list;
    public AdapterR(List<NowShowingDTO> list){
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolderR onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolderR(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderR holder, int position) {
        NowShowingDTO model = list.get(position);
        holder.setData(model);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
