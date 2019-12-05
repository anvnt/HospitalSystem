package com.an.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.an.hospitalsystem.R;
import com.an.model.Newspaper;

public class NewsAdapter  extends ArrayAdapter<Newspaper> {
    Activity context;
    int resource;
    public NewsAdapter(@NonNull Activity context, int resource) {
        super(context,resource);
        this.context=context;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=this.context.getLayoutInflater();
        //nạp dòng item.xml lên
        View customView=inflater.inflate(this.resource,null);
        ImageView imgNewsImage = customView.findViewById(R.id.imgNewsImage);
        TextView txtNewsTitle = customView.findViewById(R.id.txtNewsTitle);
        TextView txtNewsDescription = customView.findViewById(R.id.txtNewsDescription);
        TextView txtNewsSource = customView.findViewById(R.id.txtNewsSource);
        TextView txtNewsDate = customView.findViewById(R.id.txtNewsDate);
        Newspaper news = getItem(position);
        imgNewsImage.setImageResource(news.getImage());
        txtNewsTitle.setText(news.getTitle());
        txtNewsDescription.setText(news.getDescription());
        txtNewsSource.setText(news.getSource());
        txtNewsDate.setText(news.getDate().toString());

        return customView;
    }
}
