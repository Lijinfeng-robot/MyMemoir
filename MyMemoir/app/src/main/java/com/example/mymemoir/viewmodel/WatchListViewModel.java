package com.example.mymemoir.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mymemoir.entity.WatchList;
import com.example.mymemoir.repository.WatchListRepository;

import java.util.List;

/**
 * @author LiJinFeng
 */
public class WatchListViewModel extends ViewModel {
    private WatchListRepository cRepository;
    private MutableLiveData<List<WatchList>> allWatchLists;

    public WatchListViewModel() {
        allWatchLists = new MutableLiveData<>();
    }

    public void setWatchLists(List<WatchList> watchLists) {
        allWatchLists.setValue(watchLists);
    }

    public LiveData<List<WatchList>> getAllWatchLists() {
        return cRepository.getAllWatchLists();
    }

    public void initalizeVars(Application application) {
        cRepository = new WatchListRepository(application);
    }

    public void insert(WatchList watchList) {
        cRepository.insert(watchList);
    }

    public void insertAll(WatchList... watchLists) {
        cRepository.insertAll(watchLists);
    }

    public void deleteAll() {
        cRepository.deleteAll();
    }

    public void update(WatchList... watchLists) {
        cRepository.updateWatchLists(watchLists);
    }

    public void updateByID(int id, final String MovieName, final String ReleaseDate, final String AddedDate) {
        cRepository.updateWatchListByID(id, MovieName, ReleaseDate, AddedDate);
    }

    public WatchList findByID(int watchListId) {
        return cRepository.findByID(watchListId);
    }
}