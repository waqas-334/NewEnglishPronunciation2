package com.androidbull.mypronounce;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Numan Gillani on 11/05/17.
 */
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
    }

    @Override
    public void onClick(View view) {
      //passing the clicked position to the parent class

      onItemClickListener.onItemClick(null, view, getAdapterPosition(), view.getId());
    }
  }

  public AlbumsAdapter(Context mContext, AdapterView.OnItemClickListener onItemClickListener,
      List<RowItem> albumList) {
    this.mContext = mContext;
    this.albumList = albumList;
    this.onItemClickListener = onItemClickListener;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.album_card, parent, false);

    return new MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(final MyViewHolder holder, int position) {
    RowItem album = albumList.get(position);
    holder.title.setText(album.getName());
    holder.lesson.setText(album.getLesson());

  }

  @Override
  public int getItemCount() {
    return albumList.size();
  }
}
