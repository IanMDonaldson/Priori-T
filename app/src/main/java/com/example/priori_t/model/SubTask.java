package com.example.priori_t.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.SET_NULL;

@Entity
public class SubTask {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="subtask_id")
    public int subtask_id;

    public int parent_task_id;

    public String todo;

    public int due;

    public int minToComplete;

    public SubTask() {
        this.todo = null;
        this.due = -1;
        this.minToComplete = -1;
    }
    public SubTask(String todo, int due, int mtc) {
        this.todo = todo;
        this.due = due;
        this.minToComplete = mtc;
    }

}
