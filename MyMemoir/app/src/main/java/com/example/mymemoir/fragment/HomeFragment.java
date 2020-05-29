package com.example.mymemoir.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mymemoir.LoginIn;
import com.example.mymemoir.R;
import com.example.mymemoir.networkconnection.NetworkConnection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author LiJinFeng
 */
public class HomeFragment extends Fragment {

    private TextView textView;
    private TextView textView2;
    ListView unitList;

    List<HashMap<String, String>> unitListArray;
    SimpleAdapter myListAdapter;
    String[] colHEAD = new String[] {"MovieName","Dates","Scores"};
    int[] dataCell = new int[] {R.id.Movie_Name,R.id.Release_Date,R.id.Rating_Score};
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the View for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        textView=view.findViewById(R.id.homeImage1);
        textView.setText("Welcome to " + LoginIn.title);
        Date curtime = new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        textView2=view.findViewById(R.id.homeImage2);
        textView2.setText("Current Date: " + formatter.format(curtime));

        // adding the listView
        unitList = (ListView)view.findViewById(R.id.listView);
        unitListArray = new ArrayList<HashMap<String, String>>();
        String[] temp = NetworkConnection.MainResults;

        HashMap<String,String> tempMap = new HashMap<String,String>();
        tempMap.put("MovieName","MovieName");
        tempMap.put("Dates","Dates");
        tempMap.put("Scores","Scores");
        unitListArray.add(tempMap);
        if(temp.length>1){
            int curmin = Math.min(temp.length,14);
            for(int i = 0;i<curmin;i+=3){
                HashMap<String,String> map = new HashMap<String,String>();
                map.put("MovieName",temp[i]);
                map.put("Dates",temp[i+1]);
                map.put("Scores",temp[i+2]);
                unitListArray.add(map);
            }
        }

        myListAdapter = new SimpleAdapter(getActivity(),unitListArray,R.layout.mainscreen_list_view,colHEAD,dataCell);
        unitList.setAdapter(myListAdapter);
        return view;
    } }