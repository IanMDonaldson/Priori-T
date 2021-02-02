package com.example.priori_t.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.priori_t.model.converter.DateConverter;
import com.example.priori_t.model.dao.TaskDao;
import com.example.priori_t.model.entity.Task;

@Database(version=1,entities={Task.class}, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class TaskDB extends RoomDatabase {
    abstract public TaskDao getTaskDao();

    private static TaskDB instance;

    public static TaskDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TaskDB.class, "taskDB").build();
        }
        return instance;
    }
    public static void destroyTaskDB() {
        instance = null;
    }
    /*//INSTANCE//
    private static volatile TaskDB taskDBInstance;

    //DAO//
    public abstract TaskDao taskDao();

    //DBNAME and THREADS
    public static final String DATABASE_NAME="TaskDB";
    private static final int THREAD_COUNT = 2;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(THREAD_COUNT);

    //CREATE THE DATABASE
    public static synchronized TaskDB getDatabase(final Context context) {
        if (taskDBInstance == null) {
            synchronized (TaskDB.class) {
                taskDBInstance = Room.databaseBuilder(context.getApplicationContext(),
                        TaskDB.class, DATABASE_NAME)
                        .addCallback(dbCallback).build();
            }

        }
        return taskDBInstance;
    }

    public static void destroyInstance() {
        taskDBInstance = null;
    }


    //CALLBACK for GENERATING DATA FOR TESTING//
    static RoomDatabase.Callback dbCallback = new RoomDatabase.Callback() {
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            databaseWriteExecutor.execute(() -> {

                TaskDao taskDao = taskDBInstance.taskDao();
                taskDao.deleteAll();


                Task task = new Task("nothing", Long.valueOf("202006051300"), 30);
                taskDao.addTask(task);
                task = new Task("nothing2", Long.valueOf("202006061300"), 30);
                taskDao.addTask(task);
                task = new Task("nothing3", Long.valueOf("20200607130"), 30);
                taskDao.addTask(task);
                task = new Task("nothing4", Long.valueOf("202006081300"), 30);
                taskDao.addTask(task);
            });
        }
    };

    // DAO GETTER
    public TaskDao getTaskDao() {
        return this.taskDao();
    }*/
}
