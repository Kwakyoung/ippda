package com.example.ipdda.like;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ipdda.R;

public class LikeAdapter extends BaseAdapter {


    LayoutInflater inflater;

    public LikeAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }



    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_like_grid, parent , false);
        return convertView;
    }
}
