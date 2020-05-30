package com.example.mymemoir.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mymemoir.dao.WatchListDAO;
import com.example.mymemoir.database.WatchListDatabase;

import com.example.mymemoir.datastructure.ListWatch;

import java.util.List;

/** @author LiJinFeng */
public class WatchListRepository {
  private WatchListDAO dao;
  private LiveData<List<ListWatch>> allWatchLists;
  private ListWatch listWatch;

  public WatchListRepository(Application application) {
    WatchListDatabase db = WatchListDatabase.getInstance(application);
    dao = db.watchListDAO();
  }

  public LiveData<List<ListWatch>> getAllWatchLists() {
    allWatchLists = dao.getAll();
    return allWatchLists;
  }

  public void insert(final ListWatch listWatch) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.insert(listWatch);
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
  public void deleteByMovieName(final String MovieName){
      WatchListDatabase.databaseWriteExecutor.execute(
              new Runnable() {
                  @Override
                  public void run() {
                      dao.deleteByMovieName(MovieName);
                  }
              });
  }

  public void delete(final ListWatch listWatch) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.delete(listWatch);
          }
        });
  }

  public void insertAll(final ListWatch... listWatchs) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.insertAll(listWatchs);
          }
        });
  }

  public void updateWatchLists(final ListWatch... listWatchs) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.updateWatchlists(listWatchs);
          }
        });
  }

  public void updateWatchListByID(
      final int id, final String MovieName, final String ReleaseDate, final String AddedDate ,final String Overview, final float Star) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            dao.updatebyID(id, MovieName, ReleaseDate, AddedDate,Overview,Star);
          }
        });
  }

  public ListWatch findByID(final int listWatchId) {
    WatchListDatabase.databaseWriteExecutor.execute(
        new Runnable() {
          @Override
          public void run() {
            ListWatch watchList = dao.findByID(listWatchId);
            setList(watchList);
          }
        });
    return listWatch;
  }

  public void setList(ListWatch listWatch) {
    this.listWatch = listWatch;
  }
}
