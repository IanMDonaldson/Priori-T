package com.example.priori_t.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.example.priori_t.R;
import com.example.priori_t.TaskViewModel;
import com.example.priori_t.fragments.DueDatePickerDialog;
import com.example.priori_t.fragments.DueTimePickerDialog;
import com.example.priori_t.fragments.TaskFragment;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.view.TaskRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class TaskAddFragment extends Fragment implements DueDatePickerDialog.DatePickedListener,DueTimePickerDialog.TimePickerListener{
    private ViewModelProvider viewModelProvider;
    private static final String EXTRA_TASK = "newTask";
    private static final String EXTRA_TIME = "time";
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
    private ConstraintLayout fragmentTaskAdd;
    private TaskViewModel vm;
    /*
    *private DueDatePickerDialog dueDatePickerDialog;
    private DueTimePickerDialog dueTimePickerDialog;
    private TextInputEditText taskDescriptionEditText;
    private MaterialButton taskDueDateButton;
    private MaterialButton taskDueTimeButton;
    private MaterialButton saveButton;
    private TaskViewModel vm;
    public static TaskAddFragment newInstance() {
        TaskAddFragment fragment = new TaskAddFragment();
        Bundle args = new Bundle();
        //args.setArguments(Data that needs to be sent);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_add, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.taskDescriptionEditText = view.findViewById(R.id.task_description_edit_text);
    }
    * */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new ViewModelProvider(getActivity()).get(TaskViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_add,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.dueDayPickerButton = view.findViewById(R.id.task_due_date_button);
        this.dueTimePickerButton = view.findViewById(R.id.task_due_time_button);
        this.saveButton = view.findViewById(R.id.save_button);
        this.minutesPicker = view.findViewById(R.id.number_picker_minutes);
        this.hoursPicker = view.findViewById(R.id.number_picker_hours);
        this.taskDescription = view.findViewById(R.id.task_description_edit_text);
        this.fragmentTaskAdd = view.findViewById(R.id.fragment_task_add);
        this.hoursPicker.setMinValue(0);
        this.hoursPicker.setMaxValue(24);
        this.minutesPicker.setMinValue(0);
        this.minutesPicker.setMaxValue(59);

        dueDayPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DueDatePickerDialog datePicker = new DueDatePickerDialog().newInstance();

                datePicker.show(getParentFragmentManager(), EXTRA_TASK);
            }
        });
        dueTimePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DueTimePickerDialog timePicker = new DueTimePickerDialog();
                timePicker.show(getParentFragmentManager(), EXTRA_TIME);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDescriptionText = taskDescription.getText().toString();
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
                vm.addTask(task);
                fragmentTaskAdd.setVisibility(View.INVISIBLE);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_task_add, new TaskFragment());
                ft.commit();
            }
        });
    }

    private void initializeViews() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
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