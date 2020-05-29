package com.example.mymemoir.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/** @author LiJinFeng */
@Entity
public class WatchList {
  @PrimaryKey(autoGenerate = true)
  public int uid;

  @ColumnInfo(name = "MovieName")
  public String MovieName;

  @ColumnInfo(name = "ReleaseDate")
  public String ReleaseDate;

  @ColumnInfo(name = "AddedDate")
  public String AddedDate;

  public WatchList(String MovieName, String ReleaseDate, String AddedDate) {
    this.MovieName = MovieName;
    this.ReleaseDate = ReleaseDate;
    this.AddedDate = AddedDate;
  }

  public int getId() {
    return uid;
  }

  public String getMovieName() {
    return MovieName;
  }

  public void setMovieName(String MovieName) {
    this.MovieName = MovieName;
  }

  public String getReleaseDate() {
    return ReleaseDate;
  }

  public void setReleaseDate(String ReleaseDate) {
    this.ReleaseDate = ReleaseDate;
  }

  public String getAddedDate() {
    return AddedDate;
  }

  public void setAddedDate(String AddedDate) {
    this.AddedDate = AddedDate;
  }
}
