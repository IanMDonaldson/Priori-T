package com.example.priori_t.model.converter;

import com.example.priori_t.model.entity.Subtask;
import com.example.priori_t.model.entity.Task;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import com.example.priori_t.model.converter.DateConverter;

import static com.example.priori_t.model.converter.DateConverter.fromTimeStamp;

public interface ListConverter {
     DateConverter dc = new DateConverter();
    public static ArrayList<?> createItems(List<Task> taskList){
        ArrayList<Object> items = new ArrayList<>();
        DayOfWeek taskWeekDay = DayOfWeek.of(getWeekDay(taskList.get(0)));
        DayOfWeek today = ZonedDateTime.now(TimeZone.getDefault().toZoneId()).getDayOfWeek();
        DayOfWeek nextDay = today.plus(1);
        for (int i = 0; i < taskList.size(); i++) {
            Task currTask = taskList.get(i);

            if (i == taskList.size()-1) {
                if ( (getWeekDay(taskList.get(i))) != (getWeekDay(taskList.get(i-1))) ) {
                    items.add( DayOfWeek.of(getWeekDay(taskList.get(i))) );
                    createItemsHelper(currTask, items);
                } else {
                    createItemsHelper(currTask, items);
                }
            } else if ( (getWeekDay(taskList.get(i+1)) != getWeekDay(currTask) ) ||
                    (getWeekDay(taskList.get(i+1)) < getWeekDay(currTask) )) {
                items.add( DayOfWeek.of(getWeekDay(currTask) ));
                createItemsHelper(currTask, items);
            } else {
                createItemsHelper(currTask, items);
            }
        }
        return items;
    }

    static void createItemsHelper(Task task, ArrayList<Object> items) {
        List<Subtask> subtasks = task.getSubtasks();
        items.add(task);
        if (subtasks != null) {
            for (Subtask subtask: subtasks) {
                items.add(subtask);
            }
        }
    }

     static int getWeekDay(Task task) {
        return fromTimeStamp(task.getDueDate()).getDayOfWeek().getValue();
    }

     static String convertDate(Long dueDate) {
        ZonedDateTime date = dc.fromTimeStamp(dueDate);
        DateTimeFormatterBuilder dateTimeFormatter = new DateTimeFormatterBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a Z");
        String formattedString = date.format(formatter);

        return formattedString.substring(0, (formattedString.length()-6) );
    }
}
