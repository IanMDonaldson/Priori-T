package com.example.priori_t.model.database;

import android.app.Application;

import com.example.priori_t.model.TasksWithSubtasks;
import com.example.priori_t.model.database.dao.TaskDao;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;

public class TaskRepository {
    private TaskDao taskDao;
    private List<TasksWithSubtasks> allTasks;
    TaskRepository(Application app) {
        TaskDB db = TaskDB.getDatabase(app);
        taskDao = db.getTaskDao();
        allTasks = taskDao.getAllTasks();
    }

    List<TasksWithSubtasks> getAllTasks() {
        return allTasks;
    }

    void insert(Task task) {
        TaskDB.databaseWriteExecutor.execute(() -> {

        });
    }
}
