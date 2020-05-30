package com.example.mymemoir.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mymemoir.MainScreen;
import com.example.mymemoir.MovieView;
import com.example.mymemoir.R;
import com.example.mymemoir.WatchlistView;
import com.example.mymemoir.adapter.WatchlistAdapter;
import com.example.mymemoir.datastructure.ListWatch;
import com.example.mymemoir.viewmodel.WatchListViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author LiJinFeng
 */
public class Watchlist extends Fragment {

    public static List<Map<String,String>> data = new ArrayList<>();
    public Map<String,String> clickedItem;
    private ListView lvWatchList;
    public static int count = 0;
    public Watchlist() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.watchlist, container, false);
        Button bt_view = view.findViewById(R.id.watchlist_view);
        Button bt_delete = view.findViewById(R.id.watchlist_delete);
        ListView lv = view.findViewById(R.id.watchlist_viewList);
        MainScreen.watchListViewModel.getAllWatchLists().observe(this, new Observer<List<ListWatch>>() {
            @Override
            public void onChanged(@Nullable final List<ListWatch> watchLists) {
                for (ListWatch temp : watchLists) {
                    Map<String,String> map = new HashMap<>();
                    map.put("name",temp.getMovieName());
                    map.put("release date",temp.getReleaseDate());
                    map.put("added date",temp.getAddedDate());
                    map.put("overview",temp.getOverview());
                    map.put("star",String.valueOf(temp.getStar()));
                    data.add(map);
                }
                BaseAdapter adapter = new WatchlistAdapter(getActivity(), data);
                lvWatchList.setAdapter(adapter);
            }
        });
        bt_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), WatchlistView.class);
                        startActivity(intent);
                    }
                });
        bt_delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendToast("DELETE SUCCESSFULLY!");
                        clickedItem  = data.get(count);
                        MainScreen.watchListViewModel.deleteByMovieName(clickedItem.get("name"));
                        data.remove(count);
                        BaseAdapter adapter = new WatchlistAdapter(getActivity(), data);
                        lvWatchList.setAdapter(adapter);
                    }
                });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                    count = position;
            }
        });
        lvWatchList = view.findViewById(R.id.watchlist_viewList);
        return view;
    }
    protected void sendToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
    }
}
