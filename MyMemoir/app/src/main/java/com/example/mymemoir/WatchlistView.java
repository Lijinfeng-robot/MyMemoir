package com.example.mymemoir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mymemoir.datastructure.ListWatch;
import com.example.mymemoir.datastructure.convert.RatingStar;
import com.example.mymemoir.fragment.MovieSearch;
import com.example.mymemoir.fragment.Watchlist;
import com.example.mymemoir.viewmodel.WatchListViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiJinFeng
 */
public class WatchlistView extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watchlist_view);

        TextView movieName = findViewById(R.id.movie_name2);
        TextView movieReleaseDate = findViewById(R.id.movie_date2);
        TextView movieDescription = findViewById(R.id.movie_message2);
        RatingBar ratingBar = findViewById(R.id.memoir_star2);
        Button returnBtn = findViewById(R.id.watchlist_view_return);
//        Button addMemoirBtn = findViewById(R.id.watchlist_view_add);


        movieName.setText("Movie Name: " + Watchlist.data.get(Watchlist.count).get("name"));
        movieReleaseDate.setText("Release Date:  " + Watchlist.data.get(Watchlist.count).get("release date"));
        movieDescription.setText("Overview:  " + Watchlist.data.get(Watchlist.count).get("overview"));
        ratingBar.setRating(RatingStar.rating2Star(Watchlist.data.get(Watchlist.count).get("star")));

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchlistView.this, MainScreen.class);
                startActivityForResult(intent, 1);
            }
        });

//
//    addMemoirBtn.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Intent intent = new Intent(MovieMemoirActivity.this, AddToMemoirActivity.class);
//        startActivity(intent);
//      }
//    });
    }
    protected void sendToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
