package com.example.mymemoir.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymemoir.networkconnection.GetImageByUrl;
import com.example.mymemoir.R;
import com.example.mymemoir.fragment.MovieSearch;

import java.util.List;
import java.util.Map;

/**
 * @author LiJinFeng
 */
public class WatchlistAdapter extends BaseAdapter {

    private List<Map<String,String>> data;

    private Context context;

    private ViewHolder viewHolder;

    public WatchlistAdapter(Context context, List<Map<String,String>> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.watchlist_item, null);
            viewHolder.watchList1 = (TextView) convertView
                    .findViewById(R.id.watchlist_text1);
            viewHolder.watchList2 = (TextView) convertView
                    .findViewById(R.id.watchlist_text2);
            viewHolder.watchList3 = (TextView) convertView
                    .findViewById(R.id.watchlist_text3);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Map<String, String> map = data.get(position);
        viewHolder.watchList1.setText("MovieName: " + map.get("name"));
        viewHolder.watchList2.setText("ReleaseDate: " + map.get("release date"));
        viewHolder.watchList3.setText("AddedDate: " + map.get("added date"));

        return convertView;
    }

    class ViewHolder {
        public TextView watchList1;
        public TextView watchList2;
        public TextView watchList3;
    }

}