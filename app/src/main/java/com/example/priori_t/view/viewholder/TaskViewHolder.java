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
    private ImageView mtcImageView;
    private ImageButton createSubtaskButton;
    private ImageButton editTaskButton;
    private ImageView taskDueImageView;
    private MaterialTextView taskDueTextView;
    private MaterialTextView mtcTextView;
    private MaterialTextView taskDescriptionTextView;


    public TaskViewHolder(@NonNull View v) {
        super(v);
        this.mtcTextView = v.findViewById(R.id.ttc_textview);
        this.taskCompleteCheckBox = v.findViewById(R.id.task_complete_checkbox);
        this.mtcImageView = v.findViewById(R.id.ttc_clock_imageview);
        this.taskDescriptionTextView = v.findViewById(R.id.task_description_textview);
        this.taskDueImageView = v.findViewById(R.id.task_due_date_imageview);
        this.editTaskButton = v.findViewById(R.id.edit_task_button);
        this.taskDueTextView = v.findViewById(R.id.task_due_date_textview);
    }
    public MaterialTextView getTaskDueTextView() {
        return this.taskDueTextView;
    }

    public void setTaskDueTextView(MaterialTextView taskDueTextView) {
        this.taskDueTextView = taskDueTextView;
    }

    public MaterialTextView getMtcTextView() {
        return this.mtcTextView;
    }

    public void setMtcTextView(MaterialTextView mtcTextView) {
        this.mtcTextView = mtcTextView;
    }

    public MaterialTextView getTaskDescriptionTextView() {
        return this.taskDescriptionTextView;
    }

    public void setTaskDescriptionTextView(MaterialTextView taskDescriptionTextView) {
        this.taskDescriptionTextView = taskDescriptionTextView;
    }
}
