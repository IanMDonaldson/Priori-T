package com.example.priori_t.model.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priori_t.model.database.entity.SubTask;

@Dao
public interface SubTaskDao {
    @Query("SELECT * from subtasks")
    public LiveData<SubTask> getAllSubTasks();

    @Query("SELECT * FROM subtasks WHERE subTaskId == :id")
    public SubTask getSubTask(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addSubtask(SubTask subTask);

    @Delete
    public void deleteSubtask(SubTask subTask);

    @Update
    public void updateSubtask(SubTask subTask);
}
