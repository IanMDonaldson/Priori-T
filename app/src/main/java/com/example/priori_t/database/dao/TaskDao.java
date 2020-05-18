package com.example.priori_t.database.dao;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.priori_t.database.entity.TaskEntity;
import com.example.priori_t.model.TasksWithSubTasks;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface TaskDao {
    @Query("SELECT * from tasks")
    MutableLiveData<List<TaskEntity>> getAllTasks();

    @Transaction
    @Query("SELECT * FROM tasks")
    MutableLiveData<TasksWithSubTasks> getTasksAndSubTasks();

    @Query("SELECT * from tasks WHERE taskId = :taskId")
    MutableLiveData<TaskEntity> getTask(int taskId);

    @Insert(onConflict = IGNORE)
    public void addTask(TaskEntity taskEntity);

    @Query("DELETE FROM tasks where taskId = :id")
    public void deleteTask(int id);
}
