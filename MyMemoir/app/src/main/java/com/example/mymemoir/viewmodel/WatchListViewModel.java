package com.example.mymemoir.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mymemoir.datastructure.ListWatch;
import com.example.mymemoir.repository.WatchListRepository;

import java.util.List;

/**
 * @author LiJinFeng
 */
public class WatchListViewModel extends ViewModel {
    private WatchListRepository cRepository;
    private MutableLiveData<List<ListWatch>> allWatchLists;

    public WatchListViewModel() {
        allWatchLists = new MutableLiveData<>();
    }

    public void setWatchLists(List<ListWatch> listWatchs) {
        allWatchLists.setValue(listWatchs);
    }

    public LiveData<List<ListWatch>> getAllWatchLists() {
        return cRepository.getAllWatchLists();
    }

    public void initalizeVars(Application application) {
        cRepository = new WatchListRepository(application);
    }

    public void insert(ListWatch listWatch) {
        cRepository.insert(listWatch);
    }

    public void insertAll(ListWatch... listWatchs) {
        cRepository.insertAll(listWatchs);
    }

    public void deleteAll() {
        cRepository.deleteAll();
    }

    public void deleteByMovieName(final String MovieName) {
        cRepository.deleteByMovieName(MovieName);
    }

    public void update(ListWatch... listWatchs) {
        cRepository.updateWatchLists(listWatchs);
    }

    public void updateByID(int id, final String MovieName, final String ReleaseDate, final String AddedDate ,final String Overview, final float Star) {
        cRepository.updateWatchListByID(id, MovieName, ReleaseDate, AddedDate,Overview, Star);
    }

    public ListWatch findByID(int listWatchId) {
        return cRepository.findByID(listWatchId);
    }
}