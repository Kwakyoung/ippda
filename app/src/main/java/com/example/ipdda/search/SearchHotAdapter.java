package com.example.ipdda.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ItemSearchGridHotBinding;

import java.util.ArrayList;

public class SearchHotAdapter extends BaseAdapter {

    ItemSearchGridHotBinding binding;
    LayoutInflater inflater;


    public SearchHotAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 10;
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
        convertView = inflater.inflate(R.layout.item_search_grid_hot, parent , false);

        return convertView;
    }
}
