package com.example.priori_t.model;

import com.example.priori_t.model.converter.DateConverter;
import com.example.priori_t.model.entity.Subtask;
import com.example.priori_t.model.entity.Task;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class TaskGenerator {
    public List<Task> taskGenerator(int taskListSize, int subtaskListSize) {
        List<Task> taskEntities = new LinkedList<Task>();
        ZonedDateTime today = ZonedDateTime.now(TimeZone.getDefault().toZoneId());
        for (int i = 0; i < taskListSize; i++) {
            Task task = new Task();
            task.setMinToComplete(30);
            task.setTaskID(i);
            task.setTaskTodo("nothing"+i);
            today.plusDays((long)i);
            task.setDueDate(DateConverter.fromZonedDateTime(today));
            List<Subtask> subtasks = new LinkedList<>();
            for (int j = 0; j < subtaskListSize; j++) {
                Subtask subtask = new Subtask();
                subtask.setMinToComplete(30);
                subtask.setSubtaskID(i);
                subtask.setSubtaskTodo("nothing"+i);
                subtask.setSubtaskDueDate(DateConverter.fromZonedDateTime(today));
                subtasks.add(subtask);
            }
            task.setSubtasks(subtasks);
            taskEntities.add(task);
        }
        return taskEntities;
    }
}
