package com.example.priori_t.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.priori_t.FragmentChangeListener;
import com.example.priori_t.R;
import com.example.priori_t.ui.DueDayPickerFragment;
import com.example.priori_t.database.entity.TaskEntity;
import com.google.android.material.textfield.TextInputEditText;

public class TaskCreationActivity extends AppCompatActivity implements FragmentChangeListener, DueDayPickerFragment.onDueDayBtnListener {
    public static final String EXTRA_TODO = "default";
    public TaskEntity taskEntity;
    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.add_task);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_place_holder, new DueDayPickerFragment());

        ft.commit();
    }

    /*public void onDueDateQuestionClicked() {
        TextInputEditText todoInput = findViewById(R.id.editTextTodoInsert);
        this.taskEntity = new TaskEntity();
        this.taskEntity.todo = (todoInput.getText().toString());
        Intent intent = new Intent(this, DueDayPickerFragment.class);
        intent.putExtra(EXTRA_TODO, taskEntity.todo);
    }*/
    @Override
    public void replaceFragment(Fragment fragment) {

    }
    public TaskEntity getTaskEntity() {
        return this.taskEntity;
    }

    @Override
    public void onButtonClicked(TaskEntity taskEntity) {

    }
}
