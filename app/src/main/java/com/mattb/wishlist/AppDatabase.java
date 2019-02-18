package com.mattb.wishlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Item.class} ,version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO itemDAO();


    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"database").allowMainThreadQueries().build();
                    System.out.println("Hello!");
                }
        return INSTANCE;
    }
    public static void destroyInstance(){
        INSTANCE = null;
    }
}

