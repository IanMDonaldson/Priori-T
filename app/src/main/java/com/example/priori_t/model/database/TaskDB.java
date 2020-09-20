package com.example.priori_t.model.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.priori_t.model.database.converter.DateConverter;
import com.example.priori_t.model.database.dao.SubtaskDao;
import com.example.priori_t.model.database.dao.TaskDao;
import com.example.priori_t.model.database.entity.Subtask;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version=1,entities={Task.class, Subtask.class}, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class TaskDB extends RoomDatabase {
    //INSTANCE//
    private static volatile TaskDB taskDBInstance;

    //DAO//
    public abstract TaskDao taskDao();
    public abstract SubtaskDao subtaskDao();

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
                taskDao.deleteTasks();
                List<Subtask> subtasks = null;
//                subtasks.add(new Subtask("subnoth 1", "202005051200", 20));
//                subtasks.add(new Subtask("subnoth 2", "202005051201", 20));
//                subtasks.add(new Subtask("subnoth 3", "202005051202", 20));
//
//                Task task = new Task("nothing", "202006051300", 30, null);
//                TaskSubtasks taskSubtask = new TaskSubtasks();
//                taskSubtask.setTask(task);
//                taskSubtask.setSubtasks(subtasks);
//                taskDao.addTask(taskSubtask);
//                task = new Task("nothing2", "202006061300", 30, null);
//                taskSubtask.setTask(task);
//                taskSubtask.setSubtasks(subtasks);
//                taskDao.addTask(taskSubtask);
//                task = new Task("nothing3", "202006071300", 30, null);
//                taskSubtask.setTask(task);
//                taskSubtask.setSubtasks(subtasks);
//                taskDao.addTask(taskSubtask);
//                task = new Task("nothing4", "202006081300", 30, null);
//                taskSubtask.setTask(task);
//                taskSubtask.setSubtasks(subtasks);
//                taskDao.addTask(taskSubtask);
            });
        }
    };

    // DAO GETTER
    public TaskDao getTaskDao() {
        return this.taskDao();
    }
    public SubtaskDao getSubtaskDao() { return this.subtaskDao(); }
}
