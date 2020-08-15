package com.example.priori_t.model.database.dao;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.priori_t.model.database.entity.Task;
import com.example.priori_t.model.TasksWithSubTasks;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface TaskDao {
    @Transaction
    @Query("SELECT * from tasks")
    List<TasksWithSubTasks> getAllTasks();

    @Query("SELECT * from tasks WHERE taskId = :taskId")
    TasksWithSubTasks getTask(int taskId);

    @Insert(onConflict = IGNORE)
    void addTask(Task task);

    @Query("DELETE FROM tasks where taskId = :id")
    void deleteTask(int id);

    @Query("DELETE FROM tasks")
    void nukeTable();
}
