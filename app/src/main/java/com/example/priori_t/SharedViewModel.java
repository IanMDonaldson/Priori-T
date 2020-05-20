package com.example.priori_t;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.priori_t.model.database.entity.Task;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Task> taskMutableLiveData = new MutableLiveData<Task>();

    public void onSelect(Task task) {
        taskMutableLiveData.setValue(task);
    }
    public LiveData<Task> getSelected() {
        return taskMutableLiveData;
    }
}
