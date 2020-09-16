package com.example.priori_t.model.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priori_t.model.database.entity.Subtask;

import java.util.List;

@Dao
public interface SubTaskDao {
    @Query("SELECT * from Subtask")
    List<Subtask> getAllSubtasks();

    @Query("SELECT * FROM subtasks WHERE subtask_id == :id")
    Subtask getSubtask(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addSubtask(Subtask subTask);

    @Delete
    void deleteSubTask(Subtask subTask);

    @Update
    void updateSubTask(Subtask subTask);
}
