package com.example.priori_t.model.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.database.converter.DateConverter;

@Entity(tableName = "tasks")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "taskId")
    private int taskId;

    @ColumnInfo(name = "taskTodo")
    private String taskTodo;

    @ColumnInfo(name = "dueDate")
    @TypeConverters(DateConverter.class)
    private String dueDate;

    @ColumnInfo(name = "minToComplete")
    private int minToComplete;

    public Task() {
    }
    @Ignore
    public Task(int id, String todo, String dueDate, int mtc) {
        this.taskId = id;
        this.taskTodo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
    }
    /*############### GETTERS ######################*/
    public int getTaskId() {
        return this.taskId;
    }

    public String getTaskTodo() {
        return this.taskTodo;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public int getMinToComplete() {
        return this.minToComplete;
    }
    /*###############3### SETTERS ####################*/
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskTodo(String taskTodo) {
        this.taskTodo = taskTodo;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }
}

