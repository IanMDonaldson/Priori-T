package com.example.priori_t.model.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.database.converter.DateConverter;

@Entity
public class Subtask {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subtask_id")
    private int subtaskID;

    @ColumnInfo(name = "task_id")
    private int taskID;

    @ColumnInfo(name = "subtask_todo")
    private String subtaskTodo;

    @ColumnInfo(name = "subtask_due_date")
    @TypeConverters(DateConverter.class)
    private String subtaskDueDate;

    @ColumnInfo(name = "min_to_complete")
    private int minToComplete;

    public Subtask() {
    }
    @Ignore
    public Subtask(int id, String todo, String dueDate, int mtc) {
        this.subtaskID = id;
        this.subTaskTodo = todo;
        this.subtaskDueDate = dueDate;
        this.minToComplete = mtc;
    }
//##################--- SETTERS ---########################
    public void setSubtaskID(int subtaskID) {
        this.subtaskID = subtaskID;
    }

    public void setTaskID(int taskID) { this.taskID = taskID; }

    public void setSubtaskTodo(String subtaskTodo) {
        this.subTaskTodo = subTaskTodo;
    }

    public void setSubtaskDueDate(String subtaskDueDate) {
        this.subtaskDueDate = subtaskDueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }
//###################---- GETTERS ---###################
    public int getSubtaskID() {
        return this.subtaskID;
    }

    public int getTaskID() { return this.taskID; }

    public String getSubtaskTodo() {
        return this.subTaskTodo;
    }

    public String getSubtaskDueDate() {
        return this.subtaskDueDate;
    }

    public int getMinToComplete() {
        return this.minToComplete;
    }
}
