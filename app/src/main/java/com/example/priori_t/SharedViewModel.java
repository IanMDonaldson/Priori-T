package com.example.priori_t;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.priori_t.database.entity.TaskEntity;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<TaskEntity> taskMutableLiveData = new MutableLiveData<TaskEntity>();

    public void onSelect(TaskEntity taskEntity) {
        taskMutableLiveData.setValue(taskEntity);
    }
    public LiveData<TaskEntity> getSelected() {
        return taskMutableLiveData;
    }
}
