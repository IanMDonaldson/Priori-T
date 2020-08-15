package com.example.priori_t.model.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priori_t.model.database.entity.SubTask;

import java.util.List;

@Dao
public interface SubTaskDao {
    @Query("SELECT * from subtasks")
    List<SubTask> getAllSubTasks();

    @Query("SELECT * FROM subtasks WHERE subTaskId == :id")
    SubTask getSubTask(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addSubTask(SubTask subTask);

    @Delete
    void deleteSubTask(SubTask subTask);

    @Update
    void updateSubTask(SubTask subTask);
}
