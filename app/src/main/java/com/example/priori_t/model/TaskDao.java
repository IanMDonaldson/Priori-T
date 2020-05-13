package com.example.priori_t.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface TaskDao {
    @Query("SELECT * from TASK")
    public List<Task> getAllTasks();

    @Transaction
    @Query("SELECT * FROM TASK")
    public List<TasksWithSubTasks> getTasksAndSubTasks();

    @Query("SELECT * from TASK WHERE task_id = :taskId")
    public Task getTaskById(int taskId);

    @Insert(onConflict = IGNORE)
    public void addTask(Task task);

    @Insert
    public void addTaskAndSubtasks(Task task, List<SubTask> subTasks);

    @Insert
    public void addSubTasksToTask(Task task, List<SubTask> subTasks);

    @Delete
    public void deleteTask(Task task);

    @Update
    public void updateTask(Task task);
}
