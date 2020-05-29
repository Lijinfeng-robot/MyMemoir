package com.example.mymemoir.MovieSearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymemoir.R;
import com.example.mymemoir.fragment.MovieSearch;

import java.util.List;
import java.util.Map;

/**
 * @author LiJinFeng
 */
public class ImageAdapter extends BaseAdapter {

    private List<Map<String, Object>> data;

    private Context context;

    private ViewHolder viewHolder;

    public ImageAdapter(Context context, List<Map<String, Object>> data) {
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
            convertView = View.inflate(context, R.layout.moviesearch_item, null);
            viewHolder.iv_image = (ImageView) convertView
                    .findViewById(R.id.iv_image);
            viewHolder.tv_url = (TextView) convertView
                    .findViewById(R.id.tv_url);
            viewHolder.tv_url2 = (TextView) convertView
                    .findViewById(R.id.tv_url2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Map<String, Object> map = data.get(position);
        String url = map.get("url").toString();
        GetImageByUrl getImageByUrl = new GetImageByUrl();
        getImageByUrl.setImage(viewHolder.iv_image, url);
        viewHolder.tv_url.setText(MovieSearch.movieName[position]);
        viewHolder.tv_url2.setText("Release Date:" + MovieSearch.movieDate[position]);

        return convertView;
    }

    class ViewHolder {
        public ImageView iv_image;
        public TextView tv_url;
        public TextView tv_url2;
    }

}