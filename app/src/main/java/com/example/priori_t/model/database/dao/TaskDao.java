package com.example.priori_t.model.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.priori_t.model.TasksWithSubtasks;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface TaskDao {
    @Transaction
    @Query("SELECT * from task")
    List<TasksWithSubtasks> getAllTasks();

    @Query("SELECT * from task WHERE task_id = :taskID")
    TasksWithSubtasks getTask(int taskID);

    @Insert(onConflict = IGNORE)
    void addTask(Task task);

    @Query("DELETE FROM task where task_id = :id")
    void deleteTask(int id);

    @Query("DELETE FROM task")
    void nukeTable();
}
