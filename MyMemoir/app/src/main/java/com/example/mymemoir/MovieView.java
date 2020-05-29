package com.example.mymemoir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymemoir.datastructure.convert.RatingStar;
import com.example.mymemoir.fragment.MovieSearch;

/**
 * @author LiJinFeng
 */
public class MovieView extends AppCompatActivity {
  private TextView movieName;
  private TextView movieDescription;
  private TextView movieReleaseDate;
  private Button addWatchlistBtn;
  private Button addMemoirBtn;
  private RatingBar ratingBar;
  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_view);


    movieName = findViewById(R.id.movie_name);
    movieReleaseDate = findViewById(R.id.movie_date);
    movieDescription = findViewById(R.id.movie_message);
    ratingBar = findViewById(R.id.memoir_star);
    addWatchlistBtn = findViewById(R.id.memoir_add_watchlist);
    addMemoirBtn = findViewById(R.id.memoir_add_memoir);

    movieName.setText("Movie Name: " + MovieSearch.movieName[MovieSearch.count]);
    movieReleaseDate.setText("Release Date:  " + MovieSearch.movieDate[MovieSearch.count]);
    movieDescription.setText("Overview:  " + MovieSearch.movieOverView[MovieSearch.count]);
    ratingBar.setRating(RatingStar.rating2Star(MovieSearch.movieRate[MovieSearch.count]));
//    addWatchlistBtn.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        String[] details = new String[]{
//                "" + memoir.getMemoirId(), memoir.getMovieName()
//        };
//        InsertDatabase insertDatabase = new InsertDatabase();
//        insertDatabase.execute(details);
//      }
//    });
//
//    addMemoirBtn.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Intent intent = new Intent(MovieMemoirActivity.this, AddToMemoirActivity.class);
//        startActivity(intent);
//      }
//    });
  }
  }
