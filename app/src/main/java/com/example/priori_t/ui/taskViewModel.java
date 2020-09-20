package com.example.priori_t.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.priori_t.model.database.TaskRepository;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;

public class taskViewModel extends ViewModel {
    private LiveData<List<Task>> taskList;
    private TaskRepository taskRepository;

}
