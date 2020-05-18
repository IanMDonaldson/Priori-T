package com.example.priori_t.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.priori_t.database.converter.DateConverter;
import com.example.priori_t.database.dao.SubTaskDao;
import com.example.priori_t.database.dao.TaskDao;
import com.example.priori_t.database.entity.SubTaskEntity;
import com.example.priori_t.database.entity.TaskEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version=1,entities={TaskEntity.class, SubTaskEntity.class}, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class TaskDB extends RoomDatabase {
    public static final String DATABASE_NAME="TaskDB";
    private static final int THREAD_COUNT = 2;

    public abstract TaskDao getTaskDao();
    public abstract SubTaskDao getSubTaskDao();

    private static volatile TaskDB taskDBInstance;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(THREAD_COUNT);

    static TaskDB getDatabase(final Context context) {
        if (taskDBInstance == null) {
            synchronized (TaskDB.class) {
                taskDBInstance = Room.databaseBuilder(context.getApplicationContext(),
                        TaskDB.class, DATABASE_NAME)
                        .build();
            }

        }
        return taskDBInstance;
    }
    public static void destroyInstance() {
        taskDBInstance = null;
    }
}
