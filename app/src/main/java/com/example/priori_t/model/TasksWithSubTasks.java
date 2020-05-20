package com.example.priori_t.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.priori_t.model.database.entity.SubTask;
import com.example.priori_t.model.database.entity.Task;

import java.util.List;

public class TasksWithSubTasks {
    @Embedded public Task task;
    @Relation(
            parentColumn = "taskId",
            entityColumn = "parentTaskId",
            entity = SubTask.class)
    public List<SubTask> subTasks;
}
