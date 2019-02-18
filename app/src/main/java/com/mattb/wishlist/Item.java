package com.mattb.wishlist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "item_table")
public class Item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String name;

    public double price;
}