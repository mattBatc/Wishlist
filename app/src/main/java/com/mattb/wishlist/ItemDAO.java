package com.mattb.wishlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Item> items);

    @Insert
    void insert(Item item);

    @Delete
    void deleteItem(Item item);

    @Query("DELETE FROM item_table")
    void deleteAll();

    @Query("SELECT * FROM item_table ORDER BY name ASC")
    LiveData<List<Item>> getAllItems();
}
