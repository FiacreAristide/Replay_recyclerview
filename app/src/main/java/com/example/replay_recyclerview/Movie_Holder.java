package com.example.replay_recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class Movie_Holder extends RecyclerView.ViewHolder {
    TextView title,subtitle;
    ImageView picture;

    public Movie_Holder(@NonNull View itemView) {
        super(itemView);
         title = itemView.findViewById(R.id.titre);
         subtitle = itemView.findViewById(R.id.s_titre);
         picture = itemView.findViewById(R.id.imageview);

    }
}
