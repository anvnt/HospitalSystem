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
import com.an.model.Test;

public class TestAdapter extends ArrayAdapter<Test> {
    Activity context; int resource;
    public TestAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View customview=inflater.inflate(this.resource,null);
        ImageView imgTestIcon=customview.findViewById(R.id.imgTestIcon);
        TextView txtTestName=customview.findViewById(R.id.txtTestName);
        Test test=getItem(position);
        imgTestIcon.setImageResource(test.getImgTestIcon());
        txtTestName.setText(test.getTxtTestName());
        return customview;
    }
}
