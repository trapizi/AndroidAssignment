package com.example.steven.spaghetti.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.steven.spaghetti.Interface.ItemClickListener;
import com.example.steven.spaghetti.R;

/**
 * Created by Steven on 13-Oct-17.
 */

public class QuizViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView quiz_name;
    public ImageView quiz_image;

    private ItemClickListener itemClickListener;

    public QuizViewHolder(View itemView) {
        super(itemView);
        quiz_image = (ImageView)itemView.findViewById(R.id.quiz_image);
        quiz_name = (TextView)itemView.findViewById(R.id.quiz_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
