package com.example.priori_t.model.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.priori_t.model.database.dao.SubtaskDao;
import com.example.priori_t.model.database.dao.TaskDao;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;

public class TaskRepository {
    private TaskDao taskDao;
    private SubtaskDao subtaskDao;
    private LiveData<List<Task>> tasks;
    public TaskRepository(Application app) {
        TaskDB db = TaskDB.getDatabase(app);
        this.tasks = getAllTasksAndSubtasks(db);
    }

    public LiveData<List<Task>> getAllTasksAndSubtasks(TaskDB db) {
        LiveData<List<Task>> taskList = db.getTaskDao().getAllTasks();
        taskList.getValue().forEach(task -> {
            task.setSubtasks(db.getSubtaskDao().getSubtasksForTask(task.getTaskID()));
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
