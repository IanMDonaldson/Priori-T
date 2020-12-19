package com.example.priori_t.view.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    private MaterialCheckBox taskCompleteCheckBox;
    private ImageView ttcImageView;
    private ImageButton createSubtaskButton;
    private ImageButton editTaskButton;
    private ImageView taskDueImageView;
    private MaterialTextView taskDueTextView;
    private MaterialTextView ttcTextView;
    private MaterialTextView taskDescriptionTextView;


    public TaskViewHolder(@NonNull View v) {
        super(v);
        ttcTextView = v.findViewById(R.id.ttc_textview);
        taskCompleteCheckBox = v.findViewById(R.id.task_complete_checkbox);
        createSubtaskButton = v.findViewById(R.id.create_subtask_button);
        ttcImageView = v.findViewById(R.id.ttc_clock_imageview);
        taskDescriptionTextView = v.findViewById(R.id.task_description_textview);
        taskDueImageView = v.findViewById(R.id.task_due_date_imageview);
        editTaskButton = v.findViewById(R.id.edit_task_button);

    }
    public MaterialTextView getTaskDueTextView() {
        return taskDueTextView;
    }

    public void setTaskDueTextView(MaterialTextView taskDueTextView) {
        this.taskDueTextView = taskDueTextView;
    }

    public MaterialTextView getTtcTextView() {
        return ttcTextView;
    }

    public void setTtcTextView(MaterialTextView ttcTextView) {
        this.ttcTextView = ttcTextView;
    }

    public MaterialTextView getTaskDescriptionTextView() {
        return taskDescriptionTextView;
    }

    public void setTaskDescriptionTextView(MaterialTextView taskDescriptionTextView) {
        this.taskDescriptionTextView = taskDescriptionTextView;
    }
}
