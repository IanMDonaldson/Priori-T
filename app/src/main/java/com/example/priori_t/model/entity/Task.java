package com.example.priori_t.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.priori_t.model.converter.DateConverter;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class Task implements Comparable<Task>, Serializable {
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


    public Task() {
    }

    @Ignore
    public Task(String todo, Long dueDate, int mtc) {
        this.todo = todo;
        this.dueDate = dueDate;
        this.minToComplete = mtc;
        this.isComplete = false;
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


    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public void setMinToComplete(int minToComplete) {
        this.minToComplete = minToComplete;
    }


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

