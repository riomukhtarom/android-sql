package com.rio.sqliteexample;

public class DatabaseContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbTeam";
    public static final String TABLE_NAME = "favoriteTeam";

    public static final class TeamColumn {
        public static final String ID = "id";
        public static final String NAME = "title";
    }

}
