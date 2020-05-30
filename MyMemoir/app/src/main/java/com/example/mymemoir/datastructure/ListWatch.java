package com.example.mymemoir.datastructure;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/** @author LiJinFeng */
@Entity
public class ListWatch {
  @PrimaryKey(autoGenerate = true)
  public int uid;

  @ColumnInfo(name = "MovieName")
  public String MovieName;

  @ColumnInfo(name = "ReleaseDate")
  public String ReleaseDate;

  @ColumnInfo(name = "AddedDate")
  public String AddedDate;

  @ColumnInfo(name = "Overview")
  public String Overview;

  @ColumnInfo(name = "Star")
  public float Star;


  public ListWatch(String MovieName, String ReleaseDate, String AddedDate , String Overview, float Star) {
    this.MovieName = MovieName;
    this.ReleaseDate = ReleaseDate;
    this.AddedDate = AddedDate;
    this.Overview = Overview;
    this.Star = Star;
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

  public String getOverview() {
    return Overview;
  }

  public void setOverview(String Overview) {
    this.Overview =Overview;
  }

  public float getStar() {
    return Star;
  }

  public void setStar(float Star) {
    this.Star = Star;
  }
}
