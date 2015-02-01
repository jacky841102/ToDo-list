package com.example.jacky.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jacky on 2015/2/1.
 */
public class TaskDBHelper extends SQLiteOpenHelper{

    public TaskDBHelper(Context context){
        super(context, TaskContract.DB_NAME, null, TaskContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sqlQuery =
                String.format("CREATE TABLE %s ("+
                "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "%s TEXT)", TaskContract.TABLE, TaskContract.column.TASK);

        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2){
        db.execSQL("DROP TABLE IF EXIST "+TaskContract.TABLE);
        onCreate(db);
    }
}
