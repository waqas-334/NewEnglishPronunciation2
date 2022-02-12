package com.androidbull.mypronounce.DailyLessons.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidbull.mypronounce.DailyLessons.model.lesson;
import com.androidbull.mypronounce.DailyLessons.ui.DetailedActivity;
import com.androidbull.mypronounce.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class MainActAdapter extends RecyclerView.Adapter<MainActAdapter.viewClass> {

    ArrayList<lesson> arrayList;
    Context context;

    public MainActAdapter(ArrayList<lesson> arrayList) {
        this.arrayList = arrayList;
    }

    class viewClass extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, subtitle;

        public viewClass(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            image = itemView.findViewById(R.id.image);
            subtitle = itemView.findViewById(R.id.subtitle);
            title = itemView.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public MainActAdapter.viewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_rec, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new viewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActAdapter.viewClass holder, final int position) {

        Glide.with(holder.image).load(arrayList.get(position).getImage_url()).placeholder(R.drawable.placeholder).into(holder.image);
//        Picasso.get().load(arrayList.get(position).getImage_url()).placeholder(R.drawable.placeholder).into(holder.image);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.subtitle.setText(arrayList.get(position).getSubtitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle pack = new Bundle();
                pack.putString("title", arrayList.get(position).getTitle());
                pack.putString("subtitle", arrayList.get(position).getSubtitle());
                pack.putString("image_url", arrayList.get(position).getImage_url());
                pack.putString("description", arrayList.get(position).getDescription());

                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtras(pack);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
