package com.example.priori_t.view.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.google.android.material.textview.MaterialTextView;

public class DayViewHolder extends RecyclerView.ViewHolder {
    private MaterialTextView day;

    public DayViewHolder(@NonNull View itemView) {
        super(itemView);
        day = (MaterialTextView)itemView.findViewById(R.id.dayTextView);
    }


}
