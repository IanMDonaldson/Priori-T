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
    /*############### GETTERS ######################*/

    public int getTaskID() {
        return this.id;
    }

    public String getTaskTodo() {
        return this.todo;
    }

    public Long getDueDate() {
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

