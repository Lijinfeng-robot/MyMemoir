package com.example.mymemoir.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mymemoir.entity.WatchList;
import com.example.mymemoir.fragment.Watchlist;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * @author LiJinFeng
 */
@Dao
public interface WatchListDAO {
    @Query("SELECT * FROM WatchList")
    LiveData<List<WatchList>> getAll();

    @Query("SELECT * FROM watchList WHERE uid = :watchlistId LIMIT 1")
    WatchList findByID(int watchlistId);

    @Insert
    void insertAll(WatchList... watchlists);

    @Insert
    long insert(WatchList watchlist);

    @Delete
    void delete(WatchList watchlist);

    @Update(onConflict = REPLACE)
    void updateWatchlists(WatchList[] watchlists);

    @Query("DELETE FROM watchList")
    void deleteAll();

    @Query("UPDATE watchList SET MovieName=:MovieName, ReleaseDate=:ReleaseDate, AddedDate=:AddedDate WHERE uid = :id")
    void updatebyID(int id, String MovieName, String ReleaseDate, String AddedDate);
}