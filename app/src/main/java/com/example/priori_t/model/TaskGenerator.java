package com.example.priori_t.model;

import com.example.priori_t.model.converter.DateConverter;
import com.example.priori_t.model.entity.Task;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class TaskGenerator {
    public TaskGenerator() {

    }
    public List<Task> taskGenerator(int taskListSize, int ListSize) {
        List<Task> taskEntities = new ArrayList<Task>();
        ZonedDateTime today = ZonedDateTime.now(TimeZone.getDefault().toZoneId());
        for (int i = 0; i < taskListSize; i++) {
            Task task = new Task();
            task.setMinToComplete(30);
            task.setId(i);
            task.setTodo("nothing"+i);
            today = today.plusDays(1);
            task.setDueDate(DateConverter.fromZonedDateTime(today));
            System.out.println(today.getDayOfWeek());
            taskEntities.add(task);
        }
        return taskEntities;
    }
}
