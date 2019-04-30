package com.rio.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.rio.sqliteexample.DatabaseContract.DATABASE_NAME;
import static com.rio.sqliteexample.DatabaseContract.DATABASE_VERSION;
import static com.rio.sqliteexample.DatabaseContract.TeamColumn.ID;
import static com.rio.sqliteexample.DatabaseContract.TeamColumn.NAME;
import static com.rio.sqliteexample.DatabaseContract.TABLE_NAME;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static String CREATE_TABLE=
            "create table "+ TABLE_NAME +" ("+
                    ID+" text not null, "+
                    NAME+" text not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME+";";
        db.execSQL(query);
        onCreate(db);
    }
}
