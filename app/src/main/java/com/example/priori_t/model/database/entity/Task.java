package com.example.priori_t.model.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.database.converter.DateConverter;

import java.util.List;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="todo")
    private String todo;


    @TypeConverters(DateConverter.class)
    @ColumnInfo(name="due_date")
    private long dueDate;

    @ColumnInfo(name="min_to_complete")
    private int minToComplete;

    @Ignore
    private List<Subtask> subtasks;

    public Task() {
    }

    @Ignore
    public Task(String todo, long dueDate, int mtc) {
        this.todo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
    }
    @Ignore
    public Task(String todo, long dueDate, int mtc, List<Subtask> subtasks) {
        this.todo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
        this.subtasks = subtasks;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id= " + id + '\n' +
                ", dueDate= " + dueDate + '\n' +
                ", timeToComplete= " + minToComplete + '\n' +
                ", subtaskCount = " + subtasks.size();
    }
    /*############### GETTERS ######################*/

    public int getTaskID() {
        return this.id;
    }

    public String getTaskTodo() {
        return this.todo;
    }

    public long getDueDate() {
        return this.dueDate;
    }

    public int getMinToComplete() {
        return this.minToComplete;
    }

    public List<Subtask> getSubtasks() { return this.subtasks; }
    /*###############3### SETTERS ####################*/
    public void setTaskID(int taskID) {
        this.id = taskID;
    }

    public void setTaskTodo(String taskTodo) {
        this.todo = taskTodo;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }

    public void setSubtasks(List<Subtask> subtasks) { this.subtasks = subtasks; }
}

