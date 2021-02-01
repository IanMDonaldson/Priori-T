package com.example.priori_t.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.example.priori_t.R;
import com.example.priori_t.fragments.DueDatePickerDialog;
import com.example.priori_t.fragments.DueTimePickerDialog;
import com.example.priori_t.model.entity.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class TaskAddActivity extends AppCompatActivity implements DueDatePickerDialog.DatePickedListener,DueTimePickerDialog.TimePickerListener{
    private static final String EXTRA_TASK = "newTask";
    private MaterialButton dueDayPickerButton;
    private MaterialButton dueTimePickerButton;
    private MaterialButton saveButton;
    private Task task;
    private NumberPicker minutesPicker;
    private NumberPicker hoursPicker;
    private TextInputEditText taskDescription;
    private String taskDescriptionText;
    private String timePicked;
    private String datePicked;
    private static int minutes;
    private static int hours;
    private static TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task_add);
        this.dueDayPickerButton = findViewById(R.id.task_due_date_button);
        this.dueTimePickerButton = findViewById(R.id.task_due_time_button);
        this.saveButton = findViewById(R.id.save_button);
        this.minutesPicker = findViewById(R.id.number_picker_minutes);
        this.hoursPicker = findViewById(R.id.number_picker_hours);
        this.taskDescription = findViewById(R.id.task_description_edit_text);
        initializeViews();
    }
    private void initializeViews() {
        hoursPicker.setMinValue(0);
        hoursPicker.setMaxValue(24);
        minutesPicker.setMinValue(0);
        minutesPicker.setMaxValue(59);

        dueDayPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DueDatePickerDialog datePicker = new DueDatePickerDialog();
                datePicker.show(getSupportFragmentManager(), EXTRA_TASK);
            }
        });
        dueTimePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DueTimePickerDialog timePicker = new DueTimePickerDialog();
                timePicker.show(getSupportFragmentManager(), EXTRA_TASK);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDescriptionText = taskDescription.getText().toString();

                Intent intent = getIntent();
                Task task = new Task();
                //fill task with data from inputs

                task.setTodo(taskDescription.getText().toString());
                task.setComplete(false);
                //set minutes to complete
                hours = hoursPicker.getValue();
                minutes = (hours * 60) + minutesPicker.getValue();
                task.setMinToComplete(minutes);

                //set date and time due
                Calendar calendar = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                try {
                    Date dt = df.parse(datePicked + " " + timePicked);
                    calendar.setTime(dt);
                } catch (ParseException e ) {
                    e.printStackTrace();
                }
                task.setDueDate(Long.valueOf(calendar.getTimeInMillis()));
               ///
                intent.putExtra("newTask", task);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public void onDatePicked(String date) {
        this.datePicked = date;
    }

    @Override
    public void onTimePicked(String time) {
        this.timePicked = time;
    }
}