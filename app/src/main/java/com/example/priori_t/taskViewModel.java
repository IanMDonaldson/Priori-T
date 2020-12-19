package com.example.priori_t;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.priori_t.model.entity.Task;
import com.example.priori_t.model.TaskRepository;

import java.util.List;

public class taskViewModel extends ViewModel {
    @NonNull
    private LiveData<List<Task>> taskList;
    private TaskRepository taskRepo = TaskRepository.getInstance();

    public taskViewModel() {
        super();
        setTasks(this.taskRepo);

    }

    public void setTasks(TaskRepository taskRepo) {
        this.taskList = taskRepo.getAllTasksAndSubtasks();
    }
    public LiveData<List<Task>> getTasks(List<Task> tasks) {
        return this.taskList;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
