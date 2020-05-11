package com.example.priori_t;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarViewAdapter extends RecyclerView.Adapter<CalendarViewAdapter.CalendarViewHolder>{
    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
