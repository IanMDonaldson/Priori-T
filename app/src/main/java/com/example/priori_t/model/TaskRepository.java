package com.example.priori_t.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.room.Dao;

import com.example.priori_t.model.dao.TaskDao;
import com.example.priori_t.model.entity.Task;

import java.util.List;

public class TaskRepository {
    private static TaskRepository instance;
    private TaskDB db;
    private TaskDao taskDao;
    private MediatorLiveData<List<Task>> tasks;
    public TaskRepository(TaskDB database) {
        this.db = database;
    }


    public static TaskRepository getInstance(TaskDB database) {
        if (instance == null) {
            synchronized (TaskRepository.class) {
                if (instance == null) {
                    instance = new TaskRepository(database);
                }
            }
        }
        return instance;
    }
    //helper function to make constructor cleaner
    private LiveData<List<Task>> packSubtasksIntoTasks(LiveData<List<Task>> tasks,
                                                       TaskDB taskDB) {
        tasks = taskDB.getTaskDao().getAllTasks();
        return tasks;
        
    }
    public LiveData<List<Task>> getAllTasks() {
        LiveData<List<Task>> taskList = this.db.getTaskDao().getAllTasks();
        return taskList;
    }


    //public void insert(Task task) {
    //    TaskDB.databaseWriteExecutor.execute(() -> {
    //        taskDao.addTask(task);
    //    });
    //}
}
