package com.example.priori_t.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Task {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="task_id")
    private int task_id;

    public String todo;

    public int due;

    public int minToComplete;

    public Task() {
        this.todo = null;
        this.due = -1;
        this.minToComplete = -1;
    }
    public Task(String todo, int due, int mtc) {
        this.todo = todo;
        this.due = due;
        this.minToComplete = mtc;
    }

}
