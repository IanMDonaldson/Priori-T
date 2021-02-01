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
    private ImageButton editButton;
    private ImageView dueImageView;
    private ImageView ttcClockImageView;
    private MaterialCheckBox checkBox;
    private MaterialTextView mtcTextView;
    private MaterialTextView subtaskDescriptionTextView;

    public MaterialCheckBox getCheckBox() {
        return this.checkBox;
    }

    public void setCheckBox(MaterialCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public ImageView getTtcClockImageView() {
        return this.ttcClockImageView;
    }

    public void setTtcClockImageView(ImageView ttcClockImageView) {
        this.ttcClockImageView = ttcClockImageView;
    }

    public ImageView getDueImageView() {
        return this.dueImageView;
    }

    public void setDueImageView(ImageView dueImageView) {
        this.dueImageView = dueImageView;
    }

    public MaterialTextView getMtcTextView() {
        return this.mtcTextView;
    }

    public void setMtcTextView(MaterialTextView mtcTextView) {
        this.mtcTextView = mtcTextView;
    }

    public MaterialTextView getSubtaskDescriptionTextView() {
        return this.subtaskDescriptionTextView;
    }

    public void setSubtaskDescriptionTextView(MaterialTextView subtaskDescriptionTextView) {
        this.subtaskDescriptionTextView = subtaskDescriptionTextView;
    }

    public ImageButton getEditButton() {
        return this.editButton;
    }

    public void setEditButton(ImageButton editButton) {
        this.editButton = editButton;
    }

    public MaterialTextView getDescription() {
        return this.description;
    }

    public void setDescription(MaterialTextView description) {
        this.description = description;
    }

    private MaterialTextView description;

    public SubtaskViewHolder(@NonNull View v) {
        super(v);
        checkBox = v.findViewById(R.id.subtask_complete_checkbox);
        ttcClockImageView = v.findViewById(R.id.subtask_ttc_clock_imageview);
        dueImageView = v.findViewById(R.id.subtask_due_date_imageview);
        mtcTextView = v.findViewById(R.id.subtask_ttc_textview);
        subtaskDescriptionTextView = v.findViewById(R.id.subtask_description_textview);
        editButton = v.findViewById(R.id.edit_subtask_button);
    }
}
