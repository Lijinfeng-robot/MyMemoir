package com.example.mymemoir.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mymemoir.dao.WatchListDAO;
import com.example.mymemoir.database.WatchListDatabase;

import com.example.mymemoir.entity.WatchList;

import java.util.List;

/** @author LiJinFeng */
public class WatchListRepository {
  private WatchListDAO dao;
  private LiveData<List<WatchList>> allWatchLists;
  private WatchList watchList;

  public WatchListRepository(Application application) {
    WatchListDatabase db = WatchListDatabase.getInstance(application);
    dao = db.watchListDAO();
  }

  public LiveData<List<WatchList>> getAllWatchLists() {
    allWatchLists = dao.getAll();
    return allWatchLists;
  }

  public void insert(final WatchList watchList) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.insert(watchList);
          }
        });
  }

  public void deleteAll() {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.deleteAll();
          }
        });
  }

  public void delete(final WatchList watchList) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.delete(watchList);
          }
        });
  }

  public void insertAll(final WatchList... watchLists) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.insertAll(watchLists);
          }
        });
  }

  public void updateWatchLists(final WatchList... watchLists) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.updateWatchlists(watchLists);
          }
        });
  }

  public void updateWatchListByID(
      final int id, final String MovieName, final String ReleaseDate, final String AddedDate) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.updatebyID(id, MovieName, ReleaseDate, AddedDate);
          }
        });
  }

  public WatchList findByID(final int watchlistId) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            WatchList watchList = dao.findByID(watchlistId);
            setList(watchList);
          }
        });
    return watchList;
  }

  public void setList(WatchList watchList) {
    this.watchList = watchList;
  }
}
