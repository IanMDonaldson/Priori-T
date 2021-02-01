package com.example.priori_t.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DueTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private TimePickerListener timePickerListener;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm");
    private Calendar calendar;
    public static interface TimePickerListener {
        void onTimePicked(String time);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                getActivity(),this, hour, min, DateFormat.is24HourFormat(getActivity())
        );
        return timePickerDialog;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d(DueTimePickerDialog.class.getSimpleName(), String.format("Time(hh:mm): %d:%d", hourOfDay,minute));
        calendar.set(0,0,0,hourOfDay,minute);
        String formattedDate = dateFormatter.format(calendar.getTime());
        timePickerListener.onTimePicked(formattedDate);
    }
}
