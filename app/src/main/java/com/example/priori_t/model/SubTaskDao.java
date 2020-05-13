package com.example.priori_t.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SubTaskDao {
    @Query("SELECT * from subtask ")
    public List<SubTask> getAllSubTasks(int task_id);

    @Query("SELECT * FROM SUBTASK WHERE subtask_id == :id")
    public SubTask getSubTask(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addSubtask(SubTask subTask);

    @Delete
    public void deleteSubtask(SubTask subTask);

    @Update
    public void updateSubtask(SubTask subTask);
}
