package com.example.priori_t.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.priori_t.database.entity.SubTaskEntity;
import com.example.priori_t.database.entity.TaskEntity;

import java.util.List;

public class TasksWithSubTasks {
    @Embedded public TaskEntity taskEntity;
    @Relation(
            parentColumn = "task_id",
            entityColumn = "parent_task_id")
    public List<SubTaskEntity> subTaskEntities;
}
