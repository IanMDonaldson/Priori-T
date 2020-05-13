package com.example.priori_t.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Relation;
import androidx.room.Transaction;

import java.util.List;

import static androidx.room.ForeignKey.CASCADE;

public class TasksWithSubTasks {
    @Embedded public Task task;
    @Relation(
            parentColumn = "task_id",
            entityColumn = "parent_task_id")
    public List<SubTask> subTasks;
}
