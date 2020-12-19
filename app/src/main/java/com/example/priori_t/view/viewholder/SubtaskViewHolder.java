package com.example.priori_t.view.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

public class SubtaskViewHolder extends RecyclerView.ViewHolder {
    private MaterialCheckBox checkBox;
    private ImageView ttcClockImageView;
    private ImageView dueImageView;
    private MaterialTextView ttcTxtView;
    private MaterialTextView dueTxtView;
    private ImageButton editButton;
    private MaterialTextView description;

    public SubtaskViewHolder(@NonNull View v) {
        super(v);
        checkBox = v.findViewById(R.id.subtask_complete_checkbox);
        ttcClockImageView = v.findViewById(R.id.subtask_ttc_clock_imageview);
        dueImageView = v.findViewById(R.id.subtask_due_date_imageview);
        ttcTxtView = v.findViewById(R.id.subtask_ttc_textview);
        dueTxtView = v.findViewById(R.id.subtask_due_date_textview);
        editButton = v.findViewById(R.id.edit_subtask_button);
        description = v.findViewById(R.id.subtask_description_textview);

    }
}
