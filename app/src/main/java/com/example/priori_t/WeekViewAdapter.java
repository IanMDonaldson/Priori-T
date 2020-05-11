package com.example.priori_t;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

public class WeekViewAdapter extends RecyclerView.Adapter<WeekViewAdapter.WeekViewHolder> {
    public static class WeekViewHolder extends RecyclerView.ViewHolder {
        public WeekViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public WeekViewAdapter.WeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewAdapter.WeekViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
