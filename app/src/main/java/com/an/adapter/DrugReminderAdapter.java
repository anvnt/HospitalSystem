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
import com.an.model.DrugReminder;

import java.util.ArrayList;
import java.util.List;

public class DrugReminderAdapter extends ArrayAdapter <DrugReminder> {
    Activity context;
    int resource;

    public DrugReminderAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View customView=inflater.inflate(this.resource,null);
        DrugReminder item = getItem(position);

        //lấy các controls trên giao diện
        ImageView imgPacman = customView.findViewById(R.id.imgPacman);
        TextView txtDrugName = customView.findViewById(R.id.txtDrugName);
        ImageView imgLike = customView.findViewById(R.id.imgLike);
        //nạp dữ liệu lên listview
        DrugReminder dr = getItem(position);
        imgPacman.setImageResource(dr.getImgpacman());
        txtDrugName.setText(dr.getDrugname());
        imgLike.setImageResource(dr.getImglikeblank());
        return customView;
    }
}
