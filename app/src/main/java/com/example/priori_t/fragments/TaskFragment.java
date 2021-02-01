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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.example.priori_t.model.TaskGenerator;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.view.TaskRecyclerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class TaskFragment extends Fragment {
    //todo define click listeners here
    //todo recyclerview initialization here
    /**/
    private TaskGenerator taskGen = new TaskGenerator();
    private TaskRecyclerAdapter taskRecyclerAdapter;

    private OnAddTaskClicked addTaskListener;

    public interface OnAddTaskClicked {
        public void onAddTaskClicked();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        this.taskRecyclerAdapter = new TaskRecyclerAdapter(this.getActivity(),taskGen.taskGenerator(5,3));
        recyclerView.setAdapter(this.taskRecyclerAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedStateInstance) {
        View view = inflater.inflate(R.layout.task_fragment,container,false);

        return view;
    }
    /*todo 1: define click listeners for task complete box, edit, and add subtask box, and add task button*/
    /*todo 2: have click listeners send data to each of the fragments associated with them*/
}
