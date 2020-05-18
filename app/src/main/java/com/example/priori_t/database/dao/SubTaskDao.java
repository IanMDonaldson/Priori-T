package com.example.priori_t.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priori_t.database.entity.SubTaskEntity;

@Dao
public interface SubTaskDao {
    @Query("SELECT * from subtasks ")
    public LiveData<SubTaskEntity> getAllSubTasks();

    @Query("SELECT * FROM subtasks WHERE subTaskId == :id")
    public SubTaskEntity getSubTask(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addSubtask(SubTaskEntity subTaskEntity);

    @Delete
    public void deleteSubtask(SubTaskEntity subTaskEntity);

    @Update
    public void updateSubtask(SubTaskEntity subTaskEntity);
}
