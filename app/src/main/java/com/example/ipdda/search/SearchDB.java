package com.example.ipdda.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class SearchDB extends SQLiteOpenHelper {
    private static final String COLUMN_NAME = "goods_name";
    private static final String COLUMN_NUMBER = "number";
    private static final String TABLE_NAME = "IPDDA";

    public List<String> searchContacts(String query) {
        List<String> searchResults = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_NAME, COLUMN_NUMBER};
        String selection = COLUMN_NAME + " LIKE ?";
        String[] selectionArgs = {"%" + query + "%"};
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER));
                searchResults.add(name + " - " + phone);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return searchResults;
    }

    public SearchDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
