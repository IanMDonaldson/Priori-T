package com.example.priori_t;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.priori_t.fragment.DueDayPickerFragment;
import com.example.priori_t.model.Task;
import com.google.android.material.textfield.TextInputEditText;

public class TaskCreationActivity extends AppCompatActivity implements FragmentChangeListener, DueDayPickerFragment.onDueDayBtnListener {
    public static final String EXTRA_TODO = "default";
    public Task task;
    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.add_task);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_place_holder, new DueDayPickerFragment());

        ft.commit();
    }

    public void onDueDateQuestionClicked() {
        TextInputEditText todoInput = findViewById(R.id.editTextTodoInsert);
        this.task = new Task();
        this.task.todo = (todoInput.getText().toString());
        Intent intent = new Intent(this, DueDayPickerFragment.class);
        intent.putExtra(EXTRA_TODO, task.todo);
    }
    @Override
    public void replaceFragment(Fragment fragment) {

    }
    public Task getTask() {
        return this.task;
    }

    @Override
    public void onButtonClicked(Task task) {

    }
}
