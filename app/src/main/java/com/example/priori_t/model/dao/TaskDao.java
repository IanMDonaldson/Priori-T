package com.example.priori_t.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priori_t.model.entity.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * from task")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * from task WHERE id = :id")
    LiveData<Task> getTask(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTask(Task task);

    @Insert
    void addTasks(Task... tasks);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(Task task);

    @Query("DELETE FROM task")
    void deleteAll();

    @Query("DELETE FROM task where id = :id")
    void deleteTask(int id);

    @Delete
    void deleteTask(Task task);
}
