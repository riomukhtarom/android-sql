package com.rio.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.rio.sqliteexample.DatabaseContract.TABLE_NAME;
import static com.rio.sqliteexample.DatabaseContract.TeamColumn.ID;
import static com.rio.sqliteexample.DatabaseContract.TeamColumn.NAME;

public class TeamHelper {
    private Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;


    public TeamHelper(Context context) {
        this.context = context;
    }

    public TeamHelper open(){
        databaseHelper= new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        databaseHelper.close();
        if (database.isOpen()){
            database.close();
        }
    }

    public ArrayList<Team> getAllData(){
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, ID +" ASC", null);
        cursor.moveToFirst();
        ArrayList<Team> listTeam = new ArrayList<>();
        Team teamModel;
        if (cursor.getCount()>0){
            do{
                teamModel = new Team();
                teamModel.setIdTeam(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
                teamModel.setNameTeam(cursor.getString(cursor.getColumnIndexOrThrow(NAME)));
                listTeam.add(teamModel);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return listTeam;
    }


    public long insert(Team team){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, team.getIdTeam());
        contentValues.put(NAME, team.getNameTeam());
        return database.insert(TABLE_NAME, null, contentValues);
    }

    public int update(Team team){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, team.getIdTeam());
        contentValues.put(NAME, team.getNameTeam());
        return database.update(TABLE_NAME, contentValues, ID +"= '"+team.getIdTeam()+"'", null);
    }

    public int delete(String id){
        return database.delete(TABLE_NAME, ID+"= '"+id+"'", null);
    }



}
