package com.example.mymemoir.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mymemoir.datastructure.ListWatch;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * @author LiJinFeng
 */
@Dao
public interface WatchListDAO {
    @Query("SELECT * FROM ListWatch")
    LiveData<List<ListWatch>> getAll();

    @Query("SELECT * FROM ListWatch WHERE uid = :listWatchId LIMIT 1")
    ListWatch findByID(int listWatchId);

    @Insert
    void insertAll(ListWatch... listWatchs);

    @Insert
    long insert(ListWatch listWatch);

    @Delete
    void delete(ListWatch listWatch);

    @Update(onConflict = REPLACE)
    void updateWatchlists(ListWatch[] listWatchs);

    @Query("DELETE FROM ListWatch")
    void deleteAll();

    @Query("UPDATE ListWatch SET MovieName=:MovieName, ReleaseDate=:ReleaseDate, AddedDate=:AddedDate ,Overview=:Overview ,Star=:Star WHERE uid = :id")
    void updatebyID(int id, String MovieName, String ReleaseDate, String AddedDate, String Overview, float Star);

    @Query("DELETE FROM ListWatch WHERE MovieName=:MovieName")
    void deleteByMovieName(String MovieName);
}