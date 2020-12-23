package com.example.priori_t.model;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.priori_t.model.dao.SubtaskDao;
import com.example.priori_t.model.dao.TaskDao;
import com.example.priori_t.model.entity.Subtask;
import com.example.priori_t.model.entity.Task;

import java.util.List;

public class TaskRepository {
    private static TaskRepository instance;
    private TaskDB_Impl db;
    private TaskDao taskDao;
    private SubtaskDao subtaskDao;
    private MediatorLiveData<List<Task>> tasks;
    public TaskRepository() {

    }


    public static TaskRepository getInstance() {
        if (instance == null) {
            synchronized (TaskRepository.class) {
                if (instance == null) {
                    instance = new TaskRepository();
                }
            }
        }
        return instance;
    }
    //helper function to make constructor cleaner
    private LiveData<List<Task>> packSubtasksIntoTasks(LiveData<List<Task>> tasks,
                                                       LiveData<List<Subtask>> subtasks,
                                                       TaskDB taskDB) {
        tasks = taskDB.getTaskDao().getAllTasks();
        return tasks;
        
    }
    public LiveData<List<Task>> getAllTasksAndSubtasks() {
        LiveData<List<Task>> taskList = this.db.getTaskDao().getAllTasks();
        taskList.getValue().forEach(task -> {
            task.setSubtasks(db.getSubtaskDao().getSubtasksForTask(task.getId()));
        });
        return taskList;
    }


    public void insert(Task task) {
        TaskDB.databaseWriteExecutor.execute(() -> {
            taskDao.addTask(task);
            task.getSubtasks().forEach(subtask -> {
                subtaskDao.insertSubtask(subtask);
            });
        });
    }
}
