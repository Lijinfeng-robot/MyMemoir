package com.example.mymemoir.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mymemoir.MovieSearch.ImageAdapter;
import com.example.mymemoir.MovieView;
import com.example.mymemoir.R;
import com.example.mymemoir.api.TheMovieDBAPI;
import com.example.mymemoir.datastructure.convert.DateString;
import com.example.mymemoir.viewmodel.SharedViewModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiJinFeng
 */
public class MovieSearch extends Fragment {
  private EditText etMessage;
  private List<Map<String, Object>> data;
  public static String[] movieName;
  public static String[] movieDate;
  public static String[] movieRate;
  public static String[] movieOverView;
  public static String[] movieUrl;
  private ListView lvImages;
  public static int count = 0;

  public MovieSearch() {
    // Required empty public constructor
  }
  @Override
  public View onCreateView(
          final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the View for this fragment
    View view = inflater.inflate(R.layout.movie_search_fragment, container, false);
    SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    etMessage = view.findViewById(R.id.movieSearch_text);
    Button button = view.findViewById(R.id.movieSearch_button);

    button.setOnClickListener(
        new View.OnClickListener() {
          @SuppressLint("StaticFieldLeak")
          @Override
          public void onClick(View v) {

            final String message = etMessage.getText().toString().trim();
            if (!message.isEmpty()) {
              new  AsyncTask<String, Void, String>(){
                @Override
                protected String doInBackground(String... params) {
                  return TheMovieDBAPI.searchMovie(message);
                }
                @Override
                protected void onPostExecute(String s) {
                  JSONArray res = TheMovieDBAPI.getSnippet(s, "results");
                  movieName = new String[res.length()];
                  movieDate = new String[res.length()];
                  movieRate = new String[res.length()];
                  movieOverView = new String[res.length()];
                  movieUrl = new String[res.length()];
                  data = new ArrayList<Map<String, Object>>();
                  try {
                    for (int i = 0; i < res.length(); i++) {
                      movieName[i] = (String) res.getJSONObject(i).get("title");
                      if (res.getJSONObject(i).has("release_date")
                              && !((String) res.getJSONObject(i).get("release_date")).equals("")) {
                        movieDate[i] = ((String) res.getJSONObject(i).get("release_date"));
                      } else {
                        movieDate[i] = "";
                      }
                      String temp = String.valueOf(res.getJSONObject(i).get("vote_average"));
                      movieRate[i] = String.valueOf((Double.parseDouble(temp)) * 10);
                      movieOverView[i] = (String) res.getJSONObject(i).get("overview");
                      movieUrl[i] = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + res.getJSONObject(i).get("poster_path");
                      //memoir.setMemoirId((Integer)
                      // res.getJSONObject(i).get("id"));
                    }
                  } catch (JSONException e) {
                    e.printStackTrace();
                  }
                  for (int i = 0; i < movieName.length; i++) {
                      Map<String, Object> map = new HashMap<String, Object>();
                      map.put("url", movieUrl[i]);
                      data.add(map);
                  }
                  BaseAdapter adapter = new ImageAdapter(getActivity(), data);
                  lvImages.setAdapter(adapter);
                }
              }.execute();
            }
          }
        });
    lvImages = view.findViewById(R.id.lv_images);

      lvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view,
                                  int position, long id) {
              count = position;
              Intent intent = new Intent(getActivity(), MovieView.class);
              startActivity(intent);
          }
      });
    return view;
  }
    }

