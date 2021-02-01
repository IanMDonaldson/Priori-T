package com.example.priori_t.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;

public class DueDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static final String TAG = DueDatePickerDialog.class.getSimpleName();
    private Calendar calendar;
    private DatePickedListener datePickedListener;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

    public static interface DatePickedListener {
        void onDatePicked(String date);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        this.calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickedListener = (DatePickedListener) getActivity();

        return new DatePickerDialog(
                getActivity(), this, year, month, day
        );
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Log.d(TAG, String.format("Date(mm/dd/yyyy): %d/%d/%d", month, dayOfMonth, year));
        calendar.set(year,month,dayOfMonth,0,0);
        String formattedDate = dateFormatter.format(calendar.getTime());
        datePickedListener.onDatePicked(formattedDate);
    }


}
