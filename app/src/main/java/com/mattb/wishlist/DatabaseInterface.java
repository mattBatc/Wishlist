package com.mattb.wishlist;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class DatabaseInterface {

    private static final String TAG = DatabaseInterface.class.getName();

    public static void delItem(@NonNull final AppDatabase db, Item item){
        db.itemDAO().deleteItem(item);
        Log.d(DatabaseInterface.TAG,"Deleted" + item.getName());
    }

    public static void addItem(@NonNull final AppDatabase db, Item item){
        db.itemDAO().insert(item);
        Log.d(DatabaseInterface.TAG,"Added" + item.getName());
    }

    public static void nukeList(@NonNull final AppDatabase db){
        db.itemDAO().deleteAll();
        Log.d(DatabaseInterface.TAG,"Nuked List");
    }

    public static List<Item> getList(@NonNull final AppDatabase db){
        List<Item> items = db.itemDAO().getAllItems();
        Log.d(DatabaseInterface.TAG, "Returned List");
        return items;
    }
}
