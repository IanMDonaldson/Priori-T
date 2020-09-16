package com.example.priori_t.model.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.priori_t.model.database.converter.DateConverter;
import com.example.priori_t.model.database.dao.SubTaskDao;
import com.example.priori_t.model.database.dao.TaskDao;
import com.example.priori_t.model.database.entity.Subtask;
import com.example.priori_t.model.database.entity.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version=1,entities={Task.class, Subtask.class}, exportSchema = false)
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

    private static TaskDB.Callback taskDBCallback = new TaskDB.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            databaseWriteExecutor.execute(() -> {
                TaskDao taskDao = taskDBInstance.getTaskDao();
                taskDao.nukeTable();

                Task task = new Task(1, "nothing", "202006051300", 30);
                taskDao.addTask(task);
                task = new Task(2, "nothing2", "202006061300", 30);
                taskDao.addTask(task);
            });
        }
    };
}
