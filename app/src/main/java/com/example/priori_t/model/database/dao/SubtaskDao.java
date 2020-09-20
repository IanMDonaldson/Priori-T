package com.example.priori_t.model.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priori_t.model.database.entity.Subtask;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SubtaskDao {
    @Query("SELECT * FROM subtask WHERE task_id = :taskID")
    List<Subtask> getSubtasksForTask(int taskID);

    @Query("SELECT * FROM subtask WHERE subtask_id = :subtaskID")
    LiveData<Subtask> getSubtask(int subtaskID);

    @Query("INSERT INTO subtask(task_id,subtask_id,subtask_todo,subtask_due_date,subtask_mtc) " +
            "VALUES(:taskID,:subtaskID,:subtaskTodo,:subtaskDueDate,:mtc)")
    Long insertSubtask(int taskID, int subtaskID, String subtaskTodo,Long subtaskDueDate, int mtc);

    @Insert(onConflict = REPLACE)
    Long insertSubtask(Subtask subtask);

    @Update
    Long updateSubtask(Subtask subtask);

    @Delete
    Long deleteSubtask(Subtask subtask);
}
