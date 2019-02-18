package com.mattb.wishlist;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "group_table")
public class Group {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
}
