package com.example.priori_t;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.priori_t.model.TaskDB;
import com.example.priori_t.model.TaskGenerator;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.model.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskDB taskDB;
    @NonNull
    private LiveData<List<Task>> taskList;
    private LiveData<Task> task;
    private TaskGenerator taskGenerator = new TaskGenerator();
    //constructor
    public TaskViewModel(@NonNull Application application) {
        super(application);
        this.taskDB = TaskDB.getInstance(getApplication());
        this.taskList = taskDB.getTaskDao().getAllTasks();
    }
    //database initialization
    public void initTaskDB() {
        taskDB = TaskDB.getInstance(getApplication());
        taskList = taskDB.getTaskDao().getAllTasks();
    }

    //task generation and insertion
    public void fillTaskDB(List<Task> taskList) {
        new AsyncTask<List<Task>, Void, Void>() {
            @Override
            protected Void doInBackground(List<Task>... lists) {
                taskDB.getTaskDao().deleteAll();
                taskDB.getTaskDao().addTasks(lists[0].toArray(new Task[lists[0].size()]));
                return null;
            }
        }.execute(taskList);
    }

    //task Deletion

    public void deleteTask(Task task) {
        new AsyncTask<Task, Void, Void>() {
            @Override
            protected Void doInBackground(Task... tasks) {
                taskDB.getTaskDao().deleteTask(tasks[0]);
                return null;
            }
        }.execute(task);
    }

    //update Task using individual values
    public void updateTask(int id, String todo, Long dueDate, int minToComplete, boolean isComplete, int index) {
        Task task = taskList.getValue().get(index);
        task.setId(id);
        task.setTodo(todo);
        task.setDueDate(dueDate);
        task.setMinToComplete(minToComplete);
        task.setComplete(isComplete);
        new AsyncTask<Task, Void, Void>() {
            @Override
            protected Void doInBackground(Task... tasks) {
                taskDB.getTaskDao().updateTask(tasks[0]);
                return null;
            }
        }.execute(task);
    }
    public void addTask(Task task) {
        new AsyncTask<Task, Void, Void>() {
            @Override
            protected Void doInBackground(Task... tasks) {
                taskDB.getTaskDao().addTask(tasks[0]);
                return null;
            }
        }.execute(task);
    }

    //get Task
    public LiveData<List<Task>> getTaskList() {
        return this.taskList;
    }
}
