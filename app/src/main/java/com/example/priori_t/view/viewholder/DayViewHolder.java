package com.example.priori_t.view.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.google.android.material.textview.MaterialTextView;

public class DayViewHolder extends RecyclerView.ViewHolder {
    public MaterialTextView getDay() {
        return this.day;
    }

    public void setDay(MaterialTextView day) {
        this.day = day;
    }

    private MaterialTextView day;

    public DayViewHolder(@NonNull View itemView) {
        super(itemView);
        this.day = (MaterialTextView)itemView.findViewById(R.id.dayTextView);
    }
    public void setDayViewText(String weekDay) {
        this.day.setText(weekDay);
    }


}
