package com.example.priori_t.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.converter.DateConverter;

import java.util.List;

@Entity
public class Task implements Comparable<Task> {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="todo")
    private String todo;


    @TypeConverters(DateConverter.class)
    @ColumnInfo(name="due_date")
    private Long dueDate;

    @ColumnInfo(name="min_to_complete")
    private int minToComplete;


    @ColumnInfo(name="is_complete")
    private boolean isComplete;

    @Ignore
    private List<Subtask> subtasks;

    public Task() {
    }

    @Ignore
    public Task(String todo, Long dueDate, int mtc) {
        this.todo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
    }
    @Ignore
    public Task(String todo, Long dueDate, int mtc, List<Subtask> subtasks) {
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }


    public Long getDueDate() {
        return this.dueDate;
    }

    public int getMinToComplete() {
        return this.minToComplete;
    }

    public List<Subtask> getSubtasks() { return this.subtasks; }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }

    public void setSubtasks(List<Subtask> subtasks) { this.subtasks = subtasks; }

    /*This is used to sort tasks by dueDate and organize by day of week*/
    @Override
    public int compareTo(Task o) {
        if (getDueDate() == null || o.getDueDate() == null) {
            return 0;
        } else {
            return getDueDate().compareTo(o.getDueDate());
        }
    }
}

