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
public class MovieView extends AppCompatActivity {
  public static String s_movieName;
  public static String s_movieDate;
  public static String s_movieMessage;
  public static String s_movieStar;
  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_view);


    TextView movieName = findViewById(R.id.movie_name);
    TextView movieReleaseDate = findViewById(R.id.movie_date);
    TextView movieDescription = findViewById(R.id.movie_message);
    RatingBar ratingBar = findViewById(R.id.memoir_star);
    Button addWatchlistBtn = findViewById(R.id.memoir_add_watchlist);
    Button addMemoirBtn = findViewById(R.id.memoir_add_memoir);
    Button returnBtn = findViewById(R.id.MovieView_return);

    s_movieName = MovieSearch.movieName[MovieSearch.count];
    s_movieDate = MovieSearch.movieDate[MovieSearch.count];
    s_movieMessage = MovieSearch.movieOverView[MovieSearch.count];
    s_movieStar = MovieSearch.movieRate[MovieSearch.count];

    movieName.setText("Movie Name: " + s_movieName);
    movieReleaseDate.setText("Release Date:  " + s_movieDate);
    movieDescription.setText("Overview:  " + s_movieMessage);
    ratingBar.setRating(RatingStar.rating2Star(s_movieStar));

    addWatchlistBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ListWatch temp = new ListWatch(s_movieName,s_movieDate,formatter.format(new Date()),s_movieMessage,Float.parseFloat(s_movieStar));
        MainScreen.watchListViewModel.insert(temp);
        Intent intent = new Intent(MovieView.this,MainScreen.class);
        startActivity(intent);
        sendToast("Add this movie to WatchList successfully!");
      }
    });
    returnBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent( MovieView.this, MainScreen.class);
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
