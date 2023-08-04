package com.example.replay_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Movie_Adapter extends RecyclerView.Adapter<Movie_Holder> {
    private Context context;
    private List<Movie> movies;


    public Movie_Adapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;

    }

    @NonNull
    @Override
    public Movie_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Movie_Holder(LayoutInflater.from(context).inflate(R.layout.activity_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Movie_Holder holder, int position) {
        String title =movies.get(position).getTitle();
        String subtitle =movies.get(position).getSubtitle();
        int picture = movies.get(position).getPicture();


        holder.title.setText(title);
        holder.subtitle.setText(subtitle);
        holder.picture.setImageResource(picture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, second_activity.class);
                intent.putExtra("title",title);
                intent.putExtra("subtitle",subtitle);
                intent.putExtra("picture",picture);
                context.startActivity(intent);
            }
        });
    }


    public void setFilteredMovies(List<Movie> filteredList){
        this.movies=filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
