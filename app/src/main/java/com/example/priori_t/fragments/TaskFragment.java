package com.example.priori_t.fragments;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import com.example.priori_t.R;
import com.example.priori_t.TaskViewModel;
import com.example.priori_t.activities.MainActivity;
import com.example.priori_t.model.TaskDB;
import com.example.priori_t.model.TaskDB_Impl;
import com.example.priori_t.model.TaskGenerator;
import com.example.priori_t.model.TaskRepository;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.view.TaskRecyclerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class TaskFragment extends Fragment {

    private TaskGenerator taskGen = new TaskGenerator();
    private TaskRecyclerAdapter taskRecyclerAdapter;
    private List<Task> taskEntities;
    private TaskDB taskDB;
    private TaskRepository taskRepository;
    private TaskViewModel vm;


    public void onAddTaskResult(Task task) {
        vm.addTask(task);
    }
    public TaskFragment() {

    }
//    public static TaskFragment newInstance(List<Task> tasks) {
//        TaskFragment taskFragment = new TaskFragment();
//        Bundle args = new Bundle();
//        args.putParcelable(tasks);
//        return taskFragment;
//    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vm = new ViewModelProvider(this).get(TaskViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        if (vm.getTaskList().getValue() == null ) {
            this.taskRecyclerAdapter = new TaskRecyclerAdapter(this.getActivity());
        } else {
            this.taskRecyclerAdapter = new TaskRecyclerAdapter(this.getActivity(), vm.getTaskList().getValue());
        }
        recyclerView.setAdapter(this.taskRecyclerAdapter);
        vm.getTaskList().observe(getViewLifecycleOwner(), new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                if (vm.getTaskList().getValue() == null ) {
                    taskRecyclerAdapter = new TaskRecyclerAdapter(getActivity());
                } else {
                    taskRecyclerAdapter = new TaskRecyclerAdapter(getActivity(), vm.getTaskList().getValue());
                }
                recyclerView.setAdapter(taskRecyclerAdapter);
            }
        });

    }

    private void onNewTasksReceived(List<Task> tasks) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedStateInstance) {
        View view = inflater.inflate(R.layout.task_fragment,container,false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    /*todo 1: define click listeners for task complete box, edit, and add  box, and add task button*/
    /*todo 2: have click listeners send data to each of the fragments associated with them*/
}
