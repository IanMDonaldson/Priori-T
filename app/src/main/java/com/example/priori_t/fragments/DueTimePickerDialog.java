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
    TimePickerDialog.OnTimeSetListener onTimeSet;
    private Calendar calendar;
    public interface TimePickerListener {
        void onTimePicked(String time);
    }
    public static DueTimePickerDialog newInstance() { return new DueTimePickerDialog(); }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        //timePickerListener = (TimePickerListener)getActivity();

        return new TimePickerDialog(
                getActivity(),onTimeSet, hour, min,DateFormat.is24HourFormat(getActivity())
        );
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d(DueTimePickerDialog.class.getSimpleName(), String.format("Time(hh:mm): %d:%d", hourOfDay,minute));
        this.calendar.set(0,0,0,hourOfDay,minute);
        String formattedDate = dateFormatter.format(this.calendar.getTime());
        timePickerListener.onTimePicked(formattedDate);
    }
}
