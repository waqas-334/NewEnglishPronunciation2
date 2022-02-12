package com.androidbull.mypronounce.TestWords;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.androidbull.mypronounce.R;
import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<RowItem> albumList;
    private AdapterView.OnItemClickListener onItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView lesson;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            lesson = (TextView) view.findViewById(R.id.lesson);

            itemView.setOnClickListener(this);
            Log.d("WAQAS", "MyViewHolder Constructor was called");

        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(null, view, getAdapterPosition(), view.getId());
        }
    }

    public AlbumsAdapter(Context mContext, AdapterView.OnItemClickListener onItemClickListener, List<RowItem> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homo_card, parent, false);


        Log.d("WAQAS", "MyViewHolder was called");
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        RowItem album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.lesson.setText(album.getLesson());
        Log.d("WAQAS", "onBindViewHolder was called");


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
