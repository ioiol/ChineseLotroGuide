package com.fc.lotro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.lotro.R;
import com.fc.lotro.entity.GridListItem;

import java.util.ArrayList;

/**
 * Created by tytyfn on 2016/8/9.
 *
 * Adapter for Class Grid.
 */
public class ClassAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater ;
    private ArrayList<GridListItem> items;
    public ClassAdapter(Context context, ArrayList<GridListItem> list){
        mContext = context;
        items = list;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (null == view) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_layout_grid, null);
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imageView.setBackgroundResource(items.get(i).getPhotoId());
        holder.textView.setText(items.get(i).getTitle());
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
