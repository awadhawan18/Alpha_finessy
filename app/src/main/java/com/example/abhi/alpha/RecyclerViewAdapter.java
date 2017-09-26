package com.example.abhi.alpha;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<HashMap<String,String>> myValues;
    private Context mContext;
    public RecyclerViewAdapter (Context mContext,ArrayList<HashMap<String,String>> myValues){
        this.myValues= myValues;
        this.mContext= mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HashMap<String,String>temp = myValues.get(position);
        holder.myTextView.setText(temp.get("description"));
        Picasso.with(mContext).load(temp.get("image-url")).into(holder.myImageView);
    }


    @Override
    public int getItemCount() {
        return myValues.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView myTextView;
        private ImageView myImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView)itemView.findViewById(R.id.card_text);
            myImageView = (ImageView)itemView.findViewById(R.id.card_image);
        }
    }
}
