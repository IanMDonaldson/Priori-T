package com.example.priori_t.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.example.priori_t.model.converter.DateConverter;
import com.example.priori_t.model.converter.ListConverter;
import com.example.priori_t.model.entity.Subtask;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.view.viewholder.DayViewHolder;
import com.example.priori_t.view.viewholder.SubtaskViewHolder;
import com.example.priori_t.view.viewholder.TaskViewHolder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static com.example.priori_t.model.converter.DateConverter.fromTimeStamp;
import static com.example.priori_t.model.converter.ListConverter.convertDate;

public class TaskRecyclerAdapter extends RecyclerView.Adapter {
    private static final int DAY_VIEW = R.layout.day_ofweek;
    private static final int TASK_VIEW = R.layout.task;
    private static final int SUBTASK_VIEW = R.layout.subtask;
    private List<Task> taskList;
    private ArrayList<?> itemList;
    private LifecycleOwner lifecycleOwner;
    private Context context;
    private DayViewHolder dayViewHolder;
    private TaskViewHolder taskViewHolder;
    private SubtaskViewHolder subtaskViewHolder;
    private Task task;
    private Subtask subtask;
    private DateConverter dc = new DateConverter();
    private ListConverter listConverter;
                                                //todo: surround in livedata
    public TaskRecyclerAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.itemList = ListConverter.createItems(taskList);
        context.getApplicationContext();
    }
// returns the 3 different viewholders based on their position
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        //viewType corresponds to the layout ID, in which is returned from
        switch (viewType) {
            case DAY_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_ofweek, parent,false);
                return new DayViewHolder(view);
            case TASK_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent,false);
                return new TaskViewHolder(view);
            case SUBTASK_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask, parent,false);
                return new SubtaskViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case DAY_VIEW:
                DayOfWeek weekDay = (DayOfWeek) this.itemList.get(position);
                DayViewHolder dayViewHolder = (DayViewHolder) holder;
                dayViewHolder.setDayViewText(weekDay.toString().toUpperCase());
                break;
            case TASK_VIEW:
                Task task = (Task) this.itemList.get(position);
                TaskViewHolder taskViewHolder = (TaskViewHolder) holder;
                taskViewHolder.getMtcTextView().setText(String.valueOf(task.getMinToComplete()));
                taskViewHolder.getTaskDescriptionTextView().setText(task.getTodo());
                taskViewHolder.getTaskDueTextView().setText(convertDate(task.getDueDate()));
                break;
            case SUBTASK_VIEW:
                Subtask subtask = (Subtask) this.itemList.get(position);
                SubtaskViewHolder subtaskViewHolder = (SubtaskViewHolder) holder;
                subtaskViewHolder.getMtcTextView().setText(String.valueOf(subtask.getMinToComplete()));
                subtaskViewHolder.getSubtaskDescriptionTextView().setText(subtask.getSubtaskTodo());
                subtaskViewHolder.getSubtaskDescriptionTextView().setText(convertDate(subtask.getSubtaskDueDate()));
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (this.itemList.get(position) instanceof DayOfWeek) {
            return R.layout.day_ofweek;
        } else if (this.itemList.get(position) instanceof Task) {
            return R.layout.task;
        } else if (this.itemList.get(position) instanceof Subtask){
            return R.layout.subtask;
        } else {
            return -1;
        }
    }

    /* Adds a placeholder inside another list so that recyclerview can get the
    * correct position and inflate the day_ofweek.xml view each task is associated to*/
    /* todo need to make sure that there are no tasks whose due dates are from yesterday, if so add it to previous
    *   tasks list or something */



}
