package com.example.priori_t.view;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.example.priori_t.model.converter.DateConverter;
import com.example.priori_t.model.entity.Subtask;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.view.viewholder.DayViewHolder;
import com.example.priori_t.view.viewholder.SubtaskViewHolder;
import com.example.priori_t.view.viewholder.TaskViewHolder;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

import java.time.DayOfWeek;
import java.util.List;

public class TaskRecyclerAdapter extends RecyclerView.Adapter {
    private static final int DAY_VIEW = 0;
    private static final int TASK_VIEW = 1;
    private static final int SUBTASK_VIEW = 2;
    private LiveData<List<Task>> taskList;
    private LifecycleOwner lifecycleOwner;
    private Context context;
    private DayViewHolder dayViewHolder;
    private TaskViewHolder taskViewHolder;
    private SubtaskViewHolder subtaskViewHolder;
    private Task task;
    private Subtask subtask;
    private DateConverter dc = new DateConverter();
    public TaskRecyclerAdapter(Context context, LiveData<List<Task>> taskList) {
        this.taskList = taskList;
        this.context = context;
        context.getApplicationContext();
    }
// returns the 3 different viewholders based on their position
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case DAY_VIEW:
                view = LayoutInflater.from(context).inflate(R.layout.day_ofweek, parent);
                return new DayViewHolder(view);
            case TASK_VIEW:
                view = LayoutInflater.from(context).inflate(R.layout.task, parent);
                return new TaskViewHolder(view);
            case SUBTASK_VIEW:
                view = LayoutInflater.from(context).inflate(R.layout.task, parent);
                return new SubtaskViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return this.taskList.getValue().size();
    }
    @Override
    public int getItemViewType(int position) {
        DayOfWeek dayOfWeek = dc.fromTimeStamp(taskList.getValue().get(position).getDueDate()).getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SUNDAY) {}


        return 0;
    }

}
