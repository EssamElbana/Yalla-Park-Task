package com.example.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Stadium;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StadiumListAdapter extends RecyclerView.Adapter<StadiumListAdapter.ViewHolder> {

    private List<Stadium> mData;
    private LayoutInflater mInflater;

    StadiumListAdapter(Context context, List<Stadium> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.stadium_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Stadium stadium = mData.get(position);
        holder.stadiumNameTextView.setText(stadium.getName());
        holder.stadiumCityTextView.setText(stadium.getCity());
        holder.setCarImage(stadium.getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView stadiumNameTextView, stadiumCityTextView;
        ImageView stadiumImage;

        ViewHolder(View itemView) {
            super(itemView);
            stadiumNameTextView = itemView.findViewById(R.id.stadium_name);
            stadiumCityTextView = itemView.findViewById(R.id.stadium_city);
            stadiumImage = itemView.findViewById(R.id.stadium_image);
        }

        void setCarImage(String url) {
            Picasso.get().load(url).into(stadiumImage);
        }
    }
}