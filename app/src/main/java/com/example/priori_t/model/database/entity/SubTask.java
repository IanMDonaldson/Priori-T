package com.example.priori_t.model.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.database.converter.DateConverter;

@Entity(tableName = "subtasks")
public class SubTask {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subTaskId")
    private int subTaskId;

    @ColumnInfo(name = "parentTaskId")
    private int parentTaskId;

    @ColumnInfo(name = "subTaskTodo")
    private String subTaskTodo;

    @ColumnInfo(name = "subTaskDueDate")
    @TypeConverters(DateConverter.class)
    private String subTaskDueDate;

    @ColumnInfo(name = "minToComplete")
    private int minToComplete;

    public SubTask() {
    }
    @Ignore
    public SubTask(int id, String todo, String dueDate, int mtc) {
        this.subTaskId = id;
        this.subTaskTodo = todo;
        this.subTaskDueDate = dueDate;
        this.minToComplete = mtc;
    }
//##################--- SETTERS ---########################
    public void setSubTaskId(int subTaskId) {
        this.subTaskId = subTaskId;
    }

    public void setParentTaskId(int parentTaskId) { this.parentTaskId = parentTaskId; }

    public void setSubTaskTodo(String subTaskTodo) {
        this.subTaskTodo = subTaskTodo;
    }

    public void setSubTaskDueDate(String subTaskDueDate) {
        this.subTaskDueDate = subTaskDueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }
//###################---- GETTERS ---###################
    public int getSubTaskId() {
        return this.subTaskId;
    }

    public int getParentTaskId() { return this.parentTaskId; }

    public String getSubTaskTodo() {
        return this.subTaskTodo;
    }

    public String getSubTaskDueDate() {
        return this.subTaskDueDate;
    }

    public int getMinToComplete() {
        return this.minToComplete;
    }
}
