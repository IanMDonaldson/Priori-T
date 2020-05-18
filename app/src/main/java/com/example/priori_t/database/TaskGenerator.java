package com.example.priori_t.database;

import android.util.Log;

import com.example.priori_t.database.entity.TaskEntity;

import java.util.List;
import java.util.Random;

public class TaskGenerator {
    private static Random r = new Random();

    public static int randInt(int max) {
        int min = 0;
        return r.nextInt((max-min) + 1) + min;
    }
    public static List<TaskEntity> getTaskDataSet(int listSize) {
        String todo;
        String due;
        int mtc;
        List<TaskEntity> taskEntityList = null;

        for (int i = 0; i < listSize; i++) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskMinToComplete(randInt(120));
            taskEntity.setTaskDueDate("202006" + Integer.toString(randInt(30)) + "1300");
            taskEntity.setTaskTodo(Integer.toString(randInt(1000000000)));
            taskEntityList.add(taskEntity);
            Log.d("task created", "with task.mtc = "+Integer.toString(taskEntity.getTaskMinToComplete()));
        }

        return taskEntityList;
    }
}
