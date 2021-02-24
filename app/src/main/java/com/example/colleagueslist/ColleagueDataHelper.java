package com.example.colleagueslist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ColleagueDataHelper extends SQLiteOpenHelper {

    public ColleagueDataHelper(@Nullable Context context) {
        super(context, ColleagueListContract.Table.NAME+".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREAT_QUERY = "CREATE TABLE " + ColleagueListContract.Table.NAME + "(" + ColleagueListContract.Column._ID
                + "INTEGER ," + ColleagueListContract.Column.PERSON_NAME + " TEXT NOT NULL,"
                + ColleagueListContract.Column.PHONE + " TEXT ,"
                + ColleagueListContract.Column.INSTITUTION_NAME + " TEXT ,"
                + ColleagueListContract.Column.EMAIL + " TEXT " + ");";

        db.execSQL(SQL_CREAT_QUERY);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
