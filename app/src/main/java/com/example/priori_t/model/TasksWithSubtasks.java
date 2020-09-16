package com.example.priori_t.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.priori_t.model.database.entity.Subtask;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;

public class TasksWithSubtasks {
    @Embedded public Task task;
    @Relation(
            parentColumn = "task_id",
            entityColumn = "task_id",
            entity = Subtask.class)
    public List<Subtask> subtasks;
}
