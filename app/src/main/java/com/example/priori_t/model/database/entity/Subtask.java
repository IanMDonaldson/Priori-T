package com.example.priori_t.model.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.database.converter.DateConverter;

import static androidx.room.ForeignKey.CASCADE;

@Entity
public class Subtask {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="subtask_id")
    private int subtaskID;

    @ForeignKey(
            entity = Task.class,
            parentColumns = "taskID",
            childColumns = "taskID",
            onDelete = CASCADE,
            onUpdate = CASCADE
    )
    @ColumnInfo(name="task_id")
    private int taskID;

    @ColumnInfo(name="subtask_todo")
    private String subtaskTodo;

    @TypeConverters(DateConverter.class)
    @ColumnInfo(name="subtask_due_date")
    private long subtaskDueDate;

    @ColumnInfo(name="subtask_mtc")
    private int minToComplete;

    public Subtask() {
    }
    @Ignore
    public Subtask(String todo, long dueDate, int mtc) {
        this.subtaskTodo = todo;
        this.subtaskDueDate = dueDate;
        this.minToComplete = mtc;
    }
//##################--- SETTERS ---########################
    public void setSubtaskID(int subtaskID) {
        this.subtaskID = subtaskID;
    }

    public void setTaskID(int taskID) { this.taskID = taskID; }

    public void setSubtaskTodo(String subtaskTodo) {
        this.subtaskTodo = subtaskTodo;
    }

    public void setSubtaskDueDate(long subtaskDueDate) {
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
        return this.subtaskTodo;
    }

    public long getSubtaskDueDate() {
        return this.subtaskDueDate;
    }

    public int getMinToComplete() {
        return this.minToComplete;
    }
}
