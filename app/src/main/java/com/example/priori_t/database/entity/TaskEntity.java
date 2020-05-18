package com.example.priori_t.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.database.converter.DateConverter;
import com.example.priori_t.model.Task;

@Entity(tableName = "tasks")
public class TaskEntity implements Task {
    @NonNull
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

    public TaskEntity() {
    }
    @Ignore
    public TaskEntity(int id, String todo, String dueDate, int mtc) {
        this.taskId = id;
        this.taskTodo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
    }
    /*############### GETTERS ######################*/
    @Override
    public int getTaskId() {
        return this.taskId;
    }

    @Override
    public String getTaskTodo() {
        return this.taskTodo;
    }

    @Override
    public String getDueDate() {
        return this.dueDate;
    }

    @Override
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

