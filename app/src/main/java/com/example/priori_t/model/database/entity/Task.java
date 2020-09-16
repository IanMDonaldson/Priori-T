package com.example.priori_t.model.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.database.converter.DateConverter;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    private int taskID;

    @ColumnInfo(name = "task_todo")
    private String taskTodo;

    @ColumnInfo(name = "due_date")
    @TypeConverters(DateConverter.class)
    private String dueDate;

    @ColumnInfo(name = "min_to_complete")
    private int minToComplete;

    public Task() {
    }
    @Ignore
    public Task(int id, String todo, String dueDate, int mtc) {
        this.taskID = id;
        this.taskTodo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
    }
    /*############### GETTERS ######################*/
    public int getTaskID() {
        return this.taskID;
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
    public void setTaskID(int taskID) {
        this.taskID = taskID;
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

