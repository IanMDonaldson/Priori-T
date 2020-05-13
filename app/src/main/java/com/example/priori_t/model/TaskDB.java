package com.example.priori_t.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(version=1,entities={Task.class,SubTask.class})
public abstract class TaskDB extends RoomDatabase {
    public static final String DATABASE_NAME="TaskDB";

    public abstract TaskDao getTaskDao();
    public abstract SubTaskDao getSubTaskDao();

    private static TaskDB taskDBInstance;
    public static TaskDB getInstance(Context context) {
        if (taskDBInstance == null) {
            taskDBInstance = Room.databaseBuilder(context,TaskDB.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration().build();
        }
        return taskDBInstance;
    }
    public static void destroyInstance() {
        taskDBInstance = null;
    }
}
