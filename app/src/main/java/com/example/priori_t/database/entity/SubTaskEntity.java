package com.example.priori_t.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.database.converter.DateConverter;
import com.example.priori_t.model.SubTask;

import java.util.Date;

@Entity(tableName = "subtasks")
public class SubTaskEntity implements SubTask {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subTaskId")
    private int subTaskId;

    @ColumnInfo(name = "subTaskTodo")
    private String subTaskTodo;

    @ColumnInfo(name = "subTaskDueDate")
    @TypeConverters(DateConverter.class)
    private String subTaskDueDate;

    @ColumnInfo(name = "minToComplete")
    private int minToComplete;

    public SubTaskEntity() {
    }
    @Ignore
    public SubTaskEntity(int id, String todo, String dueDate, int mtc) {
        this.subTaskId = id;
        this.subTaskTodo = todo;
        this.subTaskDueDate = dueDate;
        this.minToComplete = mtc;
    }

    public void setSubTaskId(int subTaskId) {
        this.subTaskId = subTaskId;
    }

    public void setSubTaskTodo(String subTaskTodo) {
        this.subTaskTodo = subTaskTodo;
    }

    public void setSubTaskDueDate(String subTaskDueDate) {
        this.subTaskDueDate = subTaskDueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }

    @Override
    public int getSubTaskId() {
        return this.subTaskId;
    }

    @Override
    public String getSubTaskTodo() {
        return this.subTaskTodo;
    }

    @Override
    public String getSubTaskDueDate() {
        return this.subTaskDueDate;
    }

    @Override
    public int getMinToComplete() {
        return this.minToComplete;
    }
}
